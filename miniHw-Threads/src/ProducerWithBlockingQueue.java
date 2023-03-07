import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerWithBlockingQueue implements Runnable {
    private BlockingQueue<Integer> queue;
    private final int count;
    private final int lastElement;
    private final Object mutex;

    public ProducerWithBlockingQueue(BlockingQueue<Integer> queue, int count, int lastElement, Object mutex) {
        this.queue = queue;
        this.count = count;
        this.lastElement = lastElement;
        this.mutex =  mutex;
    }

    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void generateNumbers() throws InterruptedException {
        for (int i = 0; i < count; ++i) {
            Integer val = ThreadLocalRandom.current().nextInt(50);
            queue.put(val);
            synchronized (mutex) {
                System.out.println(Thread.currentThread().getName() + ". Producer generated number " + val);
            }
            // Thread.sleep(1000);
        }

        queue.put(lastElement);
    }
}
