package lesson5_multithreading.book.shildt.standartThread;

public class MyThread implements Runnable {

    String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " - run.");
        try {
            for (int count = 0; count < 10; count++) {
            Thread.sleep(400);
                System.out.println(threadName + " count: " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(threadName + " - interrupted.");
        }
     }
}
