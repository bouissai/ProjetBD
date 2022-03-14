package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Bornette {

    @Id
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
