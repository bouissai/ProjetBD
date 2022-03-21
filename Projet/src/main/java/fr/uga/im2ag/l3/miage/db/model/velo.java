package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@NamedQueries(
        @NamedQuery( name = "get-all-velos" , query="SELECT s from velo s"
        )
)

public class velo {


        public velo( Marque modele, Date dateMisesEnService, Etat etat, double prix) {

            this.modele = modele;
            this.dateMisesEnService = dateMisesEnService;
            this.etat = etat;

        }
        @Id
        @GeneratedValue
        private Long numeroVelo ;

        @ManyToOne(fetch = FetchType.EAGER)
        private  Location location ;

        private Marque modele ;
        private Date dateMisesEnService ;
        private Etat etat ;



    public velo() {

    }


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



    }

