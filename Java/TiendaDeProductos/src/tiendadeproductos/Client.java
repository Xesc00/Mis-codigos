package tiendadeproductos;

import java.util.concurrent.Semaphore;

public class Client extends Thread {

    int[] productsT;
    int id;
    Semaphore s1, s2;

    public void Client (int id, Semaphore s1, Semaphore s2){
         this.id = id;
         this.s1 = s1;
         this.s2 = s2;
    }

    public void comprar(){
        try{
            s1.acquire();
            int productesSelects = (int) (Math.random()*48 + 2);
            System.out.println("El cleint " + id + " ha agafat " + productesSelects + " productes.");
            
            
            int time;

            productsT = new int[productesSelects];

            for (int i = 0; i < productesSelects; i++) {
                time = (int) (Math.random()*4);
                productsT[i] = time;
            }

            s1.release();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void run(){
        comprar();
    }
}