package chat_practica;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {
        int PortNumber = 5555;

        try {
            ServerSocket serverSocket = new ServerSocket(PortNumber);
            while (true) {
                ThreadClient w;
                System.out.println("Esperant conexio");
                
                w = new ThreadClient(serverSocket.accept());
                System.out.println("Client Concetat");
                
                Thread t = new Thread(w);
                t.start();
                System.out.println("Now fil cnectat");
            }
        } catch (IOException e) {
            System.err.println("Error " + e);
        }

    }
}