/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2fills.tienda;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joanbarcelo
 */
public class Cajero implements Runnable {

    int id;
    ArrayList<Cliente> clientes = new ArrayList<>();
    Semaphore sem;
    Lock sc;
    Caja caja;

    public Cajero(int i, ArrayList<Cliente> c, Semaphore s, Caja ca, Lock sca) {
        id = i;
        clientes = c;
        sem = s;
        sc = sca;
        caja = ca;
    }

    @Override
    public void run() {
        try {
            while (!clientes.isEmpty()) {

                Cliente c;

                System.out.println("Cajero " + id + " disponible.");
                sem.acquire();
                c = clientes.get(clientes.size() - 1);
                clientes.remove(c);

                sem.release();
                for (int i = 0; i < c.getProductos().length; i++) {
                    System.out.println("Cajero " + id + " procesa productos de cliente numero " + c.id);
                    sleep(c.getProductos()[i] * 1000);
                    sc.lock();
                    try {
                        caja.CajaIncrement();
                    } finally {
                        sc.unlock();
                    }
                }
                System.out.println("Cajero " + id + " a procesado un cliente.");

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
