 
package p7;

import java.io.IOException;

public class P7 {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("open", "-a", "Google Chrome", "index.html");
        pb.start();
    }
    
}
