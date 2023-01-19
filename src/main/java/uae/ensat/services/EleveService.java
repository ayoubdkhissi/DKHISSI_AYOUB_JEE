/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uae.ensat.services;

import java.util.List;
import uae.ensat.models.Eleve;
import uae.ensat.models.Filiere;
import uae.ensat.repository.EleveRepository;
import uae.ensat.repository.IEleveRepository;

/**
 *
 * @author Ayoub Dkhissi
 */
public class EleveService implements IEleveService{

    private IEleveRepository eleveRepository;

    @Override
    public List<Eleve> getAllEleve() {
        return eleveRepository.getAll();
    }

    @Override
    public List<Eleve> getWithPagination(int pageIndex) {
        return eleveRepository.getWithPagination(pageIndex);
    }

    @Override
    public Eleve getEleveById(String cne) {
        return eleveRepository.getById(cne);
    }

    @Override
    public void addEleve(Eleve eleve) {
        eleveRepository.add(eleve);
    }

    @Override
    public void updataEleve(Eleve eleve) {
        eleveRepository.update(eleve);
    }

    @Override
    public void deleteEleveById(String cne) {
        eleveRepository.deleteById(cne);
    }

    @Override
    public int getTotalNumberEleves() {
        return eleveRepository.getTotalNumberEleves();
    }
    
    @Override
    public List<Eleve> getElevesOfFiliere(int pageIndex, Filiere filiere)
    {
        return eleveRepository.getElevesOfFiliere(pageIndex, filiere);
    }

    public IEleveRepository getEleveRepository() {
        return eleveRepository;
    }

    public void setEleveRepository(IEleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
    }
}
