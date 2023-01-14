package uae.ensat.models;

import java.util.Collection;
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
    
    @OneToMany(mappedBy = "ref_fil", fetch = FetchType.LAZY)
    public Collection<Eleve> eleves;
    
}
