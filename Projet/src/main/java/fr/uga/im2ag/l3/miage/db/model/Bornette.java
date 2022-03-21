package fr.uga.im2ag.l3.miage.db.model;

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
    private velo Propose ;
    private boolean estPresent;

    public Bornette( Etat etat, velo propose, boolean estPresent) {
        this.numeroBorn = numeroBorn;
        this.etat = etat;
        Propose = propose;
        this.estPresent = estPresent;
    }

    public Bornette() {

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

    public boolean isEstPresent() {
        return estPresent;
    }

    public void setEstPresent(boolean estPresent) {
        this.estPresent = estPresent;
    }
}
