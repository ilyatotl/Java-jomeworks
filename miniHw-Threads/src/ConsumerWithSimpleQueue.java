import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;

public class ConsumerWithSimpleQueue implements Runnable {
    private Deque<Integer> queue;
    private final int lastElement;
    private final Object mutex;
    private final int bufferSize;

    ConsumerWithSimpleQueue(Deque<Integer> q, int lastElement, Object m, int bufSize) {
        this.queue = q;
        this.lastElement = lastElement;
        this.mutex = m;
        this.bufferSize = bufSize;
    }

    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void generateNumbers() throws InterruptedException {
        while (true) {
            while (queue.isEmpty()) {
                // Thread.sleep(1);
            }
            synchronized (mutex) {
                var value = queue.pop();
                if (value.equals(lastElement)) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + ". Consumer get number " + value);
            }
        }
    }
}
