package com.example.projetspring;

import javax.persistence.*;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name ="Abonnement", discriminatorType = DiscriminatorType.STRING)
public abstract class Client {


    @Id
    @GeneratedValue
    private int codeSecret;
    @Column(nullable = false)
    private int numeroCB;
    @OneToMany
    private List<Location> loue;

    public Client(){

    }
    public Client(int numeroCB, int codeSecret) {
        this.numeroCB = numeroCB;
        this.codeSecret = codeSecret;
    }

    public int getCodeSecret() {
        return codeSecret;
    }

    public int getNumeroCB() {
        return numeroCB;
    }
}

