package lesson5_multithreading.book.shildt.factoryMethodThread;

public class MoreThreads {

    public static void main(String[] args) {

        System.out.println("Start main thread.");

        MyThread2 myThread1 = MyThread2.createAndStart("My thread #1");
        MyThread2 myThread2 = MyThread2.createAndStart("My thread #2");
        MyThread2 myThread3 = MyThread2.createAndStart("My thread #3");

        do {
            System.out.print(".");

            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                System.out.println("Interrupted main thread.");
            }
        } while (myThread1.thread.isAlive() || myThread2.thread.isAlive() || myThread3.thread.isAlive());

        System.out.println("End main thread.");
    }
}
