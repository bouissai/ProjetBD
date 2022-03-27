package com.example.projetspring;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("Non")
@NamedQueries(
        @NamedQuery( name = "get-all-nonAbonne" , query="SELECT n from NonAbonne n"
        )
)
public class NonAbonne extends Client{}
