package clientftp_4;

import static clientftp_4.ClientFTP_4.sgocketFT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Escucha extends Thread{
    
    int port;
    
    @Override
    public void run(){
        sgocketFT = new Socket();
        InetSocketAddress direccio = new InetSocketAddress("test.rebex.net", port);
        
        try {
            sgocketFT.connect(direccio);
        
        
            InputStreamReader isr = new InputStreamReader(sgocketFT.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String msg = "";

            while((msg = br.readLine()) != null){
                System.out.println(msg);
            }      
        } catch (IOException ex) {
             
        }
    }
    
    public void v_Port(int port){
        this.port = port;
    }
}
