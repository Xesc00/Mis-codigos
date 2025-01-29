package enviarJsonServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.json.simple.JSONObject;

public class client {
    public static void main(String args[]) throws IOException {
        Socket socket = new Socket();
        InetSocketAddress direccio = new InetSocketAddress("localhost",  2000);

        socket.connect(direccio);

        JSONObject json = new JSONObject();
        json.put("DNI1", "1");
        json.put("DNI2", "2");
        
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.print(json + "\n");
        pw.flush();
    }
}