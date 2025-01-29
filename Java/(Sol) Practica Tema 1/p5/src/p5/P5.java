package p5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5 {

    public static void main(String[] args) {

        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);

        String cadena = null;
        try {
            cadena = teclado.readLine();
        } catch (IOException e) {
            System.out.println("Error on P5.");
        }

        int intIndex = cadena.indexOf(args[0]);

        if (intIndex == - 1) {
            System.out.println(args[0] + " NOT Found in get response from");
        } else {
            System.out.println("Found the word " + args[0] + " at index " + intIndex);
        }

    }

}
