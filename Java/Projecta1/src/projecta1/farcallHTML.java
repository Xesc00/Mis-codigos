package projecta1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class farcallHTML {

    public static void main(String[] args)throws IOException {
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader link = new BufferedReader(entrada);

        //Posam el link dedins una "etiqueta URL" per poder descargar l'arxiu HTML
        URL enllaç = new URL(link.readLine());
        URLConnection conexion = enllaç.openConnection();
        conexion.setDoOutput(true);

        String codi = "", linia;

        BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

        while ((linia = reader.readLine()) != null) {
            codi += linia + "\n";
        }

        System.out.println(codi);

    } 
}