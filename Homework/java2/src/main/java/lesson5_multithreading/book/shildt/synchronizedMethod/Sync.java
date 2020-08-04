package lesson5_multithreading.book.shildt.synchronizedMethod;

public class Sync {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};

        MyThread mt1 = MyThread.createAndStart("Thread #1", array);
        MyThread mt2 = MyThread.createAndStart("Thread #2", array);

        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException exception) {
            System.out.println("Interrupted main thread.");
        }
    }
}
