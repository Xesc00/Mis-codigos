package pfu2_francesc_coll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Pare {

    static String codiHtml;
    public static void main(String[] args) throws IOException {
        System.out.println("Introdeix el que vols fer <numero>");
        menu();
    }
    
    public static void menu() throws IOException{
        System.out.println("<-----------------------MENU------------------------->");
        System.out.println("1-Carregar pagina Web");
        System.out.println("2-Analitzar numero de vocals");
        System.out.println("3-Substituir lletres");
        System.out.println("4-Llegir encrypted.txt");
        System.out.println("5-Cercar paraules clau");
        System.out.println("6-Crear arxiu index.html");
        System.out.println("7-Ejecutar arxiu index.html a travess de un navegador");
        System.out.println("8-Exit");
        System.out.println("<---------------------------------------------------->");   
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        //faig que sigui un string en lloc d'un int perque no doni error si pos una lletra si esta fet en integer
        String resp= reader.readLine();
        String ling = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
        switch(resp){
            case "1":
                codiHtml = html(ling);
                System.out.println(codiHtml);
                break;
            case "2":
                System.out.println(vocal());
                break;
            case "3":
                sustituir();
                break;
            case "4":
                llegeix();
                break;
            case "5":
                sercear();
                break;
            case "6":
                body();
                break;
            case "7":
                obrirWeb();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("\nResposta no valida");
                menu();
                break;
        }
        menu();
    }
    //He refet tot es codi perque he vist que fento amb runtime no funcipnave del tot be i me han dit que aixi si funciona
    //Obviament he de fer canvis a totes els metodes i a tots els fills, ja que ara ho fare amb proccesBuilder
    
    public static String html(String link) throws IOException{
        try {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("java", "-jar", "\\Users\\xesc2\\Documents\\NetBeansProjects\\PFU2_Francesc_Coll\\dist\\PFU2_Francesc_Coll.jar", link);

            Process farcall = pb.start();

            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            return (br.readLine());
        } catch (Exception e) {
            System.out.println("Algo ha anat malament "+ e);
        }
        return "err";
    }
    
    public static String vocal() throws IOException{
        try {
            String vocal = demana("Quina es la vocal que sercas?");

            ProcessBuilder pb = new ProcessBuilder();
            pb.command("java", "-jar", "C:\\Users\\xesc2\\Documents\\NetBeansProjects\\PFU2_contarVocal\\dist\\PFU2_contarVocal.jar", vocal);
            Process farcall = pb.start();

            OutputStream os = farcall.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);
            pw.print(codiHtml);
            pw.close();

            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            return (br.readLine());
        } catch (Exception e) {
            System.out.println("Algo ha anat malament "+ e);
        }
        return "err";
    }
    
    public static void sustituir() throws IOException{
        try {
            String entra = demana("Quina es la lletra que sercas?");
            String surt = demana("Quina es la lletra que vols rempazar?");

            ProcessBuilder pb = new ProcessBuilder();
            pb.command("java", "-jar", "\\Users\\xesc2\\Documents\\NetBeansProjects\\PFU2_sustituir\\dist\\PFU2_sustituir.jar", entra, surt);
            Process farcall = pb.start();

            OutputStream os = farcall.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);
            pw.print(codiHtml);
            pw.close();

            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            System.out.println(br.readLine());
        } catch (Exception e) {
            System.out.println("Algo ha anat malament "+ e);
        }
    }
    
    public static void llegeix() throws IOException{
        try {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("java", "-jar", "\\Users\\xesc2\\Documents\\NetBeansProjects\\PFU2_obrir\\dist\\PFU2_obrir.jar");
            Process farcall = pb.start();

            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            System.out.println(br.readLine());
        } catch (Exception e) {
            System.out.println("Algo ha anat malament "+ e);
        }
    }
    
    public static void sercear() throws IOException{
        try {
            String paraula = demana("Quina paraula vols sercar?");

            ProcessBuilder pb = new ProcessBuilder();
            pb.command("java", "-jar", "\\Users\\xesc2\\Documents\\NetBeansProjects\\PFU2_paraula\\dist\\PFU2_paraula.jar", paraula);

            Process farcall = pb.start();

            OutputStream os = farcall.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);
            pw.print(codiHtml);
            pw.close();

            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            System.out.println(br.readLine());
        } catch (Exception e) {
            System.out.println("Algo ha anat malament "+ e);
        }

    }
    
    public static void body(){
        try {
            String nom = demana("Digues quin es el teu nom");
           
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("java", "-jar", "\\Users\\xesc2\\Documents\\NetBeansProjects\\PFU2_body\\dist\\PFU2_body.jar", nom);
            Process farcall = pb.start();
            
            OutputStream os = farcall.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);
            pw.print(codiHtml);
            pw.close();
            
            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            System.out.println(br.readLine());
        } catch (Exception e) {
            System.out.println("Algo ha anat malament " + e);
        }
    }
    
    public static void obrirWeb(){
        try {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("java", "-jar", "\\Users\\xesc2\\Documents\\NetBeansProjects\\PFU2_obrirWeb\\dist\\PFU2_obrirWeb.jar");
        
            pb.start();
        } catch (Exception e) {
            System.out.println("Algo ha anat malament " + e);
        }
    }
    
    public static String demana(String txt) throws IOException{
        System.out.println(txt);
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String msg = buff.readLine();
        
        return msg;
    }
}

