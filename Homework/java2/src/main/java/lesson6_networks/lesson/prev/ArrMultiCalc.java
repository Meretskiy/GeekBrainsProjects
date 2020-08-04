package lesson6_networks.lesson.prev;

public class ArrMultiCalc {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] values;
    private float[] a1;
    private float[] a2;

    public ArrMultiCalc() {
        values = new float[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = 1;
        }

        a1 = new float[h];
        a2 = new float[h];
    }

    public void calc() {
        System.out.println("Multi forward calculation START");

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long earlyBirdStart = System.currentTimeMillis();

        Thread t1 = new Thread(() -> calc(values, 0, a1, 0, h, "First Half"));
        Thread t2 = new Thread(() -> calc(values, h, a2, 0, h, "Second Half"));

        t1.start();
        t2.start();

        try {
            // Ожиданием пока все потом завершаться, перед подсчетом затраченного времени
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis() - earlyBirdStart;

        System.out.println(String.format("Multi forward calculation executed within: %s", end));
        System.out.println("Multi forward calculation END");
    }

    private void calc(float[] src, int scrPos, float[] dest, int destPost, int lenght, String name) {
        System.out.println("Calculation started: " + name);
        long start = System.currentTimeMillis();
        //копирование в буфферный массив
        System.arraycopy(src, scrPos, dest, destPost, lenght);
        //Добавить копирование сюда
        for (int i = 0; i < dest.length; i++) {
            dest[i] = (float) (dest[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        //копирование в исходный массив
        System.arraycopy(dest, 0, src, scrPos, lenght);
        long end = System.currentTimeMillis() - start;
        System.out.println(String.format("Calculation %s executed within: %s", name, end));
    }
}
