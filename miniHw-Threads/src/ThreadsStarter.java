import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadsStarter {

    public void start() {
        int bufferSize = 16;
        int lastElement = -1;
        int elementCount = 30;
        Object mutex = new Object();

        int type = printConditions();

        Runnable producer, consumer;

        if (type == 1) {
            BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(bufferSize);
            producer = new ProducerWithBlockingQueue(queue, elementCount, lastElement, mutex);
            consumer = new ConsumerWithBlockingQueue(queue, lastElement, mutex);
        } else {
            Deque<Integer> queue = new ArrayDeque<>(bufferSize);
            producer = new ProducerWithSimpleQueue(queue, elementCount, lastElement, mutex, bufferSize);
            consumer = new ConsumerWithSimpleQueue(queue, lastElement, mutex, bufferSize);
        }

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            consumerThread.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private int printConditions() {
        System.out.println("Выберете способ реализации конструкции производитель/потребитель:\n" +
                "1. Основанная на потокобезопасной очереди BlockingQueue\n" +
                "2. Основанная на Deque, с использованием примитивов синхронизации\n" +
                "(Введите 1 или 2, в ином случае разработчик не несет ответственности за действия программы)");

        Scanner in = new Scanner(System.in);
        int val = in.nextInt();
        in.close();
        return val;
    }
}
