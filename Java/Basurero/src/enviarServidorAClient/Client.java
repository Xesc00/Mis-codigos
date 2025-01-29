package enviarServidorAClient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.pkcs11.wrapper.Functions;

public class Client {
  private static Socket socket;
    private static String hostName;
    private static int portNumber;

    public static void connectToServer(String host, int port)
    {
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    hostName = host;
                    portNumber = port;
                    socket = new Socket(host, port);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    private static void reconnectToServer()
    {
        try 
        {
            socket = new Socket(hostName, portNumber);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void receiveFile(String outputFilePath)
    {
        InputStream is;
        BufferedInputStream bis;
        FileOutputStream fos;
        BufferedOutputStream bos;
        try 
        {
            File output = new File(outputFilePath);
            is = socket.getInputStream();
            bis = new BufferedInputStream(is);
            fos = new FileOutputStream(output);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int data;
            while(true)
            {
                data = bis.read(buffer);
                if(data != -1)
                {
                    bos.write(buffer, 0, 1024);
                }
                else
                {
                    bis.close();
                    bos.close();
                    break;
                }
            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        reconnectToServer();
    }
}