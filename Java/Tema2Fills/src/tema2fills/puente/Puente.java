//https://www.dit.upm.es/~pepe/doc/adsw/tema2/ejercicios.pdf
package tema2fills.puente;

import java.util.ArrayList;

public class Puente {

    static int NUM_COCHES = 150;

    public static void main(String[] args) throws InterruptedException {

        int contador = 0;
        Coche coche;
        Contador cont = new Contador();
        ArrayList<Coche> cochesNS = new ArrayList<>();
        ArrayList<Coche> cochesSN = new ArrayList<>();

        Thread th;
        Init init;

        for (int i = 0; i < NUM_COCHES; i++) {
            if (i == 10 || i == 50 || i == 100) {
                coche = new Coche(contador, true, true, cont);
                cochesNS.add(coche);
                contador++;
            } else {
                coche = new Coche(contador, true, false, cont);
                cochesNS.add(coche);
                contador++;
            }
        }

        for (int i = 0; i < NUM_COCHES; i++) {
            if (i == 10 || i == 50 || i == 100) {
                coche = new Coche(contador, false, true, cont);
                cochesSN.add(coche);
                contador++;
            } else {
                coche = new Coche(contador, false, false, cont);
                cochesSN.add(coche);
                contador++;
            }
        }

        init = new Init(cochesSN);
        th = new Thread(init);
        th.start();
        init = new Init(cochesNS);
        th = new Thread(init);
        th.start();

    }

}
