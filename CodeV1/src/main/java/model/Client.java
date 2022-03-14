package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue

    private int numeroCB;
    private int codeSecret;

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
