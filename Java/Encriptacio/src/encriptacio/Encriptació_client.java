package encriptacio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encriptació_client {
    public static Socket socket;
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException {
        socket = new Socket();
        InetSocketAddress direccion = new InetSocketAddress("localhost", 4455);

        try{
            socket.connect(direccion);
        } catch (Exception e){
            System.out.println(e);
        }
        //Converteix a byts el pirmer missatge que reb       
        byte[] data = (byte[]) recibe(); 
        //Empla el primer missatge que reb que sira una public key per crearuna public key aqui
        PublicKey pkServer = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(data));
        //Crea una secret key 
        SecretKey sfdk = AES_Simetric.keygenKeyGeneration(256);
        //Genera una secret key que sira el hash que se emplerar per comparar el  issatge rebut
        SecretKey hush = Hash.passwordKeyGeneration(new String(sfdk.getEncoded()), 256);
        
        byte[] sk = sfdk.getEncoded();
        byte[] hus = hush.getEncoded();
        //Per mostrar si es vol veura la secretkey generada
        //System.out.println(new String(sk));
        
        //Encripta el que se enviara al servidor ambb la calu rebuda del servidor
        sk = RSA_Asimetric.encryptData(sk, pkServer);
        hus = RSA_Asimetric.encryptData(hus, pkServer);
        //System.out.println(new String(sk));
        
        //Crea una paceket amb les deudes dades que rebra el servidor que son la pulbickye que utilitzara per desencriptar
        //i el hash que empleara per sebra si les dades son correctes
        Packet pc = new Packet(sk,hus);
        
        //AMplei aquest metode per enciar el paquet al servidor
        send(pc);
        //Utilitz aquest metode per organitzar el codi i no tenir que repetir moltes vegades lo mateix
        desencriptFast(sfdk);
        
        while(true){
            String dicedice = read("Que vols encriptar?");
            encriptarPacket(dicedice, sfdk);
            desencriptFast(sfdk);
        }
    }
    
    public static void desencriptFast(SecretKey sfdk) throws IOException, ClassNotFoundException{
        //Reb el paquet directament
        Packet serverP = (Packet) recibe();
        
        //Extreu les dades que te dedins aquest paquet
        byte[] msgServer = serverP.getMessage();
        byte[] husServer = serverP.getHash();
        
        //Desencript les dades amb la secret key que sira la secret key que s'ha generat en el inici per encriptar o desencriptar en aquest cas
        msgServer = AES_Simetric.decryptData(sfdk, msgServer);
        husServer = AES_Simetric.decryptData(sfdk, husServer);
        //Pasa a astring el missatge rebut per poderlo mostrar
        String diceServer = new String(msgServer);
        
        //Tansform el hash per poder fer la comparacio
        SecretKey servereHash = new SecretKeySpec(husServer, 0, husServer.length, "AES");
        //En crei un per poderlo comparar amb el hash rebut i aixi sebre si el missatge es correcta
        SecretKey hushServer = Hash.passwordKeyGeneration(diceServer, 256);
        
        System.out.println(diceServer);
        
        //Compara els dos hash per si el missatge es correcta
        Hash.compareHash(hushServer, servereHash);
      
    }
    
    public static void encriptarPacket(String msg, SecretKey keyclient) throws IOException{
        //Pasa el missatge que es vol encriptar a byte's
        byte[] confi = msg.getBytes();
        //Crea un hash amb el misatge
        SecretKey hush = Hash.passwordKeyGeneration(msg, 256);

        byte[] hus = hush.getEncoded();
        //Encripta el missatge i el hash per enviarlo amb la calu que se li pasa 
        confi = AES_Simetric.encryptData(keyclient, confi);
        hus = AES_Simetric.encryptData(keyclient, hus);

        Packet pc = new Packet(confi,hus);

        send(pc);
    }
    
    public static Object recibe() throws IOException, ClassNotFoundException{
        ObjectInputStream llave = new ObjectInputStream(socket.getInputStream());
        Object obj = llave.readObject();
                
        return obj;
    }
    
    public static void send(Object llave) throws IOException{
        ObjectOutputStream obOut = new ObjectOutputStream(socket.getOutputStream());
        obOut.writeObject(llave);         
        obOut.flush();
    }
    
     public static String read(String say){
        System.out.println(say);
        
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);
            
        String cadena = null;
        try {        
            cadena = teclado.readLine();
        } catch (IOException e) {
            System.out.println("Error.");
        }   
        return cadena;
    }
}
