package com.example.projet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="NonAbonne")
public class NonAbonne extends Client{

    public NonAbonne(){

    }
    public NonAbonne(int numeroCB,int codeSecret) {
        super(numeroCB, codeSecret);
    }


}
