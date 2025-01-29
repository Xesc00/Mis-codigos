package treballtema3_basededatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static Socket server;
    public static String uri = "C:\\Users\\xesc2\\Documents\\NetBeansProjects\\TreballTema3_BaseDeDatos\\src\\treballtema3_basededatos\\bbdd.txt";
    
    public static void main(String[] args) {
        try{
            System.out.println("Run server");
            ServerSocket serverSocket = new ServerSocket(4455);
            server = serverSocket.accept();

            comunicacio();
            
        } catch (Exception e){
            System.out.println("Fallo en el servidor");
        }
    }
    
    public static void comunicacio() throws IOException{
        //ESPERA CONEXIO CLIENT
            System.out.println(" - - - - - ");
            System.out.println("conexio ok");
            System.out.println(" - - - - - ");
            
            //Llegeixe el primer missatge  que envia el client
            int d = 0;
            while(d == 0){
                //Llegeix el missage que entra desde el client i el guarda dedins un String
                InputStream is = server.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bf = new BufferedReader(isr);
                String operacio = bf.readLine();
            
                System.out.println(operacio);
                
                //Switch per determinar que fara el servidor
                switch(operacio)
                {
                    case "insert":
                        insert();
                        break;
                    case "select":
                        select();
                        break;
                    case "delete":
                        delete(uri);
                        break;
                    case "sortir":
                        System.out.println("El client ha acabat");
                        d++;
                        break;
                    default:
                        System.out.println("L'usuari no ha introduit una operacio disponible");
                        break;
                }
            }
    }
    
    public static void send(String cadena) throws IOException{
        PrintWriter pw = new PrintWriter(server.getOutputStream());
        pw.print(cadena + "\n");
        pw.flush();
    }
    
    public static void insert() throws IOException{
        InputStream is = server.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bf = new BufferedReader(isr);
        
        System.out.println("El client ha elegit fer un insert");
        
        String id = bf.readLine();
            
        String nom = bf.readLine();
            
        String lli = bf.readLine();
        try{
            addText(id, nom, lli);//Metode per afegir al document bbdd.txt les dades
            send("Creacio correcta");
                            
            } catch (IOException e){
                System.out.println("Error insert");
            }
                        
            System.out.println("S'ha introduit: id: " + id + "  nom i llinatges: " + nom + " " + lli );
    }
    
    public static void addText(String id, String nom, String lli) throws IOException{
        File file = new File(uri);
        
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        fw.append(id + "," + nom + "," + lli + " \n");
        fw.close();
    }
    
    public static void select() throws IOException{
        System.out.println("El client ha elegit fer un selsct");
        
        InputStream is = server.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bf = new BufferedReader(isr);
        
        String id =  bf.readLine();
        System.out.println(id);
        
        try {
            FileReader fr = new FileReader(uri);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            String info = null;
            
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
            send(info);
        }
        catch(Exception e) {
            System.out.println("Fallo de lectura del arxiu" + e);
        }
    }
    
    public static void delete(String filepath) throws IOException {
       InputStream is = server.getInputStream();
       InputStreamReader isr = new InputStreamReader(is);
       BufferedReader bf = new BufferedReader(isr);
       
       System.out.println("El client ha elegit fer un delete");
       
       String removeTerm = bf.readLine();
       
       int position = 0; //La posicio on es troba l'element que ha de borrar
       String tempFile = "temp.txt"; //Arxiu en el que es redirigira el que es vol borrar y aquest sira borrat
       File oldFile = new File(filepath);
       File newFile = new File(tempFile);
       
       String currentLine;
       String data[];
       
       try
       {
           FileWriter fw = new FileWriter (tempFile,true);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw);
           
           FileReader fr = new FileReader(filepath);
           BufferedReader br = new BufferedReader(fr);
           
           while((currentLine = br.readLine()) != null)
           {
               data = currentLine.split(",");
               if(!(data[position].equalsIgnoreCase(removeTerm))) 
               {
                   pw.println(currentLine);
               }
           }
           
           pw.flush();
           pw.close();
           fr.close();
           br.close();
           bw.close();
           fw.close();
           
           oldFile.delete();
           File dump = new File(filepath);
           newFile.renameTo(dump);
           send("Sa borrat l'entrada");
       }
       catch (Exception e)
       {
           System.out.println("No sa pogut borrar");
           send("No sa pogut borrar");
       }
    }
}
