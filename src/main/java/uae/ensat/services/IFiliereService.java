/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uae.ensat.services;

import java.util.List;
import uae.ensat.models.Filiere;

/**
 *
 * @author Ayoub Dkhissi
 */
public interface IFiliereService {
    public List<Filiere> getAllFilieres();
    public List<Filiere> getWithPagination(int pageIndex);
    public Filiere getFiliereById(String code_fil);
    public void addFiliere(Filiere filiere);
    public void updataFiliere(Filiere filiere);
    public void deleteFiliereById(String code_fil);
    public int getTotalCountOfFiliere();
    public int getElevesCount(String code_fil);
    public int getCountElevesSansFiliere();
    

}
