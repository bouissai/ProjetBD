package com.example.projetspring;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Location")
@NamedQueries(
        @NamedQuery( name = "get-all-locations" , query="SELECT s from Location s"
        )
)
public class Location {
    @Id
    @GeneratedValue
    private Long id ;
    @Column(nullable = false)
    private Date dateLocation ;
    @Column
    private Date dateRendu ;


    @OneToMany(mappedBy = "location")
    private List<Velo> Velos ;

    private double prixLoc;
    private boolean prime=false;
    private Long numeroClient;
    public Long getId() {
        return id;
    }

    public Date getDateLocation() {
        return dateLocation;
    }

    public Date getDateRendu() {
        return dateRendu;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setDateLocation(Date date){
        this.dateLocation = date;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    /*
    public void setDateRendu(Date dateRendu) {
        this.dateRendu = dateRendu;
    }*/

    public Long getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(Long numeroClient) {
        this.numeroClient = numeroClient;
    }

    public void setDateRendu(Date dateRendu) {
        double prixLocation = 0;
        double heureLocation = Math. floor(( dateRendu.getTime() - this.dateLocation.getTime()) / (3.6*(Math.pow(10,6))))+1 ;

        for (Velo v: this.Velos) {
            prixLocation += prixLocation + (v.getPrix() * heureLocation);
        }

        this.prixLoc = prixLocation;
        this.dateRendu = dateRendu;
    }

    public double getPrixLoc() {
        return prixLoc;
    }

    @Override
    public String toString() {
        return "("+id+") - Location{" + "\n" +
                "   - dateLocation=" + dateLocation + "\n" +
                "   - dateRendu =" + dateRendu + "\n" +
                "   - Velos=" + Velos + "\n" +
                '}';
    }
}
