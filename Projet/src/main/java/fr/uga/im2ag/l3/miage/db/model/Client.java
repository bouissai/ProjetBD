package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Client {

    @Id
    @GeneratedValue
    private Long id ;
    private int numeroCB;
    private int codeSecret;

    public Client(int numeroCB, int codeSecret) {
        this.numeroCB = numeroCB;
        this.codeSecret = codeSecret;
    }

    public Client() {

    }

    public Long getId() {
        return id;
    }



    public void setNumeroCB(int numeroCB) {
        this.numeroCB = numeroCB;
    }

    public void setCodeSecret(int codeSecret) {
        this.codeSecret = codeSecret;
    }

    public int getCodeSecret() {
        return codeSecret;
    }

    public int getNumeroCB() {
        return numeroCB;
    }
}
