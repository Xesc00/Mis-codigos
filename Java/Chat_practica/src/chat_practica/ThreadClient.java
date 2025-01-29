package chat_practica;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import org.json.*;

public class ThreadClient implements Runnable {
    private Socket client;
    
    public ThreadClient(Socket c) {
        client = c;
    }
    
    //Afegeix el cambis de la conversacio i crea una copia d'aquesta amb el prefixe de servidor
    private String writeOnFile(String nameFile1, String nameFile2, Missatge m) throws IOException {
        File chat = new File(nameFile1 + "_server");
        if (chat.exists()) {
            escriuChat(m.getText(), chat);
            return nameFile1 + "_server";
        } else {
            chat = new File(nameFile2 + "_server");
            if (chat.exists()) {
                escriuChat(m.getText(), chat);
            } else {
                escriuChat(m.getText(), chat);
            }
            return nameFile2 + "_server";
        }

    }
    
    //Metode per escriure al arxiu corresponent
    private void escriuChat(String m, File f) throws IOException {
        try (FileWriter fr = new FileWriter(f, true)) {
            fr.write(m + "\n");
        }
    }

    //Envai els cambus al arxiu al client
    public void sendFile(String file, Socket s) throws IOException {
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[4096];

        int read;
        while ((read = fis.read(buffer)) > 0) {
            dos.write(buffer, 0, read);
        }
        fis.close();
        dos.flush();
        dos.close();
    }

    @Override
    public void run() {
        
        String doc;
        
        try {
            while (true) {

                BufferedReader bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String JsonString = bf.readLine();

                //Llegeix el que diu el client ho pasa json i ho escriu
                JSONObject jObject = new JSONObject(JsonString);
                Missatge m = new Missatge((String) jObject.get("dniOrigen"), (String) jObject.get("dniDesti"), (String) jObject.get("text"));
    
                doc = writeOnFile(m.getDniOrigen() + m.getDniDesti(),m.getDniDesti() + m.getDniOrigen(), m);
                sendFile(doc, client);
                
                client.close();
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}