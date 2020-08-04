package lesson5_multithreading.book.shildt.factoryMethodThread;

public class JoinThreads {

    public static void main(String[] args) {

        System.out.println("Start main thread.");

        MyThread2 myThread1 = MyThread2.createAndStart("My thread #1");
        MyThread2 myThread2 = MyThread2.createAndStart("My thread #2");
        MyThread2 myThread3 = MyThread2.createAndStart("My thread #3");

        try {
            myThread1.thread.join();
            System.out.println(myThread1.thread.getName() + " - join.");
            myThread2.thread.join();
            System.out.println(myThread2.thread.getName() + " - join.");
            myThread3.thread.join();
            System.out.println(myThread3.thread.getName() + " - join.");
        } catch (InterruptedException exception) {
            System.out.println("Interrupted main thread.");
        }

        System.out.println("End main thread.");
    }
}
