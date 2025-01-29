package treballtema3_chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Server extends Thread{
    private ServerSocket ss;
    public static String combo;
    public Socket clientSock;

    public Server(int port) {
            try {
                    ss = new ServerSocket(port);
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }

    public void run() {
            while (true) {
                    try {
                            clientSock = ss.accept();
                            
                            // CONSEXIO CLIENT //
                            
                            System.out.println("Esperant informacio del Client");
                            
                            InputStream is = clientSock.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is);
                            BufferedReader bf = new BufferedReader(isr);

                            String jsonCl = bf.readLine();

                            System.out.println(jsonCl);

                            JSONParser parser = new JSONParser();
                            JSONObject json = (JSONObject) parser.parse(jsonCl);

                            String dni1 = (String) json.get("dni1");
                            String dni2 = (String) json.get("dni2");

                            String combo = "Server" + dni1 + dni2 + ".txt";
                            String inverso = "Server" +dni2 + dni1 + ".txt";
                            
                            combo = addText(combo, inverso, json);
                            sendFile(combo, inverso);
                            
                            
                    } catch (IOException e) {
                            e.printStackTrace();
                    } catch (ParseException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public void sendFile(String file, String inverso) throws IOException {
        
            DataOutputStream dos = new DataOutputStream(clientSock.getOutputStream());
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[4096];

            while (fis.read(buffer) > 0) {
                    dos.write(buffer);
            }

            fis.close();
            dos.close();	
    }

    public static void main(String[] args) {
            Server fs = new Server(1988);
            fs.start();
    }
    
    public static String addText(String combo, String inverso, JSONObject json) throws IOException{
        File inv = new File(inverso);
        if(inv.exists()){
            combo = inverso;
        }
        File file = new File(combo);
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        fw.append(json + "\n");
        fw.close();
        
        System.out.println("S'ha afagit nou text a la convesació");
        return combo;
    }
}