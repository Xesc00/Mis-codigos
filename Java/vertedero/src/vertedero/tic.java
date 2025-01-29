package vertedero;

import java.util.concurrent.Semaphore;

public class tic extends Thread {

    Semaphore m1;
    Semaphore m2;

    public tic(Semaphore a, Semaphore b) {
        m1 = a;
        m2 = b;
    }
    /*Lock m1;
    Lock m2;

    public tic(Lock a, Lock b) {
        m1 = a;
        m2 = b;
    }*/

    @Override
    public void run() {
        try {
            //m1.lock();
            m1.acquire();
            System.out.println("-- TIC");
            m2.release();
            //m2.unlock();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}