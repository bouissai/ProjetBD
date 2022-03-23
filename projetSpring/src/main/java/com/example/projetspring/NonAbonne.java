package com.example.projetspring;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("nonAbonne")
public class NonAbonne extends Client{

    public NonAbonne(){

    }

    public NonAbonne(int numeroCB,int codeSecret) {
        super(numeroCB, codeSecret);
    }


}
