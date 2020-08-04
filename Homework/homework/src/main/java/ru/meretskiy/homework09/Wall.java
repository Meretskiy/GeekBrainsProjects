package ru.meretskiy.homework09;

public class Wall implements Trials {

    private double height;

    public Wall() {
        height = Math.random()*1.5 + 0.5;
    }

    @Override
    public void info() {
        System.out.printf("Height: %.2fm\n", height);
    }

    @Override
    public boolean action(Participant n) {
        boolean isDone;
        if (n.getMaxJump() > height) {
            isDone = true;
            System.out.printf("Participant %s jumped over a wall height %.2fm!\n",
                    n.getName(), height);
        } else {
            isDone = false;
            System.out.printf("Participant %s did not jump over a wall height %.2fm!\n",
                    n.getName(), height);
        }

        return isDone;
    }
}
