package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;;

@Entity
public class Bornette {

    @Id
    private int numeroBorn;
    private Etat etat;
    @OneToOne
    private velo Propose ;
    private boolean estPresent;

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

    public velo getPropose() {
        return Propose;
    }

    public void setPropose(velo propose) {
        Propose = propose;
    }
}
