package ru.meretskiy.homework17;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> container = new ArrayList<>();

    public void add(T fruit) {
        container.add(fruit);
    }

    public double getWeight() {

        double sum = 0.0;

        for (T fruit : container) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public void moveAllTo(Box<T> anotherBox) {

        if (anotherBox == null) {
            return;
        }

        if (this.container.isEmpty()) {
            return;
        }

        if (this == anotherBox) {
            return;
        }

        anotherBox.container.addAll(this.container);
        this.container.clear();
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

}
