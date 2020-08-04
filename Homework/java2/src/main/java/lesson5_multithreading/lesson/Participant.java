package lesson5_multithreading.lesson;

public class Participant implements Runnable {
    private String name;

    public Participant(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
                System.out.println(String.format("%s is running ...", name));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
