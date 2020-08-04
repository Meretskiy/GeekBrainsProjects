package lesson5_multithreading.book.shildt.extendThread;

public class ExtendThreat {

    public static void main(String[] args) {

        System.out.println("Start main thread");

//        MyThread myThread = new MyThread("My thread #1");
//        myThread.start();

        MyThread.createAndStart("My thread #1");

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
