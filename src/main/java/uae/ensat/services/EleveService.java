/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uae.ensat.services;

import java.util.List;
import uae.ensat.models.Eleve;
import uae.ensat.models.Filiere;
import uae.ensat.repository.EleveRepository;

/**
 *
 * @author Ayoub Dkhissi
 */
public class EleveService {

    private EleveRepository eleveRepository;

    public List<Eleve> getAllEleve() {
        return eleveRepository.getAll();
    }

    public List<Eleve> getWithPagination(int pageIndex) {
        return eleveRepository.getWithPagination(pageIndex);
    }

    public Eleve getEleveById(String cne) {
        return eleveRepository.getById(cne);
    }

    public void addEleve(Eleve eleve) {
        eleveRepository.add(eleve);
    }

    public void updataEleve(Eleve eleve) {
        eleveRepository.update(eleve);
    }

    public void deleteEleveById(String cne) {
        eleveRepository.deleteById(cne);
    }

    public int getTotalNumberEleves() {
        return eleveRepository.getTotalNumberEleves();
    }

    public EleveRepository getEleveRepository() {
        return eleveRepository;
    }

    public void setEleveRepository(EleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
    }
}
