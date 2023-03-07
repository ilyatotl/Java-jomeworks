import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerWithSimpleQueue implements Runnable {
    private Deque<Integer> queue;
    private final int count;
    private final int lastElement;
    private final Object mutex;
    private final int bufferSize;

    ProducerWithSimpleQueue(Deque<Integer> q, int count, int lastElement, Object m, int bufSize) {
        this.queue = q;
        this.count = count;
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
        for (int i = 0; i < count; ++i) {
            while (queue.size() == bufferSize) {
                // Thread.sleep(5);
            }
            Integer val = ThreadLocalRandom.current().nextInt(50);
            synchronized (mutex) {
                queue.addLast(val);
                System.out.println(Thread.currentThread().getName() + ". Producer generated number " + val);
            }
        }

        while (queue.size() == bufferSize) {
            // Thread.sleep(1);
        }
        synchronized (mutex) {
            queue.add(lastElement);
        }
    }
}
