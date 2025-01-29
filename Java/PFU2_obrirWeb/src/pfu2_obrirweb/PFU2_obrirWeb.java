package pfu2_obrirweb;

import java.io.IOException;

public class PFU2_obrirWeb {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("open", "-a", "/Program Files (x86)/Google/Chrome/Application/chrome.exe", "/Users/xesc2/Documents/NetBeansProjects/PUF2_Francesc_Coll/index.html");
        pb.start();
     }
    
}

