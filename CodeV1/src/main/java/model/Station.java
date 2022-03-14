package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
@Entity
public class Station {
    @Id
    private Long id ;

    private String adresse ;

    private Statut status;

    private List<Bornette> Contient ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatut() {
        return adresse;
    }

    public void setStatus(Statut status) {
        this.status = status;
    }

    public void setStatut(String adresse) {
        this.adresse = adresse;
    }
}
