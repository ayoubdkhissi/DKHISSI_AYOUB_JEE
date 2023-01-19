/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uae.ensat.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import uae.ensat.models.Eleve;
import uae.ensat.models.Filiere;

/**
 *
 * @author Ayoub Dkhissi
 */
public class EleveRepository {

    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public EleveRepository() {
        entityManager = Persistence.createEntityManagerFactory("EclipseLink_PU").createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    // Obtenir la list de toutes les etudiants
    public List<Eleve> getAll() {
        List<Eleve> eleves = new ArrayList<>();

        try {
            Query req = entityManager.createQuery(" select e from Eleve e");
            eleves = req.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception message dans getAll Eleves: " + ex.getMessage());
        }

        return eleves;
    }

    // get une list d'etudiants paginée
    public List<Eleve> getWithPagination(int pageIndex) {
        List<Eleve> eleves = new ArrayList<>();

        try {
            Query req = entityManager.createQuery(" select e from Eleve e").setFirstResult(pageIndex * 4).setMaxResults(4);
            eleves = req.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception message dans getAll Eleves: " + ex.getMessage());
        }

        return eleves;
    }

    // Get eleve by Id
    public Eleve getById(String cne) {
        try {
            Eleve eleve = (Eleve) entityManager.find(Eleve.class, cne);
            return eleve;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception in getById eleve: " + ex.getMessage());
        }
        return null;
    }

    // Add new eleve
    public void add(Eleve eleve) {
        try {
            entityTransaction.begin();
            entityManager.persist(eleve);
            entityTransaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception message dans Add eleve: " + ex.getMessage());
        }
    }

    // update eleve
    public void update(Eleve eleve) {
        try {
            entityTransaction.begin();
            entityManager.merge(eleve);
            entityTransaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception message dans update eleve: " + ex.getMessage());
        }
    }

    // Delete eleve by id
    public void deleteById(String cne) {
        try {
            Eleve eleve = this.getById(cne);

            entityTransaction.begin();
            entityManager.remove(eleve);
            entityTransaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception message dans delete eleve: " + ex.getMessage());
        }
    }

    // get total number of eleves
    public int getTotalNumberEleves() {
        Query query = entityManager.createNativeQuery("select count(*) from eleves");
        return Integer.valueOf(query.getSingleResult().toString());
    }

    // get all eleves of a filiere
    public List<Eleve> getElevesOfFiliere(int pageIndex, Filiere filiere) {
        List<Eleve> eleves = new ArrayList<>();

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Eleve> cq = cb.createQuery(Eleve.class);
            Root<Eleve> root = cq.from(Eleve.class);

            cq.select(root);
            cq.where(cb.equal(root.get("ref_fil"), filiere));

            return entityManager.createQuery(cq).getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception message dans get eleves of filieres: " + ex.getMessage());
        }

        return eleves;
    }
}
