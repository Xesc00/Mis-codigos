package client_restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client_RestApi {
    public static void main(String[] args) throws IOException {
//        showAll();
//        justShowID();
//        justShowAutor();
//        deleteObra("5");
        createObra();
    }
    
    //Mostra tots les obres
    public static void showAll() throws IOException {
        URL urlForGetRequest = new URL("http://localhost:8080/RestApi_1/api/obra");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");

        int responseCode = conection.getResponseCode();


        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            
            String n =  remplaç(response.toString());
            System.out.println(n);
            
        } else {
            System.out.println("GET NOT WORKED");
        }

    }
    
    //Mostra les obres per ID
    public static void justShowID() throws IOException {
        String id_obra = "/1";
        String uri = "http://localhost:8080/RestApi_1/api/obra" + id_obra;
        URL obj = new URL(uri);
        String readLine = null;
        
        HttpURLConnection conection = (HttpURLConnection) obj.openConnection();
        conection.setRequestMethod("GET");
        //conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();


        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            
            String n  =  remplaç(response.toString());
     
            System.out.println(n);
            
        } else {
            System.out.println("GET NOT WORKED");
        }

    }
    
    //No vol funcionar
    public static void justShowAutor() throws IOException {
        String autor = "/Van Gogh";
        String uri = "http://localhost:8080/RestApi_1/api/obra/autor" + autor;
        URL obj = new URL(uri);
        String readLine = null;
        
        HttpURLConnection conection = (HttpURLConnection) obj.openConnection();
        conection.setRequestMethod("GET");
        //conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();


        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            
            String n  =  remplaç(response.toString());
     
            System.out.println(n);
            
        } else {
            System.out.println("GET NOT WORKED");
        }

    }
 
    //Borra l'obra per ID
    public static void deleteObra(String id_obra)  throws IOException{
        String uri = "http://localhost:8080/RestApi_1/api/obra/deleteObra/" + id_obra;
        //System.out.println(uri);
        URL urlForGetRequest = new URL(uri);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("DELETE");
        
        int responseCode = conection.getResponseCode();


        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // Mostra una altre vegade tots els elements de la llista per comprobar ques 'ha borrat
            System.out.println("\n JSON String Result " + remplaç(response.toString()));
        } else {
            System.out.println("GET NOT WORKED");
        }
    }
    
    //No se com fer que funcioni 
    public static void createObra() throws IOException {
        Obra newO = new Obra(6,"a","123","aaa", "eeee");
 
        
        final String POST_PARAMS = "{\n" + "\"ID_OBRA\": \"" + newO.getID_OBRA() + "\",\r\n" +
            "    \"TITOL\": \"" + newO.getTITOL() + "\",\r\n" +
            "    \"ANY\": \"" + newO.getANY() + "\",\r\n" +
            "    \"MODALITAT\": \"" + newO.getMODALITAT() + "\",\r\n" +
            "    \"AUTOR\": \"" + newO.getAUTOR() + "\",\r\n}";
        
        System.out.println(newO);
        URL obj = new URL("http://localhost:8080/RestApi_1/api/obra/createObra");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");

        postConnection.setDoOutput(true);
        OutputStreamWriter os = new OutputStreamWriter(postConnection.getOutputStream());
        os.write(POST_PARAMS);
        os.flush();
        os.close();


        int responseCode = postConnection.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + postConnection.getResponseMessage());

        if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            System.out.println(remplaç(response.toString()));
        } else {
            System.out.println("POST NOT WORKED");
        }
    }
    
    //Metode per printear de forma més clara les obres
    public static String remplaç(String n){
        n = n.replace(",", "\n");
        n = n.replace("\""," ");
        n = n.replace("}","");
        n = n.replace("[","");
        n = n.replace("]","");
        n = n.replace("{", "- - - - - - - - - - - - - - \n");
        
        return n;        
    }
}
