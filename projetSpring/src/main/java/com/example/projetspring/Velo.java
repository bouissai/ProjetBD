package com.example.projetspring;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries(
        @NamedQuery( name = "get-all-velos" , query="SELECT s from Velo s"
        )
)

public class Velo {

        @Id
        @GeneratedValue
        private Long numeroVelo ;

        @ManyToOne
        private  Location location ;

        private Marque modele ;
        private Date dateMisesEnService ;
        private Etat etat ;



    // private List<Location> Velos ;


        public Marque getModele() {
            return modele;
        }

        public void setModele(Marque modele) {
            this.modele = modele;
        }

        public Date getDateMisesEnService() {
            return dateMisesEnService;
        }

        public void setDateMisesEnService(Date dateMisesEnService) {
            this.dateMisesEnService = dateMisesEnService;
        }

        public Etat getEtat() {
            return etat;
        }

        public void setEtat(Etat etat) {
            this.etat = etat;
        }

        public Long getNumeroVelo() {
            return numeroVelo;
    }

        public void setLocation(Location location) {
            this.location = location;
        }

    @Override
    public String toString() {
        return "Velo{" +
                "numeroVelo=" + numeroVelo + "\n" +
                ", location=" + location + "\n" +
                ", modele=" + modele + "\n" +
                ", dateMisesEnService=" + dateMisesEnService + "\n" +
                ", etat=" + etat + "\n" +
                '}';
    }
}

