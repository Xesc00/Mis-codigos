package projecte_tema_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Projecte_Tema_1 {

    static String content;

    public static String url() throws IOException {
        System.out.println("Add the url to analyze:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static String menu() throws IOException {
        System.out.println("1. Carregar pàgina Web");
        System.out.println("2. Analitzar número de vocals");
        System.out.println("3. Substituir lletres");
        System.out.println("4. llegir encrypted.txt");
        System.out.println("5. Cercar paraules clau");
        System.out.println("6. Crear arxiu index.html");
        System.out.println("7. Ejecutar arxiu index.html a través d’un navegador");
        System.out.println("8. Exit");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static String p1(String url) throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java", "-jar", "/Users/joanbarcelo/NetBeansProjects/U1/p1/dist/p1.jar", url);
        Process procesChild = pb.start();

        InputStream is = procesChild.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        return (br.readLine());
    }

    private static String p2() throws IOException {
        System.out.println("Vocal to count:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String vocal = reader.readLine();

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java", "-jar", "/Users/joanbarcelo/NetBeansProjects/U1/p2/dist/p2.jar", vocal);
        Process procesChild = pb.start();

        OutputStream os = procesChild.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        PrintWriter pw = new PrintWriter(osw);
        pw.print(content);
        pw.close();

        InputStream is = procesChild.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        return (br.readLine());
    }

    private static String p3() throws IOException {
        System.out.println("Char origin change:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String origenChange = reader.readLine();

        System.out.println("Char destination change:");
        String destinationChange = reader.readLine();

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java", "-jar", "/Users/joanbarcelo/NetBeansProjects/U1/p3/dist/p3.jar", origenChange, destinationChange);
        Process procesChild = pb.start();

        OutputStream os = procesChild.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        PrintWriter pw = new PrintWriter(osw);
        pw.print(content);
        pw.close();

        InputStream is = procesChild.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        return (br.readLine());
    }

    private static String p4() throws IOException {

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java", "-jar", "/Users/joanbarcelo/NetBeansProjects/U1/p4/dist/p4.jar");
        Process procesChild = pb.start();

        InputStream is = procesChild.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        return (br.readLine());
    }

    private static String p5() throws IOException {
        System.out.println("Word to find:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java", "-jar", "\\Users\\xesc2\\Documents\\NetBeansProjects\\(Sol) Practica Tema 1\\p5\\dist\\p5.jar", word);
        Process procesChild = pb.start();

        OutputStream os = procesChild.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        PrintWriter pw = new PrintWriter(osw);
        pw.print(content);
        pw.close();

        InputStream is = procesChild.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        return (br.readLine());
    }

    private static String p6() throws IOException {
        System.out.println("Your Name:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java", "-jar", "/Users/joanbarcelo/NetBeansProjects/U1/p6/dist/p6.jar", name);
        Process procesChild = pb.start();

        OutputStream os = procesChild.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        PrintWriter pw = new PrintWriter(osw);
        pw.print(content);
        pw.close();

        InputStream is = procesChild.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        return (br.readLine());
    }

    private static void p7() throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("java", "-jar", "/Users/joanbarcelo/NetBeansProjects/U1/p7/dist/p7.jar");
        pb.start();
    }

    public static void main(String[] args) throws IOException {

        String url = url();

        Boolean exit = false;
        String sentence;

        while (!exit) {

            sentence = menu();

            switch (sentence) {
                case "8":
                    exit = true;
                    System.out.println("Bye bye...");
                    break;
                case "7":
                    p7();
                    break;
                case "6":
                    System.out.println(p6());
                    break;
                case "5":
                    System.out.println(p5());
                    break;
                case "4":
                    System.out.println(p4());
                    break;
                case "3":
                    System.out.println(p3());
                    break;
                case "2":
                    System.out.println(p2());
                    break;
                case "1":
                    content = p1(url);
                    System.out.println(content);
                    break;
            }

        }
    }

}
