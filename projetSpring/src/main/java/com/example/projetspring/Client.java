package com.example.projetspring;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Entity(name = "Client")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name ="Abonnement", discriminatorType = DiscriminatorType.STRING)
public abstract class Client {


    @Id
    @GeneratedValue
    private long codeSecret;
    @Column(nullable = false)
    private int numeroCB;
    @OneToMany
    private List<Location> loue = new ArrayList<Location>();

    public void setLoue(Location location){
        this.loue.add(location);
    }
    public long getCodeSecret() {
        return codeSecret;
    }

    public int getNumeroCB() {
        return numeroCB;
    }

    public void setNumeroCB(int numeroCB){
        this.numeroCB = numeroCB;
    }
}

