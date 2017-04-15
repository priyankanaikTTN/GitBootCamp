/**
 * Created by priyanka on 13/4/17.
 */
public class Exercise10 {


        private volatile static int counter = 0;

        public static void main(String[] args) throws InterruptedException

        {
            long startTime = System.currentTimeMillis();

            Exercise10 counter=new Exercise10();

            int n=5;

            for (int i = 0; i < n; i++) {

                Thread thread = new Thread(()->
                {
                    for (int j = 0; j < 1000; j++)
                    {
                        counter.increment();
                    }
                });

                thread.start();
                thread.join();


            }


            long endTime = System.currentTimeMillis();

            System.out.println("Counter: "+Exercise10.counter);


            System.out.println("Total time taken(in millis): "+(endTime-startTime));
        }

        public   void increment() {
            //counter++;

            synchronized(Exercise10.class) {
                int temp = counter; // reading counter value
                temp = temp + 1; // increment the value by 1
                counter = temp; // writing back to counter
            }


        }

    }



