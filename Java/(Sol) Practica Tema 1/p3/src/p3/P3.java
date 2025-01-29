package p3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3 {

    public static void main(String[] args) throws IOException {
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);

        String cadena = null;
        try {
            cadena = teclado.readLine();
        } catch (IOException e) {
            System.out.println("Error on P3.");
        }

        char o = args[0].charAt(0);
        char d = args[1].charAt(0);

        String encrypted = cadena.replace(o, d);

        try (FileWriter Writer = new FileWriter("encrypted.txt")) {
            Writer.write(encrypted);
        }
        System.out.println("Arxiu creat amb èxit");

    }

}
