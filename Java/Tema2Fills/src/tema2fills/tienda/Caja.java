/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2fills.tienda;

/**
 *
 * @author joanbarcelo
 */
public class Caja {
    
    int caja;
    
    public Caja(){
        caja = 0;
    }
    
    public void CajaIncrement(){
        caja = caja + 1;
    }
    
    public int getCaja(){
        return caja;
    }
    
}
