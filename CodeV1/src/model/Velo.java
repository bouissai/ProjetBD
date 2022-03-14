package fr.uga.im2ag.l3.miage.db.model;


import java.util.Date;
import java.util.List;

public class Velo {

    public Velo(int numeroVelo, JAVA.Marque modele, Date dateMisesEnService, JAVA.Etat etat, double prix) {
        this.numeroVelo = numeroVelo;
        this.modele = modele;
        this.dateMisesEnService = dateMisesEnService;
        this.etat = etat;
        
    }

    private int numeroVelo ;
    private JAVA.Marque modele ;
    private Date dateMisesEnService ;
    private JAVA.Etat etat ;


    private List<Location> Velos ;
    public int getNumeroVelo() {
        return numeroVelo;
    }

    public void setNumeroVelo(int numeroVelo) {
        this.numeroVelo = numeroVelo;
    }

    public JAVA.Marque getModele() {
        return modele;
    }

    public void setModele(JAVA.Marque modele) {
        this.modele = modele;
    }

    public Date getDateMisesEnService() {
        return dateMisesEnService;
    }

    public void setDateMisesEnService(Date dateMisesEnService) {
        this.dateMisesEnService = dateMisesEnService;
    }

    public JAVA.Etat getEtat() {
        return etat;
    }

    public void setEtat(JAVA.Etat etat) {
        this.etat = etat;
    }



}
