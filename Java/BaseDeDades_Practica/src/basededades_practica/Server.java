package basededades_practica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private ServerSocket ss;
    public static Socket cs;
    public static String uri = "bbdd.txt";
    
    public static void main(String[] args) {
        Server s = new Server(2000);
        System.out.println("Serveidor Iniciat");
        s.start();
    }

    public Server(int port) {
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                cs = ss.accept();

                // CONSEXIO CLIENT
                System.out.println("Esperant informacio del Client");

                
                opcions(seraSera("Que vols fer? insert | select | delete"));

            } catch (IOException e) {
                    e.printStackTrace();
            }
        }
    }

    //Metode per enviar dades al client i aixi ja esperar un resposta d'aquest
    public static String seraSera(String diu) throws IOException{
        DataInputStream in = new DataInputStream(cs.getInputStream());
        DataOutputStream out =  new DataOutputStream(cs.getOutputStream());

        out.writeUTF(diu);

        String mensaje = in.readUTF();

        return mensaje;
    }
    
    //Metode per organitzar el codi i guardar el switch dedins
    public static void opcions(String msg) throws IOException{
        switch(msg){
            case "insert":
                System.out.println("L'usari ha elegit fer " + msg);
                addText(seraSera("Quin sira l'ID de lentrada?"), seraSera("Quin es el nom?"), seraSera("Quin es el llinatge?"));
                System.out.println("S'han insertat les dades");
                
                send("S'han insertat les dades");
                break;
            case "select":
                System.out.println("L'usari ha elegit fer " + msg);
                serch();
                break;
            case "delete":
                System.out.println("L'usari ha elegit fer " + msg);
                delete();
                break;
            case "sortir":
                break;
            default:
                System.out.println("El que has elegitel client no es valid");
                opcions(seraSera(""));
                break;
        }
    } 
    
    //Afegeix el text dedins el txt que estigui declarat dedins de la variable de uri 
    public static void addText(String id, String nom, String lli) throws IOException{
        File file = new File(uri);
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        fw.append(id + "," + nom + "," + lli + " \n");
        fw.close();
    }
    
    //Serque el fitxer de la ruta uri iserque l'id i retorna les dades
    public static void serch(){
        try {
            FileReader fr = new FileReader(uri);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            String info = null;
            String id = seraSera("Quin es l'id que serques?");
            
            while((linea = br.readLine()) != null){
                if (linea.contains(id)){
                    if (info == null) info = linea;
                    else info += linea;
                }
            }
            fr.close();

            if (info == null) {
                info = "No sa trobat l'entrada que serques";
            }
            System.out.println(info);
            
            //Simplemnet estetic i només es veu en el client
            info = "ID: " + info;
            info = info.replaceFirst("," , "\nName: ");
            info = info.replaceFirst("," , "\nLlinatge: ");
            send(info);
        }
        catch(Exception e) {
            System.out.println("Fallo de lectura del arxiu" + e);
        }
    }
    
    public static void delete() throws IOException{
       String removeTerm = seraSera("Quin entrada vols borrar?");
       
       int position = 0; //La posicio on es troba l'element que ha de borrar
       String tempFile = "temp.txt"; //Arxiu en el que es redirigira el que es vol borrar y aquest sira borrat
       File oldFile = new File(uri);
       File newFile = new File(tempFile);
       
       String currentLine;
       String data[];
       Boolean dl = false;
       try
       {
           FileWriter fw = new FileWriter (tempFile,true);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw);
           
           FileReader fr = new FileReader(uri);
           BufferedReader br = new BufferedReader(fr);
           
           while((currentLine = br.readLine()) != null)
           {
               data = currentLine.split(",");
               if(!(data[position].equalsIgnoreCase(removeTerm))) 
               {
                   pw.println(currentLine);
               } else dl = true;
           }
           
           pw.flush();
           pw.close();
           fr.close();
           br.close();
           bw.close();
           fw.close();
           
           oldFile.delete();
           File dump = new File(uri);
           newFile.renameTo(dump);
           if(dl == true) send("Sa borrat l'entrada");
           else send("Aquesta entrada o no existeix o ja ha sigut borrada");
       }
       catch (Exception e)
       {
           System.out.println("No sa pogut borrar");
           send("No sa pogut borrar");
       }
    }
    
    //Metode per enviar dades directement al client
    public static void send(String msg) throws IOException{
        DataOutputStream out =  new DataOutputStream(cs.getOutputStream());
        
        out.writeUTF(msg);
    }
}