package com.example.projetspring;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Abonnement", discriminatorType = DiscriminatorType.STRING)
public abstract class Client {
    @Id
    @GeneratedValue
    private long codeSecret;
    @Column(nullable = false)
    private int numeroCB;
    @OneToMany
    private List<Location> loue = new ArrayList<Location>();
    private boolean locationEnCours = false ;
    public List<Location> getLoue() {
        return loue;
    }

    public void addLoue(List<Location> loue) {
        this.loue = loue;
    }

    public void addLoue(Location location) {
        this.loue.add(location);
    }

    public long getCodeSecret() {
        return codeSecret;
    }

    public int getNumeroCB() {
        return numeroCB;
    }

    public void setNumeroCB(int numeroCB) {
        this.numeroCB = numeroCB;
    }
}

