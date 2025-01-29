package practica2_contarvocal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Practica2_contarVocal {
    public static void main(String[] args) throws IOException {
        try{
            char vocal = coge().charAt(0);
            String html = coge();
            int count = 0;
            
            for(int i = 0; i < html.length(); i++){
                if(vocal == html.charAt(i)){
                    count++;
                }
            }
            System.out.println(count);
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
