package lesson5_multithreading.lesson;

public class Runner implements Runnable {
    private String name;
    private RunningRoad runningRoad;

    public Runner(String name, RunningRoad runningRoad) {
        this.name = name;
        this.runningRoad = runningRoad;
    }

    @Override
    public void run() {
//        System.out.println(String.format("Runner[%s] is running ...", name));
        runningRoad.occupy();
        System.out.println(String.format("Runner-T[%s] is running ...", Thread.currentThread().getName()));
        System.out.println("Releasing...");
    }
}
