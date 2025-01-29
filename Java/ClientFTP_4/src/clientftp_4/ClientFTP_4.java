package clientftp_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientFTP_4 {
    public static Socket sgocketFT;
    public static void main(String[] args) throws IOException {
        sgocketFT = new Socket();
        InetSocketAddress direccio = new InetSocketAddress("test.rebex.net", 21);
        
        sgocketFT.connect(direccio);
        
        Connexio();
    }
    
    public static String getFlujo(InputStream is) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bfr = new BufferedReader(isr);
        String result = bfr.readLine();
        
        return result;
    }
    
    public static void Connexio() throws IOException{
        
        
        PrintWriter pw = new PrintWriter(sgocketFT.getOutputStream());
        InputStream is = sgocketFT.getInputStream();
        
        final String usu = "demo";
        final String pas = "password";

        String recived = getFlujo(is);
        System.out.println(recived);
        
        pw.println("USER " + usu);
        pw.flush();
        System.out.println("USER " + usu);
        recived = getFlujo(is);
        System.out.println(recived);
        
        pw.println("PASS " + pas);
        pw.flush();
        System.out.println("PASS " + pas);
        recived = getFlujo(is);
        System.out.println(recived);
        
        pw.println("pasv");
        pw.flush();
        System.out.println("pasv");
        recived = getFlujo(is);
        System.out.println(recived);
        
        String[] p = recived.split(",");
       
        String g = p[4];
        String s = p[5];
        s = s.replace(")" ,"");
        s = s.replace("." ,"");
        //System.t.println(s);ou
        
        int sum = Integer.parseInt(g);
        int sm = Integer.parseInt(s);
        sum = sum * 256 + sm;
        
        
        Escucha esc = new Escucha();
        esc.v_Port(sum);
        
        esc.start();
        pw.println("list");
        pw.flush();
        System.out.println("list");
        recived = getFlujo(is);
        System.out.println(recived);
    }
}
