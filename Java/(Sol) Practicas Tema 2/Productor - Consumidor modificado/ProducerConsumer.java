package producerconsumer_sempahore;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    static final int BUFFER_SIZE = 10;
    static final int PRODUCERS = 1;
    static final int CONSUMERS = 2;
    static final int TO_CONSUME = 1000;
    static final int TO_PRODUCE = 1000;

    public static void main(String[] args) {
        Thread[] threads = new Thread[PRODUCERS + CONSUMERS];
        int t = 0, i;
        PCMonitor monitor = new PCMonitor(BUFFER_SIZE);
        Lock mutex = new ReentrantLock();
        Semaphore notEmpty = new Semaphore(0);
        Semaphore NotFull = new Semaphore(BUFFER_SIZE);

        for (i = 0; i < CONSUMERS; i++) {
            threads[t] = new Thread(new Consumer(i, monitor, TO_CONSUME, mutex, notEmpty, NotFull));
            threads[t].start();
            t++;
        }

        for (i = 0; i < PRODUCERS; i++) {
            threads[t] = new Thread(new Producer(i, monitor, TO_PRODUCE, mutex, notEmpty, NotFull));
            threads[t].start();
            t++;
        }

        for (i = 0; i < PRODUCERS + CONSUMERS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
            }
        }
    }

}

class Producer implements Runnable {

    PCMonitor monitor;
    int operations;
    Lock mutex;
    Semaphore notEmpty;
    Semaphore notFull;
    int id;

    public Producer(int i, PCMonitor mon, int ops, Lock m, Semaphore e, Semaphore f) {
        monitor = mon;
        operations = ops;
        mutex = m;
        notEmpty = e;
        notFull = f;
        id = i;
    }

    @Override
    public void run() {
        System.out.printf("Producer id: %d\n", id);

        for (int i = 0; i < operations; i++) {
            try {
                notFull.acquire();
                mutex.lock();
                try {
                    monitor.append(i);
                    System.out.printf("Producer %d : Add %d\n", id, i);
                    if (monitor.count == 10) {
                        notEmpty.release(10);
                    }
                } finally {
                    mutex.unlock();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.printf("Finished producer %d\n", id);
    }

}

class Consumer implements Runnable {

    PCMonitor monitor;
    int operations;
    Lock mutex;
    Semaphore notEmpty;
    Semaphore notFull;
    Semaphore p;
    Semaphore c;
    int id;

    public Consumer(int i, PCMonitor mon, int ops, Lock m, Semaphore e, Semaphore f) {
        monitor = mon;
        operations = ops;
        mutex = m;
        notEmpty = e;
        notFull = f;
        id = i;
    }

    @Override
    public void run() {
        Integer data;

        System.out.printf("Consumer id: %d\n", id);

        for (int i = 0; i < operations; i++) {
            try {
                notEmpty.acquire();
                mutex.lock();
                try {
                    data = monitor.take();
                    System.out.printf("Consumer: %d take %d\n", id, data);
                                        if (monitor.count == 0) {
                        notFull.release(10);
                    }
                } finally {
                    mutex.unlock();
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        System.out.printf("Finished consumer %d\n", id);
    }

}

class PCMonitor {

    int size, count = 0, in = 0, out = 0;
    Deque<Integer> buffer = new LinkedList<Integer>();

    public PCMonitor(int size) {
        this.size = size;
        this.count = 0;
    }

    public int take() {
        Integer data;
        data = buffer.remove();
        count--;
        return data;
    }

    public void append(Integer data) {
        buffer.add(data);
        count++;
    }
}
