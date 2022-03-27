package com.example.projetspring;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Modele {
    @Id
    private Marque marque ;
    private double cout ;

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }
}
