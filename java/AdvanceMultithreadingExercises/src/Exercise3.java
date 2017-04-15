/**
 * Created by priyanka on 13/4/17.
 */
public class Exercise3 {

    static boolean first = true;
    static boolean second = false;
    static boolean third = false;
    static int i =0;

    public void print() throws InterruptedException

    {
        while(i<10) {
            synchronized (this)
            {
                if(Thread.currentThread().getName().equals("1") )
                {
                    if(!first)
                        this.wait();
                    else
                    {System.out.println("1");
                    first=false;
                    second=true;
                    third=false;
                    this.notifyAll();
                    this.wait();
                    i++;}
                }
                if(Thread.currentThread().getName().equals("2") )
                {
                    if(!second)
                        this.wait();
                    else
                    {System.out.println("2");
                        first=false;
                        second=false;
                        third=true;
                        this.notifyAll();
                        this.wait();
                        i++;}
                }
                if(Thread.currentThread().getName().equals("3"))
                {
                    if(!third)
                        this.wait();
                    else
                    {System.out.println("3");
                        first=true;
                        second=false;
                        third=false;
                        this.notifyAll();
                        this.wait();
                        i++;}
                }


                this.notifyAll();
            }

        }




    }


    public static void main(String[] args) throws InterruptedException {


         Exercise3 ex= new Exercise3();

        Thread t1 = new Thread(()->{
            try {
                ex.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "1");

        Thread t2= new Thread(()->{
            try {
                ex.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "2");

        Thread t3= new Thread(()->{
            try {
                ex.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

      //Thread.currentThread().notifyAll();




    }








}
