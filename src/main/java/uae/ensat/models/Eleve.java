package uae.ensat.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 *
 * @author Ayoub Dkhissi
 */
@Entity
@Table(name = "eleves", indexes = @Index(name = "ref_fil_idx", columnList = "ref_fil"))
public class Eleve {

    @Id
    @Size(max = 20)
    private String cne;

    @Size(max = 45)
    private String nom;
    
    @Size(max = 45)
    private String prenom;

    @Null
    private Double moyenne;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ref_fil", nullable = true)
    private Filiere ref_fil;

    
    public Eleve() {}

    public Eleve(String cne) {
        this.cne = cne;
    }

    public Eleve(String cne, String nom, String prenom, Double moyenne, Filiere ref_fil) {
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
        this.ref_fil = ref_fil;
    }

    public String getCne() {
        return cne;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public Filiere getRef_fil() {
        return ref_fil;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    public void setRef_fil(Filiere ref_fil) {
        this.ref_fil = ref_fil;
    }
    
    
    
}
