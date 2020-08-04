package lesson5_multithreading.book.shildt.extendThread;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " run.");

        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println(getName() + " count " + count);
            }
        } catch (InterruptedException exception) {
            System.out.println(getName() + " interrupted.");
        }

        System.out.println(getName() + " end.");
    }

    public static MyThread createAndStart(String name) {

        MyThread myThread = new MyThread(name);
        myThread.start();
        return myThread;
    }
}
