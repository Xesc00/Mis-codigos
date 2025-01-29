package shop.semaphore;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShopSemaphore {

    final static int NUM_CLIENTES = 6;
    final static int NUM_CAJEROS = 5;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[NUM_CAJEROS];
        Semaphore s = new Semaphore(1);
        Caja caja = new Caja();
        Lock sc = new ReentrantLock();
        ArrayList<Cliente> clientes = new ArrayList<>();

        for (int i = 0; i < NUM_CLIENTES; i++) {
            Cliente c = new Cliente(i);
            clientes.add(c);
        }

        for (int i = 0; i < NUM_CAJEROS; i++) {
            threads[i] = new Thread(new Cajero(i, clientes, s, caja, sc));
            threads[i].start();
        }

        for (int i = 0; i < NUM_CAJEROS; i++) {
            threads[i].join();
        }

        System.out.println("Total items passats per caixa: " + caja.getCaja());
    }

}
