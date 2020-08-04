package lesson5_multithreading.book.shildt.synchronizedMethod;

public class MyThread implements Runnable {

    Thread thread;
    static SumArray sumArray = new SumArray();
    int[] array;
    int answer;

    MyThread(String name, int[] nums) {

        thread = new Thread(this, name);
        array = nums;
    }

    public static MyThread createAndStart(String name, int[] nums) {

        MyThread myThread = new MyThread(name, nums);
        myThread.thread.start();
        return myThread;
    }

    @Override
    public void run() {
        int sum;

        System.out.println(thread.getName() + " - run.");

        /**
         * Можно синхронизировать только блок кода если не
         * можем синхронизировать весь метод так как класс
         * не доступен для изменений
         */
    //    synchronized (sumArray) {
            answer = sumArray.sumArray(array);
    //    }

        System.out.println("Sum " + thread.getName() + " " + answer);

        System.out.println(thread.getName() + " end.");
    }
}
