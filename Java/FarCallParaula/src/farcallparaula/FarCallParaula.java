package farcallparaula;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class FarCallParaula {

    public static void main(String[] args) throws IOException {
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader link = new BufferedReader(entrada);
        
        InputStreamReader pa = new InputStreamReader(System.in);
        BufferedReader ra = new BufferedReader(pa);
        
        String paraula = ra.toString();
        
        URL enllaç = new URL(link.readLine());
        URLConnection conexion = enllaç.openConnection();
        conexion.setDoOutput(true);

        
        
        String codi = "",linia;
        int contador = 0;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        
        boolean res;
        
        while ((linia = reader.readLine()) != null) {
            codi += linia;
            res = linia.contains(paraula);
            if(res){
                contador++;
            }
        }
        
        //Crei una variable que si el text conte la paraula aquesta es torna true
        boolean resultat = codi.contains(paraula);

        if(resultat){
            if (contador > 1){
                System.out.println("La paraula surt més de una vegada");
            } else {
                System.out.println("Paraula trobada");
            }
        }
            System.out.println("palabra no encontrada");
    }
    
}
