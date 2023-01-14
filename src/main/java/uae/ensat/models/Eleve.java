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
    
    

}
