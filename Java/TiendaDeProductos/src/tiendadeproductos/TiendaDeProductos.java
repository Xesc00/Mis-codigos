package tiendadeproductos;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

public class TiendaDeProductos {
    private boolean estat = true;
    static int cajerosNum = 0;
    static int clientsNum = 10;

    static TiendaDeProductos caixa = new TiendaDeProductos();

    public void TiendaDeProductos(){
        estat = true;
    }

    public static void main(String[] args) {
        try{
            Semaphore s1 = new Semaphore(1);
            Semaphore s2 = new Semaphore(0);
            for (int i = 0; i < clientsNum; i++) {
                Client cli1 = new Client();
                cli1.Client(i, s1, s2);

                cli1.start();
                sleep(100);
            }
            s2.release();
            while(cajerosNum < 10){
                Cajero cajero = new Cajero();
                cajero.Cajero(cajerosNum, caixa, s2);

                cajero.start();
                cajerosNum++;
                sleep(100);
            }
        } catch (InterruptedException ex){
            System.out.println(ex);
        }

    }

    public boolean getEstat(){
        return estat;
    }

    public void serEstat(boolean estat){
        this.estat = estat;
    }

}