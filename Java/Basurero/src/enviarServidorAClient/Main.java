/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enviarServidorAClient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.pkcs11.wrapper.Functions;

public class Main {
    private static ServerSocket server;
    private static Socket socket;

    public static void startServer(int port)
    {   
        try 
        {
            server = new ServerSocket(port);
            socket = server.accept();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void restartServer()
    {
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    socket = server.accept();
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    public static void sendFile(String inputFilePath)
    {
        FileInputStream fis;
        BufferedInputStream bis;
        OutputStream os;
        BufferedOutputStream bos;
        try 
        {
            File input = new File(inputFilePath);
            fis = new FileInputStream(input);
            bis = new BufferedInputStream(fis);
            os = socket.getOutputStream();
            bos = new BufferedOutputStream(os);
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
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        restartServer();
    }
}