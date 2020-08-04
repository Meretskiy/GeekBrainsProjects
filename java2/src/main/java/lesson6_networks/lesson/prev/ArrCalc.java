package lesson6_networks.lesson.prev;

public class ArrCalc {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] values;

    public ArrCalc() {
        values = new float[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = 1;
        }
    }

    public void calc() {
        System.out.println("Straight forward calculation START");

        long a = System.currentTimeMillis();

        for (int i = 0; i < values.length; i++) {
            values[i] = (float)(values[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(String.format("Straight forward calculation executed within: %s", System.currentTimeMillis() - a));
        System.out.println("Straight forward calculation END");
    }
}
