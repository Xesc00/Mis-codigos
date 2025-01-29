package tiendadeproductos;

import java.util.concurrent.Semaphore;

public class Cajero extends Thread{
    int id;
    TiendaDeProductos disponible;
    TiendaDeProductos client;
    Semaphore s2;
    public void Cajero (int id, TiendaDeProductos a, Semaphore s2){
         this.id = id;
         disponible = a;
         this.s2 = s2;
    }
    private void cogerCliente(){
        try{
            s2.acquire();
            if (disponible.getEstat() == true){
                System.out.println("Cajero " + id + " disponible");
            }
            s2.release();
        }catch (InterruptedException ex){
            System.out.println(ex);
        }
    }
    @Override
    public void run(){
        cogerCliente();
    }
}