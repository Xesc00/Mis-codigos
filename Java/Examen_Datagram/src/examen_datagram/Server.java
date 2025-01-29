package examen_datagram;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import javax.crypto.SecretKey;

public class Server {

    public static void main(String[] args) throws Exception {
        //Sino agafa IPv6!
        System.setProperty("java.net.preferIPv4Stack", "true");
        Scanner teclat = new Scanner(System.in);
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramSocket socket = new DatagramSocket();
        String cadena = "a";
        
        SecretKey sfdk = AES_Simetric.keygenKeyGeneration(192);
        
        byte[] sf = sfdk.getEncoded();
        System.out.println(sf);
        try
        {
            FileWriter fichero = new FileWriter("key.txt");
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(sf);
            pw.flush();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        while (!cadena.trim().equals("*")) {
            System.out.print("Dades per enviar al grup: ");
            cadena = teclat.nextLine();
            
            byte[] msg = AES_Simetric.encryptData(sfdk, cadena.getBytes());
            
            DatagramPacket paquet = new DatagramPacket(msg, msg.length, ip, 5555);
            socket.send(paquet);
            
            msg = AES_Simetric.decryptData(sfdk, msg);
            
            System.out.println(new String (msg));
        }
        socket.close();
        System.out.println("Socket tancat ...");
        teclat.close();
    }
}
