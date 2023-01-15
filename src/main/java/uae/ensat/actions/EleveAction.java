package uae.ensat.actions;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import uae.ensat.models.Eleve;
import uae.ensat.models.Filiere;
import uae.ensat.services.EleveService;
import uae.ensat.services.FiliereService;

/**
 *
 * @author Ayoub Dkhissi
 */
public class EleveAction extends ActionSupport {
    
    // service injecté depuis fichier de configuration
    private EleveService eleveService;
    private FiliereService filiereService;
    
    // List des eleves affiché
    private List<Eleve> eleves;
    
    // List des filieres utilisé lors de l'ajout et la mise à jour d'eleve
    private List<Filiere> filieres;
    
    // Object Eleve utilisé pour l'ajout et mise à jour
    private Eleve eleve;
    
    // code utilisé pour delete et mise à jour
    private String cne;
    
    // Message d'erreur
    private String error_message;
    
    // Message de success
    private String success_message;
    
     // Methode pour lister les eleves (returns the eleves.jsp view)
    public String Lister() throws Exception {
        this.setEleves(eleveService.getAllEleve());
        return SUCCESS;
    }

    // Methode pour afficher la vue pour ajouter eleve
    public String add_view() throws Exception {
        
        // we need the list of all filieres in the add eleve view
        this.setFilieres(filiereService.getAllFilieres());
        
        return SUCCESS;
    }

    // Methode pour afficher la vue pour update eleve
    public String update_view() throws Exception {
        // get cne from query parameters
        String cne = ActionContext.getContext().getParameters().get("cne").getValue();

        // get eleve from database
        Eleve eleve = eleveService.getEleveById(cne);

        // set the eleve to be updated
        this.setEleve(eleve);

        // set list of filieres
        this.setFilieres(filiereService.getAllFilieres());
        
        return SUCCESS;
    }

    // Method pour ajouter un eleve
    public String add_eleve() throws Exception {
        // check if eleve already exists
        Eleve new_eleve = eleveService.getEleveById(eleve.getCne());
        
        if (new_eleve != null) {
            // eleve already exists : return the add page with error message
            error_message = "L'eleve " + eleve.getCne()+ " Existe déja";
            
            // charger la liste des filieres
            this.setFilieres(filiereService.getAllFilieres());

            return ERROR;
        }

        // eleve does not exist add it 
        this.eleveService.addEleve(eleve);
        
        return SUCCESS;
    }
    
    
    // Method pour update un eleve
    public String update_eleve() throws Exception
    {
        eleveService.updataEleve(eleve);
        return SUCCESS;
    }
    
    // Method pour supprimer un eleve
    public String delete_eleve() throws Exception
    {
        eleveService.deleteEleveById(cne);
        return SUCCESS;
    }

    public EleveService getEleveService() {
        return eleveService;
    }

    public void setEleveService(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
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

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public FiliereService getFiliereService() {
        return filiereService;
    }

    public void setFiliereService(FiliereService filiereService) {
        this.filiereService = filiereService;
    }
    
    
    
    
}
