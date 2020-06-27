package homework13;

public class MainClass {

    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) {

        doCalculationOneThread(createArray());
        doCalculationTwoThread(createArray());
    }

    private static float[] createArray() {

        float[] arr = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        return arr;
    }

    public static void doCalculationOneThread(float[] arr) {

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Time one thread: " + (System.currentTimeMillis() - a));
    }

    public static void doCalculationTwoThread(float[] arr) {

        float[] arrayOne = new float[H];
        float[] arrayTwo = new float[H];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arrayOne, 0, H);
        System.arraycopy(arr, H, arrayTwo, 0, H);

        CalculationInArray calculationInArrayOne = new CalculationInArray(arrayOne);
        Thread threadOne = new Thread(calculationInArrayOne);
        threadOne.start();

        CalculationInArray calculationInArrayTwo = new CalculationInArray(arrayTwo);
        Thread threadTwo = new Thread(calculationInArrayTwo);
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.arraycopy(arrayOne, 0, arr, 0, H);
        System.arraycopy(arrayTwo, 0, arr, H, H);

        System.out.println("Time two thread: " + (System.currentTimeMillis() - a));
    }
}
