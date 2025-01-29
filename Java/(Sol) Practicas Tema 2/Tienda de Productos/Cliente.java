package shop.semaphore;

import java.util.Random;

public class Cliente {

    int id;
    int[] productos;

    public int[] generarProductos() {
        int[] p = new int[random(2, 10)];
        for (int i = 0; i < p.length; i++) {
            p[i] = random(0, 2);
        }
        return p;
    }

    public int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public Cliente(int i) {
        id = i;
        productos = generarProductos();
    }

    public int getId() {
        return id;
    }

    public int[] getProductos() {
        return productos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductos(int[] productos) {
        this.productos = productos;
    }

}
