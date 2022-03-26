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
        private int prix;



    // private List<Location> Velos ;


        public Marque getModele() {
            return modele;
        }

        public void setModele(Marque modele) {
            this.modele = modele;
            switch (this.modele) {
                case VTT: this.prix = 20; break;
                case BTWIB: this.prix = 10; break;
                case LOOK: this.prix = 6; break;
                case PEUGEOT: this.prix = 5; break;
                default: this.prix = 50; break;
            }
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

    public double getPrix() {
        return this.prix;
    }


}

