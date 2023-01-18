package uae.ensat.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import uae.ensat.models.Filiere;
import uae.ensat.repository.FiliereRepository;

/**
 *
 * @author Ayoub Dkhissi
 */
public class FiliereService {
    
    private FiliereRepository filiereRepository;
    
    
    public List<Filiere> getAllFilieres() 
    {
        return filiereRepository.getAll();
    }
    
    public List<Filiere> getWithPagination(int pageIndex)
    {
        return filiereRepository.getWithPagination(pageIndex);
    }
    
    public Filiere getFiliereById(String code_fil)
    {
        return filiereRepository.getById(code_fil);
    }
    
    public void addFiliere(Filiere filiere)
    {
        filiereRepository.add(filiere);
    }
    
    public void updataFiliere(Filiere filiere)
    {
        filiereRepository.update(filiere);
    }
    
    public void deleteFiliereById(String code_fil)
    {
        filiereRepository.deleteById(code_fil);
    }
    
    public int getTotalCountOfFiliere()
    {
        return this.filiereRepository.getTotalCountOfFiliere();
    }
    

    public void setFiliereRepository(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    public FiliereRepository getFiliereRepository() {
        return filiereRepository;
    }
    
    
    
    
    
    
}
