package uae.ensat.models;

import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Ayoub Dkhissi
 */
@Entity
@Table(name = "filieres")
public class Filiere {
    
    @Id
    @Size(max = 20)
    private String code_fil;
    
    @Size(max = 45)
    private String nom_fil;
    
    @OneToMany(mappedBy = "ref_fil", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    public List<Eleve> eleves;

    public Filiere() {}
    
    public Filiere(String code_fil) {
        this.code_fil = code_fil;
    }

    public Filiere(String code_fil, String nom_fil) {
        this.code_fil = code_fil;
        this.nom_fil = nom_fil;
    }

    public String getCode_fil() {
        return code_fil;
    }

    public String getNom_fil() {
        return nom_fil;
    }

    public Collection<Eleve> getEleves() {
        return eleves;
    }

    public void setCode_fil(String code_fil) {
        this.code_fil = code_fil;
    }

    public void setNom_fil(String nom_fil) {
        this.nom_fil = nom_fil;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
    
    
    
    
    
}
