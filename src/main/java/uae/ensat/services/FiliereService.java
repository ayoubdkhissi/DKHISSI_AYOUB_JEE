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
    
    
    public List<Filiere> getAll() 
    {
        return filiereRepository.getAll();
    }

    public void setFiliereRepository(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    public FiliereRepository getFiliereRepository() {
        return filiereRepository;
    }
    
    
    
    
    
    
}
