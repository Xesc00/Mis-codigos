/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptdatagram;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Base64;
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

            //Llegeix el fitcher i fica el seu resultat a dedins un string que pas a bytes
            //No entenc perque la clau no es la mateixa 
            mensaje = br.readLine();
            System.out.println(mensaje);
            byte[] sc  = Base64.getDecoder().decode(mensaje);
            System.out.println("Byte " + sc);
           
            
            
            SecretKey secterKey = new SecretKeySpec(sc, 0, sc.length, "AES");
            sc = secterKey.getEncoded();
            System.out.println(Base64.getEncoder().encodeToString(sc) + "\n");
            
            mensaje = "";

            while (!mensaje.trim().equals("*")) {
                // Rebre el paquet del servidor multicast
                byte[] buf = new byte[1000];
                DatagramPacket paquet = new DatagramPacket(buf, 1000);
                socket.receive(paquet);
                mensaje = new String(paquet.getData(),0,paquet.getLength());
                byte[] msg = mensaje.getBytes();
                
                try{
                    //Tendria que desencriptar pero no se avon esta l'error
                    System.out.println(new String(msg));
                    msg = AES_Simetric.decryptData(secterKey, msg);
                    System.out.println(new String(msg));
                }catch (Exception e){
                    System.out.println(e);
                }
            
            
        }
        socket.close();
        System.out.println("Socket tancat");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}