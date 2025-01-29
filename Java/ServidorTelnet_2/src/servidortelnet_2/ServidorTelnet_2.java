package servidortelnet_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTelnet_2 {
    public static Socket sSoceket;
    public static void main(String[] args) throws IOException {
        ServerSocket tSocket = new ServerSocket(117);
        sSoceket = tSocket.accept();

        Missatge();
    }
    
    public static void Missatge() throws IOException{
        String n = Menu();
        Send(n);
        Decisio();
    }
    
    public static String Menu(){
        String n = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \r\n? - Tornar a desplegar el menu\r\nls - Mostrar els documents del directoria actual\r\nrm - Borrar un directori\r\n"
                + "pwd - Mostrar el direcori en el que estas\r\nmkdir - Crear un directori amb el nom que aguis posat\r\nquit - Desconectar\r\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
        System.out.println(n);
        return n;
    }
    
    public static void Send(String cadena) throws IOException{
        PrintWriter pw = new PrintWriter(sSoceket.getOutputStream());
        pw.write(cadena + "\r\n");
        pw.flush();
    }
    
    public static void Decisio() throws IOException{
        String res = ClientSay();
        switch(res){
            case "?":
                Enigma();
                Missatge();
                break;
            case "ls":
                List();
                Missatge();
                break;
            case "rm":
                Delete();
                Missatge();
                break;
            case "pwd":
                Ubi();
                Missatge();
                break;
            case "mkdir":
                Create();
                Missatge();
                break;
            case "quit":
                break;
            default:
                Missatge();
                break;
        }
    }
    
    public static String ClientSay() throws IOException{
        InputStream is = sSoceket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bf = new BufferedReader(isr);
        
        String res = bf.readLine();
        
        return res;
    }
    
    //Ho faig amb un nou metode perque sigui més visaul
    public static void Enigma() throws IOException{
        Missatge();
    }
    
    public static void List() throws IOException{
        String startDir = System.getProperty("user.dir");
        File dir = new File(startDir);
        File[] files = dir.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println(file.getName());
                Send(file.getName());
            }
        }
    }
    
    public static void Delete() throws IOException{
        Send("Com es diu el directori que vols borra?");
        String nomD = ClientSay();
        
        String startDir = System.getProperty("user.dir");
        File deleteD = new File(startDir + "\\" + nomD);
        
        if (deleteD.delete()) Send("El direcori s'ha borrat");
        else Send("No s'ha pogut borrar el directori");
    }
    
    public static void Ubi() throws IOException{
        String startDir = System.getProperty("user.dir");
        System.out.println(startDir);
        
        Send(startDir);
    }
    
    public static void Create() throws IOException{
        Send("Com es diu el directori que vols crear?");
        String nomD = ClientSay();
        
        String startDir = System.getProperty("user.dir");
        String newD = startDir + "\\" + nomD;
        
        File directorio = new File(newD);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                Send("Directori creat");
            } else {
                Send("Error al crear directori");
            }
        }
    }
}
