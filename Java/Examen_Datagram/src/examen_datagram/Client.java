package examen_datagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.Charset;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Client {
    public static void main(String[] args) throws Exception {
        //Sino agafa IPv6!
        System.setProperty("java.net.preferIPv4Stack", "true");
        DatagramSocket socket = new DatagramSocket(5555);
        System.out.println("Client connectat esperant rebre del servidor ...");
        String mensaje = "";
        
        try{
            BufferedReader br = new BufferedReader(new FileReader (new File ("key.txt")));

            //Lectura del fichero
            mensaje = br.readLine();
        
            byte[] sc  = mensaje.getBytes();

            SecretKey secterKey = new SecretKeySpec(sc, 0, sc.length, "AES");

            mensaje = "";
        
        while (!mensaje.trim().equals("*")) {
            // Rebre el paquet del servidor multicast
            byte[] buf = new byte[1000];
            DatagramPacket paquet = new DatagramPacket(buf, 1000);
            socket.receive(paquet);
            
            mensaje = new String(paquet.getData(),0,paquet.getLength());
            byte[] msg = mensaje.getBytes();
            //Tendria que desencriptar pero no se avon esta l'error
            System.out.println(new String(msg));
            msg = AES_Simetric.decryptData(secterKey, msg);
            
            
        }
        socket.close();
        System.out.println("Socket tancat");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
