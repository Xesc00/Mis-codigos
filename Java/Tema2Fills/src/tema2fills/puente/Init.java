package tema2fills.puente;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import static tema2fills.puente.Puente.NUM_COCHES;


public class Init implements Runnable {

    ArrayList<Coche> coches;

    public Init(ArrayList<Coche> c) {
        coches = c;
    }

    public int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Override
    public void run() {
        try {
            Thread th;
            for (int i = 0; i < NUM_COCHES; i++) {
                sleep(random(1000, 10000));
                th = new Thread(coches.get(i));
                th.start();
            }
        } catch (InterruptedException ex) {

        }

    }

}
