/**
 * Created by priyanka on 13/4/17.
 */



public class Exercise1 {



    static int counter = 0;


    public void printOdd() {


        synchronized (this) {
            for (int i = 0; i <5; i++) {


                while (counter % 2 == 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("odd :" + counter);
                counter++;
                this.notify();

            }
        }

    }


    public void printEven() {

        synchronized (this) {

            for (int i = 0; i <=5; i++) {

                while (counter % 2 != 0) {
                    try {
                        this.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("even :" + counter);
                counter++;
                this.notify();
              }

            }
        }

    public static void main(String[] args) {


        Exercise1 ex = new Exercise1();

        Thread thread = new Thread(() ->
                ex.printEven());

        Thread thread1 = new Thread(() ->
                ex.printOdd());

        thread.start();
        thread1.start();

        try {
            thread1.join();
            thread.join();
           }
           catch (InterruptedException e) {
            e.printStackTrace();
           }

       }








}
