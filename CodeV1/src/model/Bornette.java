package fr.uga.im2ag.l3.miage.db.model;
import  ENUMERATION.*;
public class Bornette {


    private int numeroBorn;
    private Etat etat;

    private Velo Propose ;

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
        return Propose;
    }

    public void setPropose(Velo propose) {
        Propose = propose;
    }
}
