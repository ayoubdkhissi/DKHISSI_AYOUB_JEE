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
public class FiliereRepository implements IFiliereRepository{

    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public FiliereRepository() {
        entityManager = Persistence.createEntityManagerFactory("EclipseLink_PU").createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    
    
    // Obtenir la list de toutes les filieres
    @Override
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
    
    @Override
    public List<Filiere> getWithPagination(int pageIndex)
    {
        List<Filiere> filieres = new ArrayList<>();

        try {
            Query req = entityManager.createQuery(" select f from Filiere f ")
                    .setFirstResult(pageIndex*4)
                    .setMaxResults(4);
            
            filieres = req.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception message dans getAll Filieres: " + ex.getMessage());
        }

        return filieres;
    }
    
    // Get filiere by Id
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public int getTotalCountOfFiliere()
    {
        Query query = entityManager.createNativeQuery("select count(*) from filieres");
        return Integer.valueOf(query.getSingleResult().toString());
    }
    
    // get count of eleves in filiere
    @Override
    public int getElevesCount(String code_fil)
    {
        Query query = entityManager.createNativeQuery("select count(*) from eleves where ref_fil = '"+code_fil+"'");
        return Integer.valueOf(query.getSingleResult().toString());
    }
    
    
    // get number of eleves qui ont pas un filiere
    @Override
    public int getCountElevesSansFiliere()
    {
        Query query = entityManager.createNativeQuery("select count(*) from eleves where ref_fil is null");
        return Integer.valueOf(query.getSingleResult().toString());
    }
}
