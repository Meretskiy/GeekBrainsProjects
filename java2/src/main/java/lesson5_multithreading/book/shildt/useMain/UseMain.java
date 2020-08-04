package lesson5_multithreading.book.shildt.useMain;

public class UseMain {

    public static void main(String[] args) {

        Thread thread;
        thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        thread.setPriority(Thread.NORM_PRIORITY+3);
        System.out.println(thread.getPriority());
    }
}
