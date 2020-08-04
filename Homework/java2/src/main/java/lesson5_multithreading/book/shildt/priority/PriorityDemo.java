package lesson5_multithreading.book.shildt.priority;

public class PriorityDemo {

    public static void main(String[] args) {

        Priority mt1 = new Priority("High priority");
        Priority mt2 = new Priority("Low priority");
        Priority mt3 = new Priority("Small high priority");
        Priority mt4 = new Priority("Small low priority");
        Priority mt5 = new Priority("Main priority");

        mt1.thread.setPriority(Thread.MAX_PRIORITY);
        mt2.thread.setPriority(Thread.MIN_PRIORITY);
        mt3.thread.setPriority(Thread.NORM_PRIORITY + 1);
        mt4.thread.setPriority(Thread.NORM_PRIORITY - 1);
        mt5.thread.setPriority(Thread.NORM_PRIORITY);

        mt1.thread.start();
        mt2.thread.start();
        mt3.thread.start();
        mt4.thread.start();
        mt5.thread.start();

        try {
            mt1.thread.join();
            mt2.thread.join();
            mt3.thread.join();
            mt4.thread.join();
            mt5.thread.join();

        } catch (InterruptedException exception) {
            System.out.println("Interrupted main thread");
        }

        System.out.println("Count high priority: " + mt1.count);
        System.out.println("Count low priority: " + mt2.count);
        System.out.println("Count small high priority: " + mt3.count);
        System.out.println("Count small low priority: " + mt4.count);
        System.out.println("Count normal priority: " + mt5.count);
    }
}
