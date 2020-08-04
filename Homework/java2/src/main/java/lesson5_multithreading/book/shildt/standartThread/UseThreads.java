package lesson5_multithreading.book.shildt.standartThread;

public class UseThreads {

    public static void main(String[] args) {

        System.out.println("Run main threads.");

        MyThread myThread = new MyThread("My thread");
        Thread newThread = new Thread(myThread);
        newThread.start();

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Interrupted main thread.");
            }
        }

        System.out.println("End main thread.");
    }
}
