package lesson5_multithreading.book.shildt.factoryMethodThread;

public class ThreadVariations {

    public static void main(String[] args) {

        System.out.println("Start main thread.");

        MyThread2 myThread2 = MyThread2.createAndStart("My thread #1");

        for (int i = 0; i < 50; i++) {
            System.out.print(".");

            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                System.out.println("Interrupted main thread.");
            }
        }

        System.out.println("End main thread.");
    }
}
