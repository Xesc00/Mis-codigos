/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escriure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Xesc
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try
        {
            fichero = new FileWriter("prueba.txt");
            pw = new PrintWriter(fichero);
            BufferedWriter bw = new BufferedWriter(new FileWriter("prueba.txt",true));

            for (int i = 0; i < 10; i++)
                bw.write("Linea " + i);
                bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
