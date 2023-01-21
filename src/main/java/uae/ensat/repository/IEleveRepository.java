/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uae.ensat.repository;

import java.util.List;
import uae.ensat.models.Eleve;
import uae.ensat.models.Filiere;

/**
 *
 * @author Ayoub Dkhissi
 */
public interface IEleveRepository {
    public List<Eleve> getAll();
    public List<Eleve> getWithPagination(int pageIndex);
    public Eleve getById(String cne);
    public void add(Eleve eleve);
    public void update(Eleve eleve);
    public void deleteById(String cne);
    public int getTotalNumberEleves();
    public List<Eleve> getElevesOfFiliere(int pageIndex, Filiere filiere);
}
