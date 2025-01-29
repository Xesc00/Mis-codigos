/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basurero;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MASPUREBAS {
     public static void main(String args[]) throws ParseException, IOException {
       String frase = read();
       
        File archivo = new File ("TextJSON_prova.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        String all = "";
        while((linea = br.readLine()) != null){
            all = linea;
            JSONParser parser = new JSONParser();  
            JSONObject json = (JSONObject) parser.parse(all);  
            System.out.println("Missatge: " + json.get("Missatge"));
        }
       
       System.out.println(frase);
       
       JSONParser parser = new JSONParser();
       JSONObject json = (JSONObject) parser.parse(all);
       
        System.out.println("");

//        for (int i = 0; i < json.size(); i++) {
//            JSONObject jsonobject1 = (JSONObject) json.get(i);
//
//            System.out.println("Missatge: " + jsonobject1.get("Missatge"));
//
//            System.out.println("");
//        }
//       
    }
     
     public static String read() throws FileNotFoundException, IOException{
        File archivo = new File ("TextJSON_prova.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        String all = "";
        while((linea = br.readLine()) != null){
            all += linea + "\n";
        }
        return all;
    }
     
     public static void addText(String obj) throws IOException{
        File file = new File("TextJSON_prova.txt");
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        fw.write(obj + "\n");
        fw.close();
    }
}
