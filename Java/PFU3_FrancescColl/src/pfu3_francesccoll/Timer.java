/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfu3_francesccoll;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Alumne
 */
public class Timer extends Thread {
     Semaphore s, e;
    
    public Timer(Semaphore s, Semaphore e){
        this.s = s;
        this.e = e;
    }
        
    @Override
    public void run() {
        boolean door = true;
        int h = 0, m = 59, i = 59;
        try{
            Crono.textField_Minuts.setText(Integer.toString(m));
            Crono.textField_Hores.setText(Integer.toString(h));
            while(door){
                s.acquire();
                Crono.textField_Segons.setText(Integer.toString(i));
                Crono.progersB_Minuts.setValue(1 + i);
                i++;
                try{
                    Timer.sleep(1000);
                } catch (InterruptedException e){
                    System.out.println(e);
                }
                    s.release(1);
                    if(i == 60){
                        ++m;
                        i = 0;
                        Crono.textField_Minuts.setText(Integer.toString(m));
                        Crono.progersB_Hores.setValue(1 + m);
                        s.release(1);
                        if(m == 60){
                            m = 0;
                            Crono.textField_Minuts.setText(Integer.toString(m));
                            ++h;
                            Crono.textField_Hores.setText(Integer.toString(h));
                            s.release(1);
                        } else {
                            s.release(1);
                        }
                    } else {
                        s.release(1);
                    }
                }   
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

