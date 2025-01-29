package tema2fills.puente;

public class Contador {

    int nNS;
    int nSN;
    int npN;
    int npS;

    public Contador() {
        nNS = 0;
        nSN = 0;
        npN = 0;
        npS = 0;
    }

    synchronized void entraN() throws InterruptedException {
        while (nSN > 0  || npS > 0) {
            wait();
        }
        nNS++;
    }

    synchronized void salS() {
        nNS--;
        notifyAll();
    }

    synchronized void entraS() throws InterruptedException {
        while (nNS > 0  || npN > 0) {
            wait();
        }
        nSN++;
    }

    synchronized void SaleN() {
        nSN--;
        notifyAll();
    }

    synchronized void entraPrioritarioN() throws InterruptedException {
        npN++;
        while (nSN > 0) {
            wait();
        }
        npN--;
        nNS++;
    }

    synchronized void entraPrioritarioS() throws InterruptedException {
        npS++;
        while (nNS > 0) {
            wait();
        }
        npS--;
        nSN++;
    }

}
