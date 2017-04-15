import java.util.Random;

/**
 * Created by priyanka on 15/4/17.
 */


    public class Exercise5 extends Thread {
        private int[] arr;

        private int low, high, partial;

        public Exercise5(int[] arr, int low, int high) {
            this.arr = arr;
            this.low = low;
            this.high = Math.min(high, arr.length);
        }

        public int getPartialSum() {
            return partial;
        }

        public void run() {
            partial = sum(arr, low, high);
        }

        public static int sum(int[] arr) {
            return sum(arr, 0, arr.length);
        }

        public static int sum(int[] arr, int low, int high) {
            int total = 0;

            for (int i = low; i < high; i++) {
                total += arr[i];
            }

            return total;
        }

        public static int ConcurrentSum(int[] arr, int threads) {
            int size = (int) Math.ceil(arr.length * 1.0 / threads);

            Exercise5[] sums = new Exercise5[threads];

            for (int i = 0; i < threads; i++) {
                sums[i] = new Exercise5(arr, i * size, (i + 1) * size);
                sums[i].start();
            }

            try {
                for (Exercise5 sum : sums) {
                    sum.join();
                }
            } catch (InterruptedException e) { }

            int total = 0;

            for (Exercise5 sum : sums) {
                total += sum.getPartialSum();
            }

            return total;
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
            System.out.println("Sum is: "+Exercise5.ConcurrentSum(arr, THREADS));
        }
}
