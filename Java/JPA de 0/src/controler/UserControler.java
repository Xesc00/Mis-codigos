package controler;

import connection.Connection;
import entitiats.Aspirants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserControler {

    
    public List<Aspirants> llistaAspirants(){
        
        EntityManager em = entityManager();
        Query q = null;
        try {
            q = em.createQuery("SELECT a FROM Aspirant a");
            
        } catch (Exception ex) {

        } finally {
            em.close();
        }
        return q.getResultList();
    } 

    private EntityManager entityManager(){
        return Connection.getInstancia().getFabrica().createEntityManager();
    }
}
