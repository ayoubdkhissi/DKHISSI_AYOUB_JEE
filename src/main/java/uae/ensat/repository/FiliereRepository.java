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
        entityManager = Persistence.createEntityManagerFactory("EclipseLink_PU").createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    
    
    // Obtenir la list de toutes les filieres
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
    
    public List<Filiere> getWithPagination(int pageIndex)
    {
        List<Filiere> filieres = new ArrayList<>();

        try {
            Query req = entityManager.createQuery(" select f from Filiere f ").setFirstResult(pageIndex*4).setMaxResults(4);
            
            filieres = req.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception message dans getAll Filieres: " + ex.getMessage());
        }

        return filieres;
    }
    
    // Get filiere by Id
    public Filiere getById(String code_fil)
    {
        try{
            Filiere filiere = (Filiere) entityManager.find(Filiere.class, code_fil);
            return filiere;
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Exception in getById filiere: " + ex.getMessage());
        }
        return null;
    }
    
    
    // Add new filiere
    public void add(Filiere filiere)
    {
        try{
            entityTransaction.begin();
            entityManager.persist(filiere);
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Exception message dans Add filiere: " + ex.getMessage());
        }
    }
    
    
    // update filiere
    public void update(Filiere filiere)
    {
        try{
            entityTransaction.begin();
            entityManager.merge(filiere);
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Exception message dans update filiere: " + ex.getMessage());
        }
    }
    
    // Delete filiere by id
    public void deleteById(String code_fil)
    {
        try{
            Filiere filiere = this.getById(code_fil);
            
            entityTransaction.begin();
            entityManager.remove(filiere);
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Exception message dans delete filiere: " + ex.getMessage());
        }
    }
    
    // get total count of fillieres
    public int getTotalCountOfFiliere()
    {
        Query query = entityManager.createNativeQuery("select count(*) from filieres");
        return Integer.valueOf(query.getSingleResult().toString());
    }
    
    // get count of eleves in filiere
    public int getElevesCount(String code_fil)
    {
        Query query = entityManager.createNativeQuery("select count(*) from eleves where ref_fil = '"+code_fil+"'");
        return Integer.valueOf(query.getSingleResult().toString());
    }
}
