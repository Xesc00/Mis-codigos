package pfu2_paraula;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PFU2_paraula {

    public static void main(String[] args) throws IOException {
        try{
            String html = coge();
            String paraula = args[0];
            //System.out.println(paraula);

            if(html.contains(paraula)) System.out.println("Conte la paraula");
            else System.out.println("No conte la paraula");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static String coge() throws IOException{
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader one = new BufferedReader(entrada);
        String msg = one.readLine();
        
        return msg;
    }
}

