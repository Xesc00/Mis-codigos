package datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 *
 * @author Xesc
 */
public class Datagram2 {
    public static void main(String[] args) throws Exception {
        //Sino agafa IPv6!
        System.setProperty("java.net.preferIPv4Stack", "true");
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramSocket socket = new DatagramSocket(1001);
        System.out.println("Client connectat esperant rebre del servidor ...");
        String mensaje = "";

        byte[] buf = new byte[1000];

        DatagramPacket paquet = new DatagramPacket(buf, 1000);
        socket.receive(paquet);
        mensaje = new String(paquet.getData(),0,paquet.getLength());
        System.out.println(mensaje);

        String aaa = mensaje + " dia";
        DatagramPacket send = new DatagramPacket(aaa.getBytes(),
        aaa.length(), ip, 1002);
        socket.send(send);

        socket.close();
        System.out.println("Socket tancat");
    }
}
