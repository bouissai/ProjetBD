package com.example.projetspring;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;
@Entity(name="Abonne")
@DiscriminatorValue("Oui")
public class Abonne extends Client{

    private String nom ;
    private String prenom ;
    private LocalDate dateNaissance ;
    private Sexe sexe ;
    private String adresse ;
    private Date dateAbonnement ;



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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
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

