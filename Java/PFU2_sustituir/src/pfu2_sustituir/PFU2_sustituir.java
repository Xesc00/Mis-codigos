package pfu2_sustituir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class PFU2_sustituir {
    public static char entra = 'i';
    public static char surt;

    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\xesc2\\Documents\\NetBeansProjects\\PFU2_Francesc_Coll\\encrypted.txt";
        String html = coge();

        //Agafa el valor d eles lletras que he posat en el procces builder
        char entra = args[0].charAt(0);
        char surt = args[1].charAt(0);
        
        //Faig que es pugin cambiar las mayusucules tambe
        char upEntra = Character.toUpperCase(entra);
        char upSurt = Character.toUpperCase(surt);
        
        html = html.replace(entra, surt);
        html = html.replace(upEntra, upSurt);

        File crearFile = new File (ruta);
        if (crearFile.createNewFile()) {
            //System.out.println("Fitxer creat: " + crearFile.getName());
        } 
        try (FileWriter Writer = new FileWriter(ruta)) {
            Writer.write(html);

        } catch (Exception e) {

        }
        System.out.println("S'ha creat l'arxiu");
    }
    
    public static String coge() throws IOException{
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader one = new BufferedReader(entrada);
        String msg = one.readLine();
        
        return msg;
    }
    
}
