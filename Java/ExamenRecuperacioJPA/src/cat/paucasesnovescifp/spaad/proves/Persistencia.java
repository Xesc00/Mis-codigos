package cat.paucasesnovescifp.spaad.proves;

import cat.paucasesnovescifp.spaad.controlErrors.JPAException;
import cat.paucasesnovescifp.spaad.model.Aspirant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.MappingException;

public class Persistencia {
    private String unitatPersistencia;

    public Persistencia(String unitatPersistencia) throws JPAException {
        super();
        if (unitatPersistencia == null || unitatPersistencia.trim().equals("")) {
            throw new JPAException("La unitat de persistència no pot ser buida");
        }
        this.unitatPersistencia = unitatPersistencia;
    }

    public String getUnitatPersistencia() {
        return unitatPersistencia;
    }
    
    public List<Aspirant> llistaAspirants() throws JPAException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();
        Query q = null;
        try {
            q = em.createQuery("SELECT a FROM Aspirant a");
            
        } catch (MappingException ex) {
            throw new JPAException(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return q.getResultList();
    } 
    
    public ArrayList<Aspirant> preferenciesAspirantJPQL(String nif) throws JPAException{
      ArrayList<Aspirant> resultat = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();
        try {
            String sq = "";
            if(nif == null) sq = "SELECT a FROM Aspirant a ORDER BY a.llinatges";
            //Si intent posar que només es mostri parametres en conceret com per exemple només el nom diu que TypedQuery no es compatible amb aquest format
            else sq = "SELECT a FROM Aspirant a WHERE a.nif = \'"+ nif + "\'";
            
            //Es max result esta sempre ja que si tenc un nif, només en mostrara 1 i si es null pues si ho si n'ha de ostrar 10
            TypedQuery<Aspirant> query = em.createQuery(sq, Aspirant.class).setMaxResults(10);
 
            resultat = (ArrayList<Aspirant>) query.getResultList();
            
        } catch (MappingException ex) {
            throw new JPAException(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return resultat;
        }
    
    
    public ArrayList<Aspirant> preferenciesAspirantNQ(){
        ArrayList<Aspirant> resultat = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager em = emf.createEntityManager();
        
        try {
          TypedQuery<Aspirant> query = em.createNamedQuery("Aspirant.findAll", Aspirant.class);
          resultat = (ArrayList<Aspirant>) query.getResultList();
        } catch (MappingException ex) {
          throw new JPAException(ex.getMessage());
        } finally {

        em.close();
        emf.close();

        return resultat;
        }
        
    }
 
    //Prova de que la conexio i el mapegat funciona
    public static Aspirant tornaAspirant(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("interins-pu");
        EntityManager em = emf.createEntityManager();
        
        Aspirant asp = em.find(Aspirant.class, id);
        em.close();
        emf.close();
        return asp;
    }
    
}
