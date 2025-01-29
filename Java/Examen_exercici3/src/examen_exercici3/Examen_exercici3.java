package examen_exercici3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author Xesc
 */
public class Examen_exercici3 {

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Introdueix la id de l'usuari que vols veure:");
            Scanner sc = new Scanner(System.in);
            getUserById(sc.nextLine());
        }
    }

    public static void getUserById(String id) throws IOException {
        URL connect = new URL("https://gorest.co.in/public/v2/users/" + id);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) connect.openConnection();
        conection.setRequestMethod("GET");
        
        int responseCode = conection.getResponseCode();
        
        System.out.println("Id que serques  " + responseCode);
        System.out.println("Funcionament : " + conection.getResponseMessage());

        if (responseCode == 200) {
            BufferedReader bf = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            
            while ((readLine = bf.readLine()) != null) {
                response.append(readLine);
            }
            
            bf.close();
            String json = response.toString();
            JSONObject jObject = new JSONObject(json);
            
            //Print del resultado de la consulta
            System.out.println("JSON String Result " + response.toString());
            System.out.println("JSON String Result " + jObject.toString());
            
        } else {
            System.out.println("GET NOT WORKED");
        }
    }
}
