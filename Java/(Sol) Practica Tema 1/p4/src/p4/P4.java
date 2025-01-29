package p4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        StringBuilder inputLine = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("encrypted.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                inputLine.append(line);
            }
            br.close();
        }
        
        System.out.println(inputLine);
    }

}
