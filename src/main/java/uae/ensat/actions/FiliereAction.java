package uae.ensat.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import uae.ensat.models.Filiere;
import uae.ensat.services.FiliereService;

/**
 *
 * @author Ayoub Dkhissi
 */
public class FiliereAction extends ActionSupport {

    private FiliereService filiereService;

    // Liste de filieres affiché
    private List<Filiere> filieres;

    // Object filiere utiliser pour l'ajout et la mise à jour
    private Filiere filiere;

    // code utilisé pour delete et mise à jour
    private String code_fil;

    // Message d'error
    private String error_message;
    
    // Message de success
    private String success_message;
    
    // Methode pour lister les filieres (returns the filieres.jsp view)
    public String Lister() throws Exception {
        this.setFilieres(filiereService.getAllFilieres());
        return SUCCESS;
    }

    // Methode pour afficher la vue pour ajouter filiere
    public String add_view() throws Exception {
        return SUCCESS;
    }

    // Methode pour afficher la vue pour update filiere
    public String update_view() throws Exception {
        // get code_fil from query parameters
        String code_fil = ActionContext.getContext().getParameters().get("code_fil").getValue();

        // get filiere from database
        Filiere filiere = this.getFiliereService().getFiliereById(code_fil);

        // set the filiere
        this.setFiliere(filiere);

        return SUCCESS;
    }

    // Method pour ajouter une filiere
    public String add_filiere() throws Exception {
        // check if filiere already exists
        Filiere new_filiere = filiereService.getFiliereById(filiere.getCode_fil());
        if (new_filiere != null) {
            // filiere already exists : return the add page with error message
            error_message = "La filiere " + filiere.getCode_fil() + " Existe déja";
            return ERROR;
        }

        // filiere does not exist add it and return list page
        this.filiereService.addFiliere(filiere);
        
        return SUCCESS;
    }
    
    
    // Method pour update une filiere
    public String update_filiere() throws Exception
    {
        filiereService.updataFiliere(filiere);
        return SUCCESS;
    }
    
    // Method pour supprimer une filiere
    public String delete_filiere() throws Exception
    {
        filiereService.deleteFiliereById(code_fil);
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

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public String getCode_fil() {
        return code_fil;
    }

    public void setCode_fil(String code_fil) {
        this.code_fil = code_fil;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getSuccess_message() {
        return success_message;
    }

    public void setSuccess_message(String success_message) {
        this.success_message = success_message;
    }
    
    

    
    
}
