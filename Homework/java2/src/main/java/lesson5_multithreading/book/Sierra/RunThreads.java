package lesson5_multithreading.book.Sierra;

public class RunThreads implements Runnable{

    public static void main(String[] args) {

        RunThreads runner = new RunThreads();
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);
        alpha.setName("alpha");
        beta.setName("beta");
        alpha.start();
        beta.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println("Run " + threadName);
        }
    }
}
