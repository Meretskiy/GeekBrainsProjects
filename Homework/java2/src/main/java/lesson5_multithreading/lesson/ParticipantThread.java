package lesson5_multithreading.lesson;

public class ParticipantThread extends Thread {
    private String name;

    public ParticipantThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println(String.format("%s participant is running...", name));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
