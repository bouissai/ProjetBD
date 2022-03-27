package com.example.projetspring;

import javax.persistence.*;
;

@Entity(name = "Bornette")
@NamedQueries(
        @NamedQuery( name = "get-all-bornettes" , query="SELECT s from Bornette s"
        )
)
public class Bornette {

    @Id
    @GeneratedValue
    private long numeroBorn;
    @Column
    private Etat etat;
    @OneToOne
    private Velo Propose;
    @Column
    private boolean estPresent;

    public Bornette(){
        setEtat(Etat.OK);
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

    public void setPropose(Velo velo) {
        if(velo == null){
            this.Propose = null;
            setEstPresent(false);
        }else{
            this.Propose = velo;
            setEstPresent(true);
        }
    }

    public boolean estPresent() {
        return estPresent;
    }

    public void setEstPresent(boolean estPresent) {
        this.estPresent = estPresent;
    }

    public long getNumeroBorn() {
        return numeroBorn;
    }

    @Override
    public String toString() {
        return "Bornette " +
                "numeroBorn=" + numeroBorn +
                ", etat=" + etat +
                ", Propose=" + Propose.toString() +
                ", estPresent=" + estPresent +
                '}';
    }
}
