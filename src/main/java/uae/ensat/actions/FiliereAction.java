package uae.ensat.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import uae.ensat.models.Filiere;
import uae.ensat.services.FiliereService;

/**
 *
 * @author Ayoub Dkhissi
 */
public class FiliereAction extends ActionSupport{
    
    private FiliereService filiereService;
    
    private List<Filiere> filieres;
    
    public String Lister() throws Exception
    {
        this.setFilieres(filiereService.getAllFilieres());
        return SUCCESS;
    }

    public void setFiliereService(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public FiliereService getFiliereService() {
        return filiereService;
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }
}
