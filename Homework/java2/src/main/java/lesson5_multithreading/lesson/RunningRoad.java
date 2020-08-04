package lesson5_multithreading.lesson;

public class RunningRoad {
    public synchronized void occupy() {
        try {
            Thread.sleep(1000);
            System.out.println(String.format("Runner[%s] occupied road", Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
