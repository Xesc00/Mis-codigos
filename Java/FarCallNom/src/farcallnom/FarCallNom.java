package farcallnom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FarCallNom {

    public static void main(String[] args) throws IOException {
            File html = new File("C:/Users/xesc2/Documents/NetBeansProjects/Projecta1/index.html");
        
            InputStreamReader entrada = new InputStreamReader(System.in);
            BufferedReader link = new BufferedReader(entrada);
        
            InputStreamReader ent = new InputStreamReader(System.in);
            BufferedReader nom = new BufferedReader(ent);
            String alumne = nom.toString();
        
            URL enllaç = new URL(link.readLine());
            URLConnection conexion = enllaç.openConnection();
            conexion.setDoOutput(true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            
            String codi = "", linia;
            String bod = "<body ";
            alumne = alumne + "   </body>  </html>";
            
            boolean body = false;
            boolean gate = false;
        
            while (gate != true) {
                linia = reader.readLine();
                body = linia.contains(bod);
                codi += linia + "\n";
            
                if(body){
                    codi += alumne;
                    
                    gate = true;
                    }
                }
            
            FileWriter fw = new FileWriter(html.getAbsoluteFile());
            
            fw.write(codi);
        

    }
}
    

