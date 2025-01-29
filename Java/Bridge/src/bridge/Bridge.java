package bridge;

import java.util.concurrent.Semaphore;


 
public class Bridge { 
    
    
    public static void main(String[] args) throws InterruptedException{
        Semaphore s1 = new Semaphore(1);
        //Semaphore s2 = new Semaphore(0);
        
        Puente pont = new Puente();

        for (int i = 0; i < 10; i++) {
            Coche car1 = new Coche();
        
            car1.Coche(i, s1, pont);
        
            car1.start();
        }
        //s2.release();
        
        Puente p = new Puente();
        p.curzar();
    }
} 