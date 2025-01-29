package productorconsumidor;

import java.util.concurrent.Semaphore;

class Consumer implements Runnable {
    PCMonitor monitor;
    int operations;
    Semaphore S1, S2;

    public Consumer(PCMonitor mon, int ops, Semaphore produc, Semaphore consum) {
        monitor = mon;
        operations = ops;
        S1 = produc;
        S2 = consum;
    }

    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        Integer data;
        
        try{
            S2.acquire();
            System.out.printf("Consumer %d\n", id);

         for (int i = 0;  i < operations; i++ ) {
            data = monitor.take();
            System.out.printf("%d take %d\n", id, data);
            }

            System.out.printf("Finished consumer %d\n", id);
            System.out.println(" ");
            S1.release();
            
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }   
    }
}
