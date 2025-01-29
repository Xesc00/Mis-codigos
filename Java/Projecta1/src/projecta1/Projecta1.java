package projecta1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//http://www.cbconsell.com/croniques-7-8-novembre/
public class Projecta1 {

    public static String menu(String link)throws IOException{
        boolean gate = false;
        
        while (gate == false){
        System.out.println("Introdeix el que vols fer <numero>");
        System.out.println("<-----------------------MENU------------------------->");
        System.out.println("1-Carregar pàgina Web");
        System.out.println("2-Analitzar número de vocals");
        System.out.println("3-Substituir lletres");
        System.out.println("4-Llegir encrypted.txt");
        System.out.println("5-Cercar paraules clau");
        System.out.println("6-Crear arxiu index.html");
        System.out.println("7-Ejecutar arxiu index.html a través d’un navegador");
        System.out.println("8-Exit");
        System.out.println("<---------------------------------------------------->");   
        System.out.println("Recorda que has introduit el seguent link: " + link);
        int opcio = 0;
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            opcio = Integer.parseInt(buff.readLine());
        } catch (Exception e){
            System.out.println("Error");
        }
        
        boolean sino = false;//Variablea per seguir el bucle o no
        
        switch (opcio){
                case 1:
                    System.out.println("1-Carregar pàgina Web");
                    html(link);
                    
                    while (sino == false){
                        System.out.println("Vols continuar fent coses? Si o No");
                        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                        String resposta = buff.readLine();
                        
                    switch (resposta) {
                        case "No":
                            gate = true;
                            sino = true;
                            break;
                        case "no":
                            gate = true;
                            sino = true;
                            break;    
                        case "Si":
                            sino = true;
                            break;
                        case "si":
                            sino = true;
                            break;
                        default:        
                            System.out.println("No es una resposta valida per favor escriu \"Si\" o \"Noª\" ");
                            break;
                        }
                    }
                    break; 
                case 2:
                    System.out.println("2-Analitzar número de vocals");
                    vocal(link);
                    
                    while (sino == false){
                        System.out.println("Vols continuar fent coses? Si o No");
                        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                        String resposta = buff.readLine();
                        
                    switch (resposta) {
                        case "No":
                            gate = true;
                            sino = true;
                            break;
                        case "no":
                            gate = true;
                            sino = true;
                            break;    
                        case "Si":
                            sino = true;
                            break;
                        case "si":
                            sino = true;
                            break;
                        default:        
                            System.out.println("No es una resposta valida per favor escriu \"Si\" o \"Noª\" ");
                            break;
                        }
                    }
                    break; 
                case 3:
                    System.out.println("3-Substituir lletres");
                    substituir(link);
                    
                    while (sino == false){
                        System.out.println("Vols continuar fent coses? Si o No");
                        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                        String resposta = buff.readLine();
                        
                    switch (resposta) {
                        case "No":
                            gate = true;
                            sino = true;
                            break;
                        case "no":
                            gate = true;
                            sino = true;
                            break;    
                        case "Si":
                            sino = true;
                            break;
                        case "si":
                            sino = true;
                            break;
                        default:        
                            System.out.println("No es una resposta valida per favor escriu \"Si\" o \"Noª\" ");
                            break;
                        }
                    }
                    break; 
                case 4:
                    System.out.println("4-Llegir encrypted.txt");
                    showRemplaç();
                    
                    while (sino == false){
                        System.out.println("Vols continuar fent coses? Si o No");
                        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                        String resposta = buff.readLine();
                        
                    switch (resposta) {
                        case "No":
                            gate = true;
                            sino = true;
                            break;
                        case "no":
                            gate = true;
                            sino = true;
                            break;    
                        case "Si":
                            sino = true;
                            break;
                        case "si":
                            sino = true;
                            break;
                        default:        
                            System.out.println("No es una resposta valida per favor escriu \"Si\" o \"Noª\" ");
                            break;
                        }
                    }
                    break; 
                case 5:
                    System.out.println("5-Cercar paraules clau");
                    paraula(link);
                    
                    while (sino == false){
                        System.out.println("Vols continuar fent coses? Si o No");
                        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                        String resposta = buff.readLine();
                        
                    switch (resposta) {
                        case "No":
                            gate = true;
                            sino = true;
                            break;
                        case "no":
                            gate = true;
                            sino = true;
                            break;    
                        case "Si":
                            sino = true;
                            break;
                        case "si":
                            sino = true;
                            break;
                        default:        
                            System.out.println("No es una resposta valida per favor escriu \"Si\" o \"Noª\" ");
                            break;
                        }
                    }
                    break; 
                case 6:
                    System.out.println("6-Crear arxiu index.html");
                    nom(link);
                    
                    while (sino == false){
                        System.out.println("Vols continuar fent coses? Si o No");
                        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                        String resposta = buff.readLine();
                        
                    switch (resposta) {
                       case "No":
                            gate = true;
                            sino = true;
                            break;
                        case "no":
                            gate = true;
                            sino = true;
                            break;    
                        case "Si":
                            sino = true;
                            break;
                        case "si":
                            sino = true;
                            break;
                        default:        
                            System.out.println("No es una resposta valida per favor escriu \"Si\" o \"Noª\" ");
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("7-Ejecutar arxiu index.html a través d’un navegador");
                    obrir();
                    
                    
                    while (sino == false){
                        System.out.println("Vols continuar fent coses? Si o No");
                        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                        String resposta = buff.readLine();
                        
                    switch (resposta) {
                        case "No":
                            gate = true;
                            sino = true;
                            break;
                        case "no":
                            gate = true;
                            sino = true;
                            break;    
                        case "Si":
                            sino = true;
                            break;
                        case "si":
                            sino = true;
                            break;
                        default:        
                            System.out.println("No es una resposta valida per favor escriu \"Si\" o \"Noª\" ");
                            break;
                        }
                    }
                    break; 
                case 8:
                    System.out.println("Exit");
                    gate = true;
                    break;
                default:
                    break;      
            }    
        }
        return null;
    }
    
    public static void html(String link) throws IOException{
        Runtime rt = Runtime.getRuntime();
        
        try {
            Process farcall = null;
            farcall = rt.exec("java -jar /Users/xesc2/Documents/NetBeansProjects/Projecta1/dist/Projecta1.jar");
        
            OutputStream os = farcall.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);
         
            pw.print(link);
            pw.close();
        
        
            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
        
            while (br.readLine() != null){
               System.out.println(br.readLine());
            }
        } catch (Exception e) {
            System.out.println("Algo ha anat malament amb el document html");
        }
    }
    
