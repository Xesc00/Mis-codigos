
package encriptacio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encriptacio_server {
    public static Socket server;
    public static void main(String[] args) {
        try{
            //Genera una clau asimetrica que només tendra el servidor i faig la calu publica i la privada amb aquesta keypair
            KeyPair kay = RSA_Asimetric.randomGenerate(2048);
            PublicKey pk = kay.getPublic();
            PrivateKey sk = kay.getPrivate();
            
            System.out.println("Run server");
            ServerSocket serverSocket = new ServerSocket(4455);
            server = serverSocket.accept();
            
            byte[] bpk = pk.getEncoded();
            //envia al client la public key que s'ha creat
            send(bpk);
            
            byte[] clientKey = desencriptKey(sk);
                        
            //Utilitzam aquesta secret Key per encriptar que es tambe la clau publica del cleint
            SecretKey secretClient = new SecretKeySpec(clientKey, 0, clientKey.length, "AES");
            
            //Potser qualsevol cosa ja que sira el missatge que se enviara al client
            String msg = "DataRecived";
            encriptarPacket(msg, secretClient);
            
            while(true){
                desencriptClient(secretClient);
                encriptarPacket(msg, secretClient);
            }
           
        } catch (Exception e){
            System.out.println("Fallo en el servidor" + e);
        }
    }
    
    public static void send(Object llave) throws IOException{
        ObjectOutputStream obOut = new ObjectOutputStream(server.getOutputStream());
        obOut.writeObject(llave);         
        obOut.flush();
    }
    
    public static Object recibe() throws IOException, ClassNotFoundException{
        ObjectInputStream llave = new ObjectInputStream(server.getInputStream());
        Object obj =llave.readObject();
        
        return obj;
    }
    
    //Aquest metode es per rebra la clau que es generea en el client
    public static byte[] desencriptKey(PrivateKey sk) throws IOException, ClassNotFoundException{
        //Reb el packet ecnriptat per el client amb una clau asimetrica
        Packet a = (Packet) recibe();
            
        byte[] clientMsg = a.getMessage();
        byte[] husClient = a.getHash();

        //Clau que rep del cleint
        clientMsg = RSA_Asimetric.decryptData(clientMsg, sk);
        //El hash per comparar que el missatge estigui be
        husClient = RSA_Asimetric.decryptData(husClient, sk);

        //Desencriptam el hash que envia el client
        SecretKey clienteHash = new SecretKeySpec(husClient, 0, husClient.length, "AES");
        //Cream un hash amb la clau que rebem del client
        SecretKey hushServer = Hash.passwordKeyGeneration(new String(clientMsg), 256);

        //Comparam que el hash es correcte
        Hash.compareHash(hushServer, clienteHash);
        
        return clientMsg;
    }
    
    //amb aquest metode reb el missatge que ve del client
    public static void desencriptClient(SecretKey sk) throws IOException, ClassNotFoundException{
        //Reb el packet ecnriptat per el client amb una clau simetrica
        Packet serverP = (Packet) recibe();
        
        byte[] msgClient = serverP.getMessage();
        byte[] husClient = serverP.getHash();
        
        msgClient = AES_Simetric.decryptData(sk, msgClient);
        husClient = AES_Simetric.decryptData(sk, husClient);
        String diceServer = new String(msgClient);
        
        SecretKey clienteHash = new SecretKeySpec(husClient, 0, husClient.length, "AES");
        SecretKey hushServer = Hash.passwordKeyGeneration(diceServer, 256);
        
        System.out.println(diceServer);
        
        Hash.compareHash(hushServer, clienteHash);
    }
    
    public static void encriptarPacket(String msg, SecretKey keyclient) throws IOException{
        byte[] confi = msg.getBytes();
            
        SecretKey hush = Hash.passwordKeyGeneration(new String(confi), 256);

        byte[] hus = hush.getEncoded();

        confi = AES_Simetric.encryptData(keyclient, confi);
        hus = AES_Simetric.encryptData(keyclient, hus);

        //Fer packet
        Packet pc = new Packet(confi,hus);

        send(pc);
    }
    
}