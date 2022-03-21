package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.Entity;

@Entity

public class NonAbonne extends Client{

    public NonAbonne(int numeroCB,int codeSecret) {
        super(numeroCB, codeSecret);
    }


    public NonAbonne() {

    }
}
