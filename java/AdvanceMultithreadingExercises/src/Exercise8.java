import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by priyanka on 14/4/17.
 */

public class Exercise8{
    private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);


    public static void main(String[] args) throws InterruptedException {
        Exercise8 pubSub = new Exercise8();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(() -> pubSub.publish());
        executor.execute(() -> pubSub.subscribe());
        executor.shutdown();
    }



    public void subscribe() {
        for (int i = 0; i < 5; i++) {
            String message = "";
            try {
                message = queue.take();
            } catch (InterruptedException e) {
            }
            System.out.println(i + ". Message subscribed..." + message);
        }
    }

    public void publish() {
        for (int i = 0; i < 5; i++) {
            String message = UUID.randomUUID().toString();
            try {
                queue.put(message);
            } catch (InterruptedException e) {
            }
            System.out.println(i + ". Message published..." + message);
        }
    }
    }