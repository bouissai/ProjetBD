package fr.uga.im2ag.l3.miage.db.model;

public class Client {
    private int numeroCB;
    private int codeSecret;

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
