package lesson5_multithreading.book.shildt.synchronizedMethod;

public class SumArray {

    private int sum;

    synchronized int sumArray(int[] nums) {

        sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Current cost sum " + Thread.currentThread().getName() + " " + sum);

            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                System.out.println("Thread interrupted.");
            }
        }

        return sum;
    }
}
