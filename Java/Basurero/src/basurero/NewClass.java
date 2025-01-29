/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basurero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Xesc
 */
public class NewClass {
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {
        JSONObject array = new JSONObject();
        
        array.put("DNI1", "1");
        array.put("DNI2", "2");
        array.put("Missatge", "SIIIII JODER");
        
        
        
        String txt = array.toString();
        addText(array);
        
        //read();
    }
    
    public static void addText(JSONObject obj) throws IOException{
        File file = new File("TextJSON_prova.txt");
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        fw.write(obj + "\n");
        fw.close();
    }
    
    public static void read() throws FileNotFoundException, IOException{
        File archivo = new File ("TextJSON_prova.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        String all = "";
        while((linea = br.readLine()) != null){
            all += linea + "\n";
        }
        //all = all.replaceFirst("Missatge" , "");
        System.out.println(all);
    }
}
