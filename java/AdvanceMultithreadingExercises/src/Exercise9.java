/**
 * Created by priyanka on 13/4/17.
 */


class Thread2 extends Thread
{   int c;
    static int count;

    public Thread2(int c , int count)
    {
        this.c =c;
        this.count=count;
    }

    @Override
    public void run() {

        count(c, (Thread2) Thread.currentThread());
    }


    public static void count(int c, Thread2 thread)
    {

        for(int i=c;i<=10;i=i+count)
        {
            System.out.println("Thread " + c +" : " +i);
        }
    }
}
public class Exercise9 {
    public static void main(String[] args) {

        int n=4;
        for (int i = 1; i <=n; i++) {
            Thread2 thread2 = new Thread2(i,n);
            thread2.start();
        }
    }
}
