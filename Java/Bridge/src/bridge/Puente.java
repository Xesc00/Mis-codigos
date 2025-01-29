package bridge;

import static java.lang.Thread.sleep;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Puente{
    int waitN, waitS, waitPN, waitPS;
    Deque<Integer> buffer = new LinkedList<Integer>();
    Deque<Integer> rm = new LinkedList<Integer>();
    int total;
    
    
    
    synchronized public void append(Integer data, Integer nort, Integer prioritat) throws InterruptedException {
        while (buffer.size() == 10) {
            try {
                wait();
                
            } catch (InterruptedException e) {}
        }
        buffer.add(data);
        buffer.add(nort);
        buffer.add(prioritat);
        
        rm = buffer;
        
        positions();
        notifyAll();
    }
    
    public void positions() throws InterruptedException{
        rm.pollFirst();
        
        int nort = rm.getFirst();
        rm.pollFirst();
        
        int prioritat = rm.getFirst();
        rm.pollFirst();
        
        if (nort == 0){
            if (prioritat == 0) waitPN++;
            else waitN++;
        } else {
            if (prioritat == 0) waitPS++;
            else waitS++;
        }
        total = waitN + waitS + waitPN + waitPS;
    }
    
    public void curzar() throws InterruptedException{
        //s2.acquire();
        while(buffer.isEmpty()){
            for (; total > 0; total--) {
                if(waitPN > 0){
                    buffer.add(waitPN);
                    System.out.println("Pasa un cotxo de policia de N a S ");
                    waitPN--;
                    sleep(100);
                    
                    while ( waitN > 0 && waitPN == 0 && waitPS == 0) {
                    
                        buffer.add(waitN);
                        System.out.println("Pasa un cotxo de N a S ");
                        waitN--;
                        sleep(100);
                
                    }
                } else if (waitPS > 0){
                    buffer.add(waitPS);
                    System.out.println("Pasa un cotxo de policia de S a N ");
                    waitPS--;
                    sleep(100);
                    
                    while (waitS > 0 && waitPS == 0 && waitPN == 0){
                
                        buffer.add(waitS);
                        System.out.println("Pasa un cotxo de S a N");
                        waitS--;
                        sleep(100);
                        waitPN++;
                    }
                } else if ( waitN > 0) {
                    
                    buffer.add(waitN);
                    System.out.println("Pasa un cotxo de N a S ");
                    waitN--;
                    sleep(100);
                    
                
                } else if(waitS > 0){
                
                        buffer.add(waitS);
                        System.out.println("Pasa un cotxo de S a N");
                        waitS--;
                        sleep(100);
                }
            }
            
        }  
        buffer.clear(); 
        //s1.release();
    }
}