    public static void vocal(String link) throws IOException{
        
        boolean gate = false;//variabel per aturar el while
        
        while(gate == false){
        
            System.out.println("Quina es la vocal que sercas?");
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String vocal = buff.readLine();
        
            vocal = vocal.toUpperCase();//Convertesc tots es resultats a majuscules
        
            if ("A".equals(vocal) || "E".equals(vocal) || "I".equals(vocal) || "O".equals(vocal) || "U".equals(vocal)) {
                    System.out.println("Sercas la vocal " + vocal );
                    
                    Runtime rt = Runtime.getRuntime();
                    
                try {
                        Process farcall = null;
                        farcall = rt.exec("java -jar /Users/xesc2/Documents/NetBeansProjects/FarcallVocal/dist/FarcallVocal.jar");
        
                        OutputStream os = farcall.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        PrintWriter pw = new PrintWriter(osw);
                
                        pw.print(link);
                        pw.print(vocal);
                        pw.close();
                        
                        InputStream is = farcall.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                    
                        System.out.println(br.readLine()); 
                        
                } catch (Exception e) {
                        System.out.println("Algo ha anat malament");
                }
                gate = true;
             } else {
                System.out.println("No es una resposta valida");
            }
        }
    }
    
    public static void substituir(String link) throws IOException{
        String entra = null, surt = null;
        
        boolean gate = false;
        while(gate == false){
                System.out.println("Quina lletra vols posar? ");
                BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                entra = buff.readLine();
                int lentra = entra.length();//Mirar quantes lletres hi ha per confirmar que només sigui una
            
                System.out.println("I quina substituira? ");
                BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
                surt = bff.readLine();
                int lsurt = surt.length();
            
                if (lentra == 1 && lsurt == 1) {
                    gate = true;
                } else {
                    System.out.println("Has posat més d'una lletra");
                }
        }
            System.out.println("Cambiaras la lletra " + surt + " per la lletra " +  entra);
        try {
            Runtime rt = Runtime.getRuntime();
        
                Process farcall = null;
                farcall = rt.exec("java -jar /Users/xesc2/Documents/NetBeansProjects/FarCallLletra/dist/FarCallLletra.jar");
        
                OutputStream os = farcall.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                PrintWriter pw = new PrintWriter(osw);
                pw.print(link);
                pw.print(entra);
                pw.print(surt);
                pw.close();
                
                InputStream is = farcall.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                
                System.out.println(br.readLine());
                    
        } catch (Exception e) {
            System.out.println("Algo ha anat malament");
        }
        
        
    }
    
