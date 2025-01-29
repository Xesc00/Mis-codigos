package basededades_practica;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
    public static Socket sc;
    public static void main(String[] args) throws IOException {
        
        final int PUERTO = 2000;
        final String host = "localhost";

        try {
            sc = new Socket(host, PUERTO);

            System.out.println(repMsg());
            String msg = enviaMsg();
            
            opcions(msg);
            
            sc.close();
        }catch (IOException e){
            System.out.println(e);

        }
    }
    
    //Metode per rebre les dades del servidor
    public static String repMsg() throws IOException{
        DataInputStream in = new DataInputStream(sc.getInputStream());
        String msg = in.readUTF();
        
        return msg;
    }

    //Envai missatge al servidor
    //Tambe fa un return per si es vol guardar el missatge que s'ha enviat
    public static String enviaMsg() throws IOException{
        DataOutputStream out = new DataOutputStream(sc.getOutputStream());
        
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);
            
        String msg = null;
        
        //Afegeix el que s'ha introduit dedins el String y comproba que no doni eror
        try {        
            msg = teclado.readLine();
        } catch (IOException e) {
            System.out.println("Error.");
        }   
        
        //Envia el missatge al servidor
        out.writeUTF(msg);
        
        return msg;
    }
    
    //Un metode avon tenir el switch i aixi organitzar millor el codi
    public static void opcions(String msg) throws IOException{
        switch(msg){
            case "insert":
                for(int i = 0; i < 3; i++){
                    System.out.println(repMsg());
                    enviaMsg();
                }
                System.out.println(repMsg());
                break;
            case "select":
                System.out.println(repMsg());
                enviaMsg();
                System.out.println(repMsg());
                break;
            case "delete":
                System.out.println(repMsg());
                enviaMsg();
                System.out.println(repMsg());
                break;
            case "sortir":
                break;
            default:
                System.out.println("El que has elegit no es una opcio valida");
                opcions(enviaMsg());
                break;
        }
    }
}