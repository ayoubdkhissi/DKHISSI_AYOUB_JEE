/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uae.ensat.repository;

import java.util.List;
import uae.ensat.models.Filiere;

/**
 *
 * @author Ayoub Dkhissi
 */
public interface IFiliereRepository {

    public List<Filiere> getAll();
    public List<Filiere> getWithPagination(int pageIndex);
    public Filiere getById(String code_fil);
    public void add(Filiere filiere);
    public void update(Filiere filiere);
    public void deleteById(String code_fil);
    public int getTotalCountOfFiliere();
    public int getElevesCount(String code_fil);
    public int getCountElevesSansFiliere();
    
}
