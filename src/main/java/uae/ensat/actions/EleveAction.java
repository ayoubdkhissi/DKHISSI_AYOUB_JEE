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
import uae.ensat.services.IEleveService;
import uae.ensat.services.IFiliereService;

/**
 *
 * @author Ayoub Dkhissi
 */
public class EleveAction extends ActionSupport {

    // service injecté depuis fichier de configuration
    private IEleveService eleveService;
    private IFiliereService filiereService;

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

    // pagination
    private int pageIndex = 1;
    private int nbrTotalEleves;

    // Methode pour lister les eleves (returns the eleves.jsp view)
    public String Lister() throws Exception {
        
        // get total number of students
        this.setNbrTotalEleves(eleveService.getTotalNumberEleves());
        
        // remplire la liste des eleves
        this.setEleves(eleveService.getWithPagination(pageIndex-1));
        
        
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
            error_message = "L'eleve " + eleve.getCne() + " Existe déja";

            // charger la liste des filieres
            this.setFilieres(filiereService.getAllFilieres());

            return ERROR;
        }

        if (eleve.getRef_fil().getCode_fil().isBlank()) {
            eleve.setRef_fil(null);
        }
        // eleve does not exist add it 
        this.eleveService.addEleve(eleve);

        return SUCCESS;
    }

    // Method pour update un eleve
    public String update_eleve() throws Exception {
        if(eleve.getRef_fil().getCode_fil().isBlank())
            eleve.setRef_fil(null);
        eleveService.updataEleve(eleve);
        return SUCCESS;
    }

    // Method pour supprimer un eleve
    public String delete_eleve() throws Exception {
        eleveService.deleteEleveById(cne);
        return SUCCESS;
    }

    public IEleveService getEleveService() {
        return eleveService;
    }

    public void setEleveService(IEleveService eleveService) {
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

    public IFiliereService getFiliereService() {
        return filiereService;
    }

    public void setFiliereService(IFiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getNbrTotalEleves() {
        return nbrTotalEleves;
    }

    public void setNbrTotalEleves(int nbrTotalEleves) {
        this.nbrTotalEleves = nbrTotalEleves;
    }

}
