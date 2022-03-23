package com.example.projetspring;

import javax.persistence.*;
;

@Entity
@NamedQueries(
        @NamedQuery( name = "get-all-bornettes" , query="SELECT s from Bornette s"
        )
)

public class Bornette {

    @Id
    @GeneratedValue
    private Long numeroBorn;
    private Etat etat;
    @OneToOne
    private Velo Propose ;
    private boolean estPresent;

    public Bornette( Etat etat, Velo propose, boolean estPresent) {
        this.numeroBorn = numeroBorn;
        this.etat = etat;
        this.Propose = propose;
        this.estPresent = estPresent;
    }

    public Bornette() {

    }


    public Long getNumeroBorn() {return numeroBorn;}

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

    public boolean isEstPresent() {
        return estPresent;
    }

    public void setEstPresent(boolean estPresent) {
        this.estPresent = estPresent;
    }
}
