package uae.ensat.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import uae.ensat.models.Filiere;

/**
 *
 * @author Ayoub Dkhissi
 */
public class FiliereRepository {

    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public FiliereRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink_PU");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        
    }

    
    
    
    public List<Filiere> getAll() 
    {
        List<Filiere> filieres = new ArrayList<>();

        try {
            Query req = entityManager.createQuery(" select f from Filiere f");
            filieres = req.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception message dans getAll Filieres: " + ex.getMessage());
        }

        return filieres;
    }
}
