package ssh.arpi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.jcraft.jsch.*;

public class SSHARPI {


    public static void main(String[] args) throws JSchException, InterruptedException, IOException, SftpException {
        String username = "xesc";
        String host = "192.168.18.137";
        int port = 22;
        
        readTo(username,host,"12345678",22, "ls -l");

        Session session = null;
        ChannelExec channel = null;
        
        String remoteShellScript = "/root/hello.sh";

        try {
            JSch jsch = new JSch();
            jsch.setKnownHosts("/home/xesc/");
            session = jsch.getSession(username, host, port);
            
            session.setPassword("12345678");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("mkdir babababa");
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.connect();

            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            System.out.println("SFTP Channel created.");

            InputStream inputStream = sftpChannel.get("file.txt");

            try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                
                
                ChannelExec channelExec = (ChannelExec) session.openChannel("exec");

            // run a shell script
            channelExec.setCommand("sh " + remoteShellScript + " mkyong");

            // display errors to System.err
            channelExec.setErrStream(System.err);

            InputStream in = channelExec.getInputStream();

            // 5 seconds timeout channel
            channelExec.connect(1);

            // read the result from remote server
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channelExec.isClosed()) {
                    if (in.available() > 0) continue;
                    System.out.println("exit-status: "
                         + channelExec.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            } finally {
                if (session != null) {
                    session.disconnect();
                }
                if (channel != null) {
                    channel.disconnect();
                }

            }
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }
    
    public static void readTo(String username, String host, String password, int port, String command) throws JSchException, IOException {
        Session session = null;
        session = new JSch().getSession(username, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        
        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        channelExec.setCommand(command);
        channelExec.setErrStream(System.err);
        
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        ByteArrayOutputStream errorBuffer = new ByteArrayOutputStream();

        InputStream in = channelExec.getInputStream();
        InputStream err = channelExec.getExtInputStream();

        channelExec.connect();

        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) break;
                outputBuffer.write(tmp, 0, i);
            }
            while (err.available() > 0) {
                int i = err.read(tmp, 0, 1024);
                if (i < 0) break;
                errorBuffer.write(tmp, 0, i);
            }
            if (channelExec.isClosed()) {
                if ((in.available() > 0) || (err.available() > 0)) continue; 
                break;
            }
        }

        System.out.println(outputBuffer.toString("UTF-8"));
        System.out.println( errorBuffer.toString("UTF-8"));
        channelExec.disconnect();
        }
    }

