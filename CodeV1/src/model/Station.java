package fr.uga.im2ag.l3.miage.db.model;


import javax.annotation.processing.Generated;
import java.util.List;

public class Station {

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
