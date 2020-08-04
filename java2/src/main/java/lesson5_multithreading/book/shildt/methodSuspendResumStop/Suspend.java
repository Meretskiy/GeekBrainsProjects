package lesson5_multithreading.book.shildt.methodSuspendResumStop;

public class Suspend {

    public static void main(String[] args) {

        MyThread myThread = MyThread.createAndStart("My thread");

        try {
            Thread.sleep(1000);

            myThread.mysuspend();
            System.out.println("Suspend threat");
            Thread.sleep(1000);

            myThread.myresume();
            System.out.println("Resume thread.");
            Thread.sleep(1000);

            myThread.mysuspend();
            System.out.println("Suspend threat");
            Thread.sleep(1000);

            myThread.myresume();
            System.out.println("Resume thread.");
            Thread.sleep(1000);

            myThread.myresume();
            System.out.println("Stop thread.");
            myThread.mystop();

        } catch (InterruptedException exception) {
            System.out.println("Interrupted main thread");
        }

        try {
            myThread.thread.join();
        } catch (InterruptedException exception) {
            System.out.println("Interrupted main thread");
        }

        System.out.println("End main thread.");
    }
}
