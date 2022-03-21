package com.example.projet;

import javax.persistence.*;


public class Bornette {

    @Id
    private int numeroBorn;

    private Etat etat;

    @OneToOne
    private Velo proposeDeLouer ;

    public int getNumeroBorn() {
        return numeroBorn;
    }

    public void setNumeroBorn(int numeroBorn) {
        this.numeroBorn = numeroBorn;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Velo getPropose() {
        return this.proposeDeLouer;
    }

    public void setPropose(Velo velo) {
        this.proposeDeLouer = velo;
    }
}

