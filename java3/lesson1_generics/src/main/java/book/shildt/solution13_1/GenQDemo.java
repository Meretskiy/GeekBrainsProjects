package book.shildt.solution13_1;

public class GenQDemo {

    public static void main(String[] args) {

        doTestIntegerQueue();
        doTestDoubleQueue();
    }

    public static void doTestDoubleQueue() {

        Double[] dStore = new Double[10];
        GenQueue<Double> q2 = new GenQueue<>(dStore);
        Double dVal;
        System.out.println("Demonstration queue double number:");

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Put " + (double) i / 2 + " in queue q2.");
                q2.put((double) i / 2);
            }
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("Get next value in double queue q2: ");
                dVal = q2.get();
                System.out.println(dVal);
            }
        } catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();
    }

    public static void doTestIntegerQueue() {

        Integer[] iStore = new Integer[10];
        GenQueue<Integer> q = new GenQueue<>(iStore);
        Integer iVal;
        System.out.println("\nDemonstration queue integer number:");

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Put " + i + " in queue q.");
                q.put(i);
            }
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("Get next value in integer queue q: ");
                iVal = q.get();
                System.out.println(iVal);
            }
        } catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();
    }
}
