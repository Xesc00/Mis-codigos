package basurero.serverCopiarArxiu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {
	
	private Socket s;
	
	public FileClient(String host, int port, String txt) {
		try {
			s = new Socket(host, port);
			saveFile(s, txt);
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
                    System.out.println("read " + totalRead + " bytes.");
                    fos.write(buffer, 0, read);
            }

            fos.close();
            dis.close();
            System.out.println("Arxiu copiat");
    }
	
	public static void main(String[] args) {
		FileClient fc = new FileClient("localhost", 1988, "12.txt");
	}

}
