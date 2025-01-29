package p6;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class P6 {

    public static void main(String[] args) throws IOException {

        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);

        String cadena;
        try {
            cadena = teclado.readLine();
            
            try {
                String[] p1 = cadena.split("<body");
                String part1 = p1[0];
                String[] p2 = p1[1].split("</body>");
                String part2 = p2[1];
                String resume = part1 + "<body>" + args[0] + "</body>" + part2;
                
                try (FileWriter Writer = new FileWriter("index.html")) {
                    Writer.write(resume);
                }
            } catch (Exception e) {
                System.out.println("Error splitting, the web page has not body.");
            }

        } catch (IOException e) {
            System.out.println("Error on P6.");
        }
        System.out.println("Arxiu creat amb èxit");
    }

}
