package treballtema3_chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Client {
    public static Socket s;
	
    public Client(String host, int port) {
            try {
                    s = new Socket(host, port);
                    String combo = comunicacio();

                    saveFile(s, combo);
                    
                    readFile(combo);
            } catch (Exception e) {
                    e.printStackTrace();
            }		
    }

    private void saveFile(Socket clientSock, String txt) throws IOException {
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());
        FileOutputStream fos = new FileOutputStream(txt);
        byte[] buffer = new byte[4096];

        int filesize = 15123; // Send file size in separate msg
        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
                totalRead += read;
                remaining -= read;
                fos.write(buffer, 0, read);
        }

        fos.close();
        dis.close();
        System.out.println("Arxiu copiat");
    }
    
    public static void send(JSONObject cadena) throws IOException{
        PrintWriter pw = new PrintWriter(s.getOutputStream());
        pw.print(cadena + "\n");
        pw.flush();
    }
    
    //Un metode per demanar per pantalla un parametre de tipus string al usuari i reotrnar aquest valor
    public static String read(String say){
        System.out.println(say);
        
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);
            
        String cadena = null;
        try {        
            cadena = teclado.readLine();
        } catch (IOException e) {
            System.out.println("Error.");
        }   
        return cadena;
    }
    
    public static String comunicacio() throws IOException, ParseException{
        String dni1 = read("Introdueix el teu DNI");
        String dni2 = read("\nIntrodueix el DNI desti");
        String combo = dni1 + dni2 + ".txt";
        
        String msg = read("\nQue li vols dir a " + dni2);

        JSONObject chat = new JSONObject();
        chat.put("dni1", dni1);
        chat.put("dni2", dni2);
        chat.put("missatge", msg);

        send(chat);

        return combo;
    }
    
    public static void readFile(String combo) throws IOException, ParseException{
        System.out.println("Llegint historial de la conversació");

        FileReader fr = new FileReader(combo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        String all = "";
        
        try{
            while((linea = br.readLine()) != null){
                all = linea;
                JSONParser parser = new JSONParser();  
                JSONObject json = (JSONObject) parser.parse(all);
                System.out.println(json.get("dni1") + " ha dit: " + json.get("missatge"));
            }
        }catch (IOException e){
            
        }
    }
    
    public static void main(String[] args) throws Exception {
        String local = "localhost";
        int port = 1988;

	try {
            Client fc = new Client(local, port);
        }catch (Exception e){
            
        }
    }
}

