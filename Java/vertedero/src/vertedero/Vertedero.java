package vertedero;

import static java.lang.Thread.sleep;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Vertedero {

    public static void main(String[] args) throws InterruptedException{
        
        int[][] prod = new int[10][10];
        

        int time;
        for (int i = 0; i < 10; i++) {
            time = (int) (Math.random()*4);
            prod[i][i] = time + i;
           
             System.out.println();
            System.out.println(prod[i][i]);
        }
           
        }
    
    
    public static void hola(){
        System.out.println("hola");
    }
}
 /*Deque<Integer> buffer = new LinkedList<Integer>();
        int waitN = 5, waitS = 9, waitPN = 3, waitPS = 1;
        int total = waitN + waitS + waitPN + waitPS;
        
        Integer data;
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
    
             
            System.out.println(buffer);
             
            data = buffer.remove();
             buffer.add(data);
              
             System.out.println(buffer);
             
         
             System.out.println(buffer);
             
            int nort = buffer.getFirst();
              System.out.println(nort);
            buffer.remove();
            nort = buffer.getFirst();
            
             System.out.println(nort);
             buffer.clear();
             
             
             System.out.println(buffer); 
           
            */