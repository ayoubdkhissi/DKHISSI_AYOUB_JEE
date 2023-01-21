/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uae.ensat.services;

import java.util.List;
import uae.ensat.models.Eleve;
import uae.ensat.models.Filiere;

/**
 *
 * @author Ayoub Dkhissi
 */
public interface IEleveService {
    public List<Eleve> getAllEleve();
    public List<Eleve> getWithPagination(int pageIndex);
    public Eleve getEleveById(String cne) ;
    public void addEleve(Eleve eleve) ;
    public void updataEleve(Eleve eleve) ;
    public void deleteEleveById(String cne) ;
    public int getTotalNumberEleves() ;
    public List<Eleve> getElevesOfFiliere(int pageIndex, Filiere filiere);
    
}
