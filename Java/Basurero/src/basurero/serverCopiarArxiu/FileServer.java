package basurero.serverCopiarArxiu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {
	
	private ServerSocket ss;
        public static String combo = "Server12.txt";
        public Socket clientSock;
	
	public FileServer(int port) {
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
                        sendFile(combo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
	}
        
        public void sendFile(String file) throws IOException {
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
		FileServer fs = new FileServer(1988);
		fs.start();
	}

}