/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Especialitat;
import model.EspecialitatPK;
import model.Illa;

/**
 *
 * @author Xesc
 */
public class ProvaJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("interins-pu");
        EntityManager em = emf.createEntityManager();
        Illa mallorca=em.find(Illa.class,"071");
        System.out.println("mallorca = " + mallorca);
        Especialitat informatica=em.find(Especialitat.class,new EspecialitatPK("0590","107"));
        System.out.println("informatica = " + informatica);
        em.close();
        emf.close();
    }
}