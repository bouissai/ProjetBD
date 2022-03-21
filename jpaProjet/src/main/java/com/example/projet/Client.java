package com.example.projet;

import javax.persistence.*;
import java.util.List;
@Entity
public abstract class Client {
    @Id
    @GeneratedValue

    private int numeroCB;
    private int codeSecret;
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

