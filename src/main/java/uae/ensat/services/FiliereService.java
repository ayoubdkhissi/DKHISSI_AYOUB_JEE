package uae.ensat.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import uae.ensat.models.Filiere;
import uae.ensat.repository.FiliereRepository;
import uae.ensat.repository.IFiliereRepository;

/**
 *
 * @author Ayoub Dkhissi
 */
public class FiliereService implements IFiliereService{
    
    private IFiliereRepository filiereRepository;
    
    
    @Override
    public List<Filiere> getAllFilieres() 
    {
        return filiereRepository.getAll();
    }
    
    @Override
    public List<Filiere> getWithPagination(int pageIndex)
    {
        return filiereRepository.getWithPagination(pageIndex);
    }
    
    @Override
    public Filiere getFiliereById(String code_fil)
    {
        return filiereRepository.getById(code_fil);
    }
    
    @Override
    public void addFiliere(Filiere filiere)
    {
        filiereRepository.add(filiere);
    }
    
    @Override
    public void updataFiliere(Filiere filiere)
    {
        filiereRepository.update(filiere);
    }
    
    @Override
    public void deleteFiliereById(String code_fil)
    {
        filiereRepository.deleteById(code_fil);
    }
    
    @Override
    public int getTotalCountOfFiliere()
    {
        return this.filiereRepository.getTotalCountOfFiliere();
    }
    
    @Override
    public int getElevesCount(String code_fil)
    {
       return this.filiereRepository.getElevesCount(code_fil);
    }
    
    @Override
    public int getCountElevesSansFiliere()
    {
        return this.filiereRepository.getCountElevesSansFiliere();
    }
    

    public void setFiliereRepository(IFiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    public IFiliereRepository getFiliereRepository() {
        return filiereRepository;
    }
    
    
    
    
    
    
}
