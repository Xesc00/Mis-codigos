package p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2 {

    public static void main(String[] args) {
        
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);
        
        String cadena = null;
        try {
            cadena = teclado.readLine();
        } catch (IOException e) {
            System.out.println("Error on P2.");
        }
        
        char c = args[0].charAt(0);
        long count = cadena.chars().filter(ch -> ch == c).count();
        System.out.println("The numbre of " + c + " on the content is" + count);

    }

}
