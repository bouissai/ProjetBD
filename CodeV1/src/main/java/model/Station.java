package model;


import javax.persistence.*;
import java.util.List;
@Entity
public class Station {
    @Id
    private Long id ;

    private String adresse ;

    private Statut status;

    @OneToMany
    private List<Bornette> contient ;

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
