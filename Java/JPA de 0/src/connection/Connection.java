/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Xesc
 */
public class Connection {
    private static Connection instancia = new Connection();
    private EntityManagerFactory fabrica;
    
    private Connection(){
        fabrica = Persistence.createEntityManagerFactory("interins");
    }

    public static Connection getInstancia() {
        return instancia;
    }

    public static void setInstancia(Connection instancia) {
        Connection.instancia = instancia;
    }

    public EntityManagerFactory getFabrica() {
        return fabrica;
    }

    public void setFabrica(EntityManagerFactory fabrica) {
        this.fabrica = fabrica;
    }
    
}
