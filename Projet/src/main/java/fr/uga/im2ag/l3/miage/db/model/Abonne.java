package fr.uga.im2ag.l3.miage.db.model;

import java.util.Date;
import java.util.List;

public class Abonne extends Client{

    private String nom ;
    private String prenom ;
    private Date dateNaissance ;
    private Sexe sexe ;
    private String adresse ;
    private Date dateAbonnement ;

    private List<Location> locations;

    public Abonne(int numeroCB, int codeSecret, String nom, String prenom, Date dateNaissance, Sexe sexe, String adresse, Date dateAbonnement) {
        super(numeroCB, codeSecret);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.dateAbonnement = dateAbonnement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateAbonnement() {
        return dateAbonnement;
    }

    public void setDateAbonnement(Date dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }
}
