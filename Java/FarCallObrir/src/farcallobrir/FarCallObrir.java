package farcallobrir;

public class FarCallObrir {

    public static void main(String[] args) {
       Runtime r = Runtime.getRuntime();
       Process p = null;
       String comando[] = {"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe/","C:/Users/xesc2/Documents/NetBeansProjects/Projecta1/index.html"};// link del nevagador + link arxiu que es vol executar amb ell.
       
       System.out.println("Obrint...");
       
       try {
            p = r.exec(comando);
       } catch (Exception e) {}
     }
}
