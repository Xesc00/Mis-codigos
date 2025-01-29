package productorconsumidor;

import java.util.concurrent.Semaphore;

class Producer implements Runnable {
    PCMonitor monitor;
    int operations;
    Semaphore S1, S2;

    public Producer(PCMonitor mon, int ops, Semaphore produc, Semaphore consum) {
        monitor = mon;
        operations = ops;
        S1 = produc;
        S2 = consum;
    }

    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        System.out.printf("Producer %d\n", id);
        try{
            S1.acquire();
            for (int i = 0; i < operations; i++ ) {
                monitor.append(i);
                System.out.printf("%d producer add: %d\n", id, i);
            }
            
            System.out.printf("Finished producer %d\n", id);
            System.out.println(" ");
            S2.release();
            
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}