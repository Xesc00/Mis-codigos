package farcallshow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FarCallShow {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        String cadena = "";
        try{
            FileReader fr = new FileReader("C:/Users/xesc2/Documents/NetBeansProjects/Projecta1/encrypted.txt");
            BufferedReader  br = new BufferedReader (fr);
            
            while((cadena = br.readLine()) != null){
                System.out.println(cadena);
            }
        
            br.close();
        }catch (Exception ex){
            System.out.println("Hi ha agut algun error amb la direcció");
        }
        
    }
    
}
