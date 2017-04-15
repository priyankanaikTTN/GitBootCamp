/**
 * Created by priyanka on 13/4/17.
 */
public class Exercise4 extends Thread {

    @Override
    public void run() {
        super.run();
        count((Exercise4) Thread.currentThread(),0);
    }

    public static void count(Exercise4 ex,int count)
    {
        if(count!=10) {
            Exercise4 ex1 = new Exercise4();
            ++count;
            count(ex1,count);
        }

            System.out.println("Hello from :"+ex.getName());



    }

    public static void main(String[] args) {




        Exercise4 ex= new Exercise4();
        ex.start();
    }
}
