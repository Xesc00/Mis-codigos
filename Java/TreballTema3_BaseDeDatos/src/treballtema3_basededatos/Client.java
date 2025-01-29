package treballtema3_basededatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static Socket socket;
    public static void main(String args[]) throws IOException {
        socket = new Socket();
        InetSocketAddress direccion = new InetSocketAddress("localhost", 4455);

        socket.connect(direccion);
        
        comunicacio();
    }
    
    public static void comunicacio () throws IOException{
        int i = 0;
        String cadena = null;
        while(i == 0){
            String primer = "Que vols fer:\n" + "- insert\n" + "- select\n" + "- delete\n" + "- sortir";
            
            cadena = read(primer);
            send(cadena);
        
            switch(cadena)
                {
                    case "insert":
                        System.out.println("Has elegit fer un: " + cadena);
                        insert();
                        break;
                    case "select":
                        System.out.println("Has elegit fer un: " + cadena);
                        select();
                        break;
                    case "delete":
                        System.out.println("Has elegit fer un: " + cadena);
                        delete();
                        break;
                    case "sortir":
                        i++;
                        break;
                    default:
                        System.out.println("El que has elegit no es una opcio valida");
                        break;
                }
        }
        String c = cadena;
            send(c);
    }
    
    //Un metode per demanar al usuari a més de ja poder fer un outprint del que es vol demanar 
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
    
    //Crei un metode per enciar dades al servidor fora tenir que repetir codi
    public static void send(String cadena) throws IOException{
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.print(cadena + "\n");
        pw.flush();
    }
    
    //Metode per fer l'insert
    public static void insert() throws IOException{
        String id = read("Introdueix l'Id");
        String nom = read("Ara el nom");
        String lli = read("I ara el llinatge");
        
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.print(id + "\n");
        pw.print(nom + "\n");
        pw.print(lli + "\n");
        pw.flush();
        
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bf = new BufferedReader(isr);
        System.out.println(bf.readLine());
        
        System.out.println("- - - - - - - - - - \n");
    }
    
    public static void select() throws IOException{
        String id = read("Introdueix l'Id que serques: ");
        send(id);
        
        System.out.println("Esperant resposta del servidor");
        
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bf = new BufferedReader(isr);
         
        
        String info = bf.readLine();
        
        info = info.replace("," , "\n");
        System.out.println(info);
        
        System.out.println("- - - - - - - - - - \n");
    }
    
    public static void delete() throws IOException{
        String id = read("Introdueix l'Id que serques: ");
        send(id);
        
        System.out.println("Esperant resposta del servidor");
        
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bf = new BufferedReader(isr);
        
        System.out.println(bf.readLine());
        System.out.println("- - - - - - - - - - \n");
    }
}


