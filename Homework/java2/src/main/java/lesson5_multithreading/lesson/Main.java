package lesson5_multithreading.lesson;

public class Main {

    public static void main(String[] args) {
        RunningRoad runningRoad = new RunningRoad();
        Runner runner1 = new Runner("Tom Runner", runningRoad);
        Runner runner2 = new Runner("Fast Bob", runningRoad);
        Runner runner3 = new Runner("Lazy Timmy Cow", runningRoad);

        new Thread(runner1).start();
        new Thread(runner2).start();
        new Thread(runner3).start();
    }

    static void doMultithreadIntroDemo() {
        Thread mike = new Thread(new Participant("Mike"));
        Thread john = new ParticipantThread("John");
        mike.start();
        john.start();
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());

        System.out.println(mike.getPriority());
        System.out.println(mike.getId());
        System.out.println(mike.getName());
        System.out.println(john.getPriority());
    }

}
