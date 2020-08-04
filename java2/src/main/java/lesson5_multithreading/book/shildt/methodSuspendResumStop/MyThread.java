package lesson5_multithreading.book.shildt.methodSuspendResumStop;

public class MyThread implements Runnable {

    Thread thread;
    boolean suspended;
    boolean stopped;

    MyThread(String name) {
        thread = new Thread(this, name);
        suspended = false;
        stopped = false;
    }

    public static MyThread createAndStart(String name) {

        MyThread myThread = new MyThread(name);
        myThread.thread.start();
        return myThread;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " - run.");
        try {
            for (int i = 0; i < 1000; i++) {
                System.out.print(i + " ");
                if ((i % 10) == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }

                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) {
                        break;
                    }
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thread.getName() + " interrupted");
        }

        System.out.println(thread.getName() + " - exit.");
    }

    synchronized void mystop() {
        stopped = true;
        suspended = false;
        notify();
    }

    synchronized void mysuspend() {
        suspended = true;
    }

    synchronized void myresume() {
        suspended = false;
        notify();
    }
}
