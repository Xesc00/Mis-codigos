/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porvajson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class PorvaJson {
    public static void main(String[] args) throws IOException {
           getUserById();
    }

    public static void getUserById() throws IOException {
        String apiket = "939eb80dfbdd3aec99c4daf98a2d44e1";
        URL urlForGetRequest = new URL("https://api.themoviedb.org/3/movie/popular?api_key=" + apiket + "&language=en-US&page=1");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");

        int responseCode = conection.getResponseCode();

        System.out.println("Funcionament : " + conection.getResponseMessage());

        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
//                System.out.println("JSON String Result " + p.toString());
            }
            in.close();
            String json = response.toString();
            JSONObject jsonObj = new JSONObject(json);

            
            //Print del resultado de la consulta
            System.out.println("JSON String Result " + jsonObj);
            try{
                System.out.println(jsonObj.getJSONArray("results"));
                System.out.println(jsonObj);
                JSONArray jrr = jsonObj.getJSONArray("results");
                System.out.println(jrr);
                
                for (int i = 0 ; i < jrr.length(); i++) {
                        JSONObject album = jrr.getJSONObject(i);
                        String titulo = album.getString("title");
                        String toriginal = album.getString("original_title");
                        String desc = album.getString("overview");
                        System.out.println(titulo+" | "+toriginal+" | "+desc);
                }
            } catch(Exception e){
                System.out.println(e);
            }

        } else {
            System.out.println("GET NOT WORKED");
        }
    }
}