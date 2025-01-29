package vertedero;

import java.util.concurrent.Semaphore;

public class tac extends Thread {

    Semaphore m1;
    Semaphore m2;

    public tac(Semaphore a, Semaphore b) {
        m1 = a;
        m2 = b;
    }
    /*Lock m1;
    Lock m2;

    public tac(Lock a, Lock b) {
        m1 = a;
        m2 = b;
    }*/

    @Override
    public void run() {
        try {
            //m2.lock();
            m2.acquire();
            System.out.println("-- TAC");
            m1.release();
            //m1.unlock();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}