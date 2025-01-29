
package enviarJsonServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws IOException {
            System.out.println("Run server");
            ServerSocket serverSocket = new ServerSocket(2000);
            Socket server = serverSocket.accept();
            
            //Espera conexio cleint
            
            System.out.println("- - - - - - ");
            System.out.println("conexio ok");
            System.out.println("- - - - - - ");
            
            PrintWriter pw = new PrintWriter(server.getOutputStream());
            
            InputStream is = server.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bf = new BufferedReader(isr);
            String linea = bf.readLine();

            System.out.println(linea);

            pw.flush();
    }
    
}