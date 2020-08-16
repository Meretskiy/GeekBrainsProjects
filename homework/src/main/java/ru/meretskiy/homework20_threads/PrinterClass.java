package ru.meretskiy.homework20_threads;

/**
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
 * (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
 */

public class PrinterClass {

    private static final int ITERATION = 5;
    private final Object monitor = new Object();
    private static volatile int currentOperation = 1;

    public static void main(String[] args) {
        doTaskOne();
    }

    public static void doTaskOne() {
        PrinterClass pc = new PrinterClass();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < ITERATION; i++) {
                pc.printA();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < ITERATION; i++) {
                pc.printB();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < ITERATION; i++) {
                pc.printC();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void printA() {
        synchronized (monitor) {
            while (currentOperation != 1) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A");
            currentOperation = 2;
            monitor.notifyAll();
        }
    }

    public void printB() {
        synchronized (monitor) {
            while (currentOperation != 2) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("B");
            currentOperation = 3;
            monitor.notifyAll();
        }
    }

    public void printC() {
        synchronized (monitor) {
            while (currentOperation != 3) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("C");
            currentOperation = 1;
            monitor.notifyAll();
        }
    }
}


