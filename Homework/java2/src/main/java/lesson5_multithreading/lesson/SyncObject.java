package lesson5_multithreading.lesson;

public class SyncObject {
    private Object lock = new Object();

    public static void main(String[] args) {
        SyncObject syncObject = new SyncObject();
        new Thread(() -> syncObject.methodWithSyncBlock()).start();
        new Thread(() -> syncObject.methodWithSyncBlock()).start();
    }

    public void methodWithSyncBlock() {
        System.out.println("Block-1 begin");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Block-1 end");
        synchronized (lock) {
            System.out.println("Synch block begin");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Synch block end");
        }
        System.out.println("M2");
    }
}
