package tema2fills.puente;

import static java.lang.Thread.sleep;
import java.util.Random;

public class Coche implements Runnable {

    int id;
    boolean norte;
    boolean prioritario;
    int nNS;
    int nSN;

    Contador cont;

    public Coche(int i, boolean n, boolean p, Contador c) {
        id = i;
        norte = n;
        cont = c;
        prioritario = p;
    }

    public int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Override
    public void run() {

        if (norte) {
            if (prioritario) {
                try {
                    cont.entraPrioritarioN();
                    System.out.println("La PolicÃ­a " + id + " ha entrado en el puente lado NORTE");
                    sleep(random(1000, 2000));
                    cont.salS();
                    System.out.println("La PolicÃ­a " + id + " ha salido en el puente lado SUD");
                } catch (InterruptedException ex) {
                }

            } else {
                try {
                    cont.entraN();
                    System.out.println("El coche " + id + " ha entrado en el puente lado NORTE");
                    sleep(random(1000, 2000));
                    cont.salS();
                    System.out.println("El coche " + id + " ha salido en el puente lado SUD");
                } catch (InterruptedException ex) {
                }
            }
        } else {
            if (prioritario) {
                try {
                    cont.entraPrioritarioS();
                    System.out.println("La PolicÃ­a " + id + " ha entrado en el puente lado SUD");
                    sleep(random(1000, 20000));
                    cont.SaleN();
                    System.out.println("La PolicÃ­a " + id + " ha salido en el puente lado NORTE");
                } catch (InterruptedException ex) {
                }
            } else {
                try {
                    cont.entraS();
                    System.out.println("El coche " + id + " ha entrado en el puente lado SUD");
                    sleep(random(1000, 20000));
                    cont.SaleN();
                    System.out.println("El coche " + id + " ha salido en el puente lado NORTE");
                } catch (InterruptedException ex) {
                }
            }
        }

    }

}
