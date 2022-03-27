package com.example.projetspring;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries(
        @NamedQuery( name = "get-all-stations" , query="SELECT s from Station s"
)
)
public class Station {
    @Id
    @GeneratedValue
    private Long id ;

    private String adresse ;

    private Statut status;

    @OneToMany
    private List<Bornette> Contient = new ArrayList<Bornette>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public String getStatut() {
        return adresse;
    }*/

    public String getAdresse() {
        //Retourne ""
        if(adresse==null){
            return " ";
        }
        return adresse;
    }

    public Statut getStatus() {
        return status;
    }

    public List<Bornette> getContient() {
        return Contient;
    }

    public void setContient(List<Bornette> contient) {
        Contient = contient;
    }

    public void setStatus(Statut status) {
        this.status = status;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        String contient = "";
        for(Bornette b : this.Contient){
            contient = contient + b.toString();
        }
        return "Station " +
                "id=" + id +
                ", a l'adresse='" + adresse + '\'' +
                ", status=" + status +
                ", Contient les bornettes : " + contient +
                '}';
    }
}
