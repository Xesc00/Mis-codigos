/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Xesc
 */
public class Datagram {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramSocket socket = new DatagramSocket(1000);
        String cadena = "Bon";
        DatagramPacket paquet = new DatagramPacket(cadena.getBytes(),
        cadena.length(), ip, 1001);
        socket.send(paquet);

        byte[] buf = new byte[1000];
        DatagramPacket recibe = new DatagramPacket(buf, 1000);
        socket.receive(recibe);
        cadena = new String(recibe.getData(),0,recibe.getLength());
        System.out.println(cadena);
            
        socket.close();
        System.out.println("Socket tancat ...");
    }
}
