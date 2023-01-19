package uae.ensat.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
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
public class FiliereAction extends ActionSupport {

    // service injecté depuis fichier de configuration
    private IFiliereService filiereService;
    private IEleveService eleveService;

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

    // pagination
    private int pageIndex = 1;
    private int nbrTotalFilieres;
    private int nbrTotalEleves;

    // Hashmap contient le count d'etudiants dans chaque filiere
    private HashMap<String, Integer> count;

    // Nbr d'étudiants qui ont pas de filiere
    private int nbrNonDetermine = 0;

    // liste des eleves utilisé pour afficher la liste des eleves d'une filiere
    private List<Eleve> eleves;

    // Methode pour lister les filieres (returns the filieres.jsp view)
    public String Lister() throws Exception {

        // get the total number of filieres
        this.setNbrTotalFilieres(filiereService.getTotalCountOfFiliere());

        // get le nombre d'etudians sans filiere
        this.setNbrNonDetermine(filiereService.getCountElevesSansFiliere());

        // remplire la liste de filieres
        this.setFilieres(filiereService.getWithPagination(pageIndex - 1));

        // get the count of eleves dans chauqe filiere
        count = new HashMap();
        for (Filiere filiere : filieres) {
            count.put(filiere.getCode_fil(), filiereService.getElevesCount(filiere.getCode_fil()));
        }

        return SUCCESS;
    }

    // Methode pour lister la list des eleves d'une filiere
    public String Lister_eleves_filiere() throws Exception {
        if (code_fil != null && !code_fil.isBlank()) {
            nbrTotalEleves = filiereService.getElevesCount(code_fil);
            filiere = filiereService.getFiliereById(code_fil);
            eleves = eleveService.getElevesOfFiliere(pageIndex-1, filiere);
            return SUCCESS;
        }

        if (code_fil == "nonDeterm") {
            nbrTotalEleves = filiereService.getElevesCount(code_fil);
            eleves = eleveService.getElevesOfFiliere(pageIndex-1, null);
            return SUCCESS;
        }

        return ERROR;
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
    public String update_filiere() throws Exception {
        filiereService.updataFiliere(filiere);
        return SUCCESS;
    }

    // Method pour supprimer une filiere
    public String delete_filiere() throws Exception {
        
        // we need to set ref_fil to null in all eleves that are in this filiere
        filiere = filiereService.getFiliereById(code_fil);
        
        eleves = eleveService.getElevesOfFiliere(-1, filiere);
        
        for(Eleve eleve : eleves)
        {
            eleve.setRef_fil(null);
            eleveService.updataEleve(eleve);
        }
        
        filiereService.deleteFiliereById(code_fil);
        return SUCCESS;
    }

    public void setFiliereService(IFiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public IFiliereService getFiliereService() {
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

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getNbrTotalFilieres() {
        return nbrTotalFilieres;
    }

    public void setNbrTotalFilieres(int nbrTotalFilieres) {
        this.nbrTotalFilieres = nbrTotalFilieres;
    }

    public HashMap<String, Integer> getCount() {
        return count;
    }

    public void setCount(HashMap<String, Integer> count) {
        this.count = count;
    }

    public int getNbrNonDetermine() {
        return nbrNonDetermine;
    }

    public void setNbrNonDetermine(int nbrNonDetermine) {
        this.nbrNonDetermine = nbrNonDetermine;
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

    public int getNbrTotalEleves() {
        return nbrTotalEleves;
    }

    public void setNbrTotalEleves(int nbrTotalEleves) {
        this.nbrTotalEleves = nbrTotalEleves;
    }

}
