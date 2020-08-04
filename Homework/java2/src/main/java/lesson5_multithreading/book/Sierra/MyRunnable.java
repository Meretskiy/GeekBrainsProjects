package lesson5_multithreading.book.Sierra;

import static java.lang.Thread.sleep;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
        System.out.println("in run!!!!!");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
