package lesson5_multithreading.book.shildt.factoryMethodThread;

public class MyThread2 implements Runnable{

    Thread thread;

    MyThread2(String name) {
        thread = new Thread(this, name);
    }

    //Factory method
    public static MyThread2 createAndStart(String name) {

        MyThread2 myThread2 = new MyThread2(name);
        myThread2.thread.start();
        return myThread2;
    }

    @Override
    public void run() {

        System.out.println(thread.getName() + " - run.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println(thread.getName() + " count: " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(thread.getName() + " interrupted.");
        }

        System.out.println(thread.getName() + " - end.");
    }
}
