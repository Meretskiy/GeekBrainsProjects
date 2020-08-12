package ru.meretskiy.homework21_concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private static CyclicBarrier cyclicBarrier;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public static CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public static void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        Car.cyclicBarrier = cyclicBarrier;
    }

    public static AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        atomicInteger.incrementAndGet();
        if (atomicInteger.get() == 1) {
            System.out.println(this.name + " WIN!!!");
        }
    }
}
