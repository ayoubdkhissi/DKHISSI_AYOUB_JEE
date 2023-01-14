
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import uae.ensat.models.Eleve;
import uae.ensat.models.Filiere;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Agent-47
 */
public class test {
    public static void main(String[] args) {
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EclipseLink_PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // test creating new filiere:
//        tx.begin();
//        em.persist(new Filiere("GINF", "GENIE INFORMATIQUE"));
//        tx.commit();
        

        // Test creating new eleve
//        tx.begin();
//        em.persist
//        (
//                new Eleve("KB123566", "DKHISSI", "AYOUB", 20.0, new Filiere("GINF", "GENIE INFORMATIQUE"))
//        );
//        tx.commit();
        
        
    }
}
