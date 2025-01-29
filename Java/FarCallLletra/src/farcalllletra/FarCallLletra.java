package farcalllletra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FarCallLletra {

    public static void main(String[] args) throws IOException {
        File html = new File("C:/Users/xesc2/Documents/NetBeansProjects/Projecta1/encrypted.txt");
        
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader link = new BufferedReader(entrada);
        
        InputStreamReader ent = new InputStreamReader(System.in);
        BufferedReader entra = new BufferedReader(ent);
        
        InputStreamReader sur = new InputStreamReader(System.in);
        BufferedReader surt = new BufferedReader(sur);

        String texte = entra.toString();
        String texts = surt.toString();
        
        texte = texte.toUpperCase();
        texte = texte.toLowerCase();
        texts = texts.toUpperCase();
        texts = texts.toLowerCase();
                
        URL enllaç = new URL(link.readLine());
        URLConnection conexion = enllaç.openConnection();
        conexion.setDoOutput(true);

        String codi = "", linia;

        BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

        while ((linia = reader.readLine()) != null) {
            codi += linia + "\n";
        }
        
        String remplaz = codi.replace(texts, texte);//remplaça les lletres 
        
        FileWriter fw = new FileWriter(html.getAbsoluteFile());
        
        fw.write(remplaz);
        
        System.out.println("Arxiu creat amb èxit");
    }
    
}
