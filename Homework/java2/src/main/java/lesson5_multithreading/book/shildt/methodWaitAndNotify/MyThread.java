package lesson5_multithreading.book.shildt.methodWaitAndNotify;

public class MyThread implements Runnable {

    Thread thread;
    TickTock tickTockOb;

    MyThread(String name, TickTock tt) {
        thread = new Thread(this, name);
        tickTockOb = tt;
    }

    public static MyThread createAndStart(String name, TickTock tt) {

        MyThread myThread = new MyThread(name, tt);
        myThread.thread.start();
        return myThread;
    }

    @Override
    public void run() {

        if (thread.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) {
                tickTockOb.tick(true);
            }

            tickTockOb.tick(false);
        } else {
            for (int i = 0; i < 5; i++) {
                tickTockOb.tock(true);
            }

            tickTockOb.tock(false);
        }
    }
}
