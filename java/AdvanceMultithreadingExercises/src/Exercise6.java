import java.util.Random;

/**
 * Created by priyanka on 15/4/17.
 */
public class Exercise6 extends Thread {

    private int[] arr;

    private int low, high, partialMax;

    public Exercise6(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = Math.min(high, arr.length);
    }

    public int getPartialMax() {
        return partialMax;
    }

    public void run() {
        partialMax = findMax(arr, low, high);
    }

    public static int findMax(int[] arr) {
        return findMax(arr, 0, arr.length);
    }

    public static int findMax(int[] arr, int low, int high) {
        int max = arr[0];

        for (int i = low; i < high; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }

        return max;
    }

    public static int ConcurrentMax(int[] arr, int threads) {
        int size = (int) Math.ceil(arr.length * 1.0 / threads);

        Exercise6[] maximums = new Exercise6[threads];

        for (int i = 0; i < threads; i++) {
            maximums[i] = new Exercise6(arr, i * size, (i + 1) * size);
            maximums[i].start();
        }

        try {
            for (Exercise6 max : maximums) {
                max.join();
            }
        } catch (InterruptedException e) { }

        int max = maximums[0].getPartialMax();

        for (Exercise6 parMax : maximums) {
            if(max<parMax.getPartialMax()){
                max = parMax.getPartialMax();
            }
        }

        return max;
    }


    public static final int THREADS = 4;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(101) + 1; // 1..100
        }

        for (int a: arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
        System.out.println("Max value is: "+ Exercise6.ConcurrentMax(arr, THREADS));
    }
}
