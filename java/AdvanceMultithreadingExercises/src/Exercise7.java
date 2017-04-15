import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by priyanka on 13/4/17.
 */
public class Exercise7 {

    private List<String> queue = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Exercise7 pubSub = new Exercise7();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(() -> pubSub.publish());
        executor.execute(() -> pubSub.subscribe());
        executor.shutdown();
    }

    private void publish(){
        String message;
        for(int i = 0; i < 10; i++)
        {
            synchronized (this)
            {
                while (queue.size() == 3)
                {
// wait
                    try {
                        this.wait();
                    } catch (InterruptedException e) {}
                }
                message = UUID.randomUUID().toString();
                System.out.println(Thread.currentThread().getName()+": Publish......"+message);
                queue.add(message);
// notify sub
                this.notify();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void subscribe(){
        for(int i = 0; i < 10; i++) {
            synchronized (this) {
                while (queue.size() == 0) {
// wait
                    try {
                        this.wait();
                    } catch (InterruptedException e) {}
                }
                System.out.println(Thread.currentThread().getName() + ": Subscribe......" + queue.remove(0));
// notify pub
                this.notify();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

