package clientsmtp_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ClientSMTP_3 {
    public static Socket sgocketG;
    public static void main(String[] args) throws IOException {
        sgocketG = new Socket();
        InetSocketAddress direccio = new InetSocketAddress("alt1.gmail-smtp-in.l.google.com", 25);
        
        sgocketG.connect(direccio);
        
        MSG();
    }
    
    public static String getFlujo(InputStream is) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bfr = new BufferedReader(isr);
        String result = bfr.readLine();
        
        return result;
    }
    
    public static void MSG() throws IOException{
        PrintWriter pw = new PrintWriter(sgocketG.getOutputStream());
        InputStream is = sgocketG.getInputStream();
        
        String correu = "francesccoll@paucasesnovescifp.cat";
        
        String recived = getFlujo(is);
        System.out.println(recived);
        
        pw.println("helo example.com");
        pw.flush();
        recived = getFlujo(is);
        System.out.println(recived);
        
        pw.println("MAIL FROM: <" + "a@gmail.com" + ">");
        pw.flush();
        recived = getFlujo(is);
        System.out.println(recived);
        
        pw.println("RCPT TO: <" + correu + ">");
        pw.flush();
        recived = getFlujo(is);
        System.out.println(recived);
        
        pw.println("DATA");
        pw.flush();
        recived = getFlujo(is);
        System.out.println(recived);
        
        pw.println("to: username a@gmail.com");
        pw.println("From: FromName " + correu);
        pw.println("Subject: hola");
        pw.println("hola");        
        pw.println(".");        
        pw.flush();
        recived = getFlujo(is);
        System.out.println(recived);
        
        pw.println("quit");
        pw.flush();
        recived = getFlujo(is);
        System.out.println(recived);
    }
    
}
