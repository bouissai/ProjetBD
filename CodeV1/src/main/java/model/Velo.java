package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
@Entity
public class Velo {

    public Velo(){

    }
    public Velo(int numeroVelo, Marque modele, Date dateMisesEnService, Etat etat, double prix) {
        this.numeroVelo = numeroVelo;
        this.modele = modele;
        this.dateMisesEnService = dateMisesEnService;
        this.etat = etat;
        
    }
    @Id
    private int numeroVelo ;
    private Marque modele ;
    private Date dateMisesEnService ;
    private Etat etat ;


    //private List<Location> Velos ;
    public int getNumeroVelo() {
        return numeroVelo;
    }

    public void setNumeroVelo(int numeroVelo) {
        this.numeroVelo = numeroVelo;
    }

    public Marque getModele() {
        return modele;
    }

    public void setModele(Marque modele) {
        this.modele = modele;
    }

    public Date getDateMisesEnService() {
        return dateMisesEnService;
    }

    public void setDateMisesEnService(Date dateMisesEnService) {
        this.dateMisesEnService = dateMisesEnService;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }



}
