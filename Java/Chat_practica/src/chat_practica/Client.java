package chat_practica;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.json.simple.JSONObject;

public class Client {

    //Metode per enviar dades en aquest o vaig amb bufferedReader ja que amb UTF només es poeden enviar Strings
    public static String enviaMsg(String in) throws IOException {
        System.out.println(in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        return reader.readLine();
    }
    
    //Metode per crear l'estrucutura del json
    private static JSONObject jsonConstruct(String dniEmisor, String dniReceptor, String txt) {
        JSONObject json = new JSONObject();
        json.put("dniOrigen", dniEmisor);
        json.put("dniDesti", dniReceptor);
        json.put("text", txt);
        
        return json;
    }

    //Metode per enviar de forma directa el json i "orgenitzar" el codi
    private static void enviaJson(Socket socket, JSONObject json) throws IOException {
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.print(json + "\n");
        pw.flush();
    }

    //Metode per llegir un arxiu amb les credencials corresponents
    private static void readFile(String dniOrigin, String dniDestiny) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(dniOrigin + dniDestiny + "_client"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
    
    //Metode per guardar les dades del json a un arxiu amb el prefixe de cleient
    private static void saveFile(Socket clientSock, String f) throws IOException {
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());
        FileOutputStream fos = new FileOutputStream(f + "_client");
        
        byte[] buffer = new byte[4096];
        int filesize = 15123;
        int read = 0;
        int remaining = filesize;
        
        read = dis.read(buffer, 0, Math.min(buffer.length, remaining));
        
        while (read > 0) {
            System.out.println("read " + read + " bytes.");
            fos.write(buffer, 0, read);
            read = dis.read(buffer, 0, Math.min(buffer.length, remaining));
        }

        fos.flush();
    }

    public static void main(String[] args) throws IOException {

        InetSocketAddress direccion = new InetSocketAddress("localhost", 5555);
        JSONObject json;

        String dniOrigin = enviaMsg("Indica el DNI:");
        String dniDestiny = enviaMsg("\nIndica el DNI del receptor:");

        while (true) {
            Socket socket = new Socket();
            socket.connect(direccion);

            String txt = enviaMsg("\nEscribu el missatge que vols: \n");

            Missatge m = new Missatge(dniOrigin, dniDestiny, txt);
            json = jsonConstruct(m.getDniOrigen(), m.getDniDesti(), m.getText());

            enviaJson(socket, json);

            saveFile(socket, dniOrigin + dniDestiny);
            socket.close();

            System.out.println("\nContenido actual de la conversación: \n");
            System.out.println("----------------CHAT----------------");
            readFile(dniOrigin, dniDestiny);
            System.out.println("-----------------FI----------------- \n");
        }

    }

}