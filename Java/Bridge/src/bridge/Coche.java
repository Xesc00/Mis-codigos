package bridge;

import java.util.concurrent.Semaphore;

public class Coche extends Thread{
    Puente pont;
    int id, dir, pri;
    boolean nort;
    boolean prioriti;
    Semaphore s1;
    String dirVal, priVal;
    
    public void Coche(int id, Semaphore s1, Puente pont) throws InterruptedException{
        this.id = id;
        this.s1 = s1;
        this.pont = pont;
        
        int direccio = (int) (Math.random()*2);
        
        if (direccio == 0){
            nort = true;
            dirVal = "Nort";
        } else {
            nort = false;
            dirVal = "Sud";
        }
        
        int prioritat =(int) (Math.random()*5);
        if (prioritat == 0){
            this.prioriti = true;
            priVal = "si";
        } else {
            this.prioriti = false;
            priVal = "no";
        }
        
        dir = direccio;
        pri = prioritat;
       
        
    }
    
    @Override
    public void run(){
        Integer data;
        
        try{
            s1.acquire();
            pont.append(id, dir, pri);
            System.out.println("id: " + id + " direccio: " + dirVal + ", policia: " + priVal);
            sleep(100);
            
            s1.release();
        } catch (InterruptedException ex){
            System.out.println(ex);
        }
        
    }
}