    public static void showRemplaç() throws IOException{
        Runtime rt = Runtime.getRuntime();
        try {
            Process farcall = null;
            farcall = rt.exec("java -jar /Users/xesc2/Documents/NetBeansProjects/FarCallShow/dist/FarCallShow.jar");
        
        
            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
        
            while (br.readLine() != null){
               System.out.println(br.readLine());
            }
        } catch (Exception e) {
            System.out.println("Algo ha anat malament");
        }
    }
    
    public static void paraula(String link) throws IOException{
        Runtime rt = Runtime.getRuntime();
        try {
            System.out.println("Introudeix la paraula que sercas");
        
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String paraula = buff.readLine();
            
            Process farcall = null;
            farcall = rt.exec("java -jar /Users/xesc2/Documents/NetBeansProjects/FarCallParaula/dist/FarCallParaula.jar");
            
            OutputStream os = farcall.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);
         
            pw.print(link);
            pw.print(paraula);
            pw.close();
        
            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            System.out.println(br.readLine());//No entec perque no accepta lees paraules que no aperixen i les torna com null, i les que si diu que no i son
            
        } catch (Exception e) {
            System.out.println("Algo ha anat malament amb el document html");
        }
    }
    
    public static void nom(String link) throws IOException{
        Runtime rt = Runtime.getRuntime();
        try {
            System.out.println("Introudeix el nom d'un alumne");
        
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String nom = buff.readLine();
            
            Process farcall = null;
            farcall = rt.exec("java -jar /Users/xesc2/Documents/NetBeansProjects/FarCallNom/dist/FarCallNom.jar");
            
            OutputStream os = farcall.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);
         
            pw.print(link);
            pw.print(nom);
            pw.close();
        
            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            System.out.println(br.readLine());
            
        } catch (Exception e) {
            System.out.println("Algo ha anat malament amb el document html");
        }
    }
    
    public static void obrir() throws IOException{
        Runtime rt = Runtime.getRuntime();
        try {
            Process farcall = null;
            farcall = rt.exec("java -jar /Users/xesc2/Documents/NetBeansProjects/FarCallObrir/dist/FarCallObrir.jar");
        
            InputStream is = farcall.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            System.out.println(br.readLine());
            
        } catch (Exception e) {
            System.out.println("Algo ha anat malament amb el document html");
        }
    }
    
    public static void exit() throws IOException{
        
    }
    
    public static void main(String[] args) throws IOException {
        boolean valorp = false; //Varaible la qual diu si hi ha escrit dedins es link "hhtp" o "https"
        
        while (valorp == false) {    
            System.out.println("Introdueix l'enllaç: ");
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String link = buff.readLine();
        
            CharSequence http = "http";
        
            valorp = link.contains(http); //Comprobar si conte la "paraula" http o https si no es torna a demanar un link que si correspongui o tebgui.
           
            if (valorp == false) {
                System.out.println("Has d'introduir un link valid");
            } else{
                menu(link); //Origen de tot
            }
        }
    }

}
