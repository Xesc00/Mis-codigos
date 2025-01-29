

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class FarCallVocal {
    public static void main(String[] args) throws IOException {
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader link = new BufferedReader(entrada);
        
        InputStreamReader lletra = new InputStreamReader(System.in);
        BufferedReader vocal = new BufferedReader(lletra);

        URL enllaç = new URL(link.readLine());
        URLConnection conexion = enllaç.openConnection();
        conexion.setDoOutput(true);

        String vc = vocal.toString();
        String MI = vocal.toString();

        String VC = MI.toLowerCase();

        char voc = vc.charAt(0);
        char VOC = VC.charAt(1);

        int contador = 0;

        String codi = "",linia;

        BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

        while ((linia = reader.readLine()) != null) {
            codi += linia;
        }

        for (int i = 0; i < codi.length(); i++) {
                if (codi.charAt(i) == voc || codi.charAt(i) == VOC) {
                    contador++;
                }
            }
        System.out.println("La vocal apareix " + contador);
    }
}
