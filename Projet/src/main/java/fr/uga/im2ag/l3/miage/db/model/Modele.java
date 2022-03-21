package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Modele {
    private Marque marque ;
    private double cout ;

    @Id
    @GeneratedValue
    private Long id;

    public Modele() {

    }

    public Marque getMarque() {
        return marque;
    }

    public Modele(Marque marque, double cout) {
        this.marque = marque;
        this.cout = cout;
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

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
