package lesson5_multithreading.book.Sierra;

public class Main {

    public static void main(String[] args) {

        System.out.println("main!!");
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("main!!");
        }

    }
}
