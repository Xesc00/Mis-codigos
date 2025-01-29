/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.de.pkg0;

import controler.UserControler;
import entitiats.Aspirants;
import java.util.List;

/**
 *
 * @author Xesc
 */
public class JPADe0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserControler us = new UserControler();
        List<Aspirants> asp = us.llistaAspirants();
        
        for(Aspirants a : asp){
            System.out.println(a);
        }
    }
    
}
