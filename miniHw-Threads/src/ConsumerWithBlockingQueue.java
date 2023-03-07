import javax.swing.*;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class ConsumerWithBlockingQueue implements Runnable {
    private BlockingQueue<Integer> queue;
    private final int lastElement;
    private final Object mutex;

    ConsumerWithBlockingQueue(BlockingQueue<Integer> queue, int lastElement, Object mutex) {
        this.queue = queue;
        this.lastElement = lastElement;
        this.mutex = mutex;
    }

    public void run() {
        try {
            getNumbers();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void getNumbers() throws InterruptedException {
        while (true) {
            var value = queue.take();
            if (value.equals(lastElement)) {
                return;
            }
            synchronized (mutex) {
                System.out.println(Thread.currentThread().getName() + ". Consumer get number " + value);
            }
            // Thread.sleep(1000);
        }
    }
}
