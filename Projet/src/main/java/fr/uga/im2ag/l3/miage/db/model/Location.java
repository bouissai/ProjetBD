package fr.uga.im2ag.l3.miage.db.model;

import java.util.Date;
import java.util.List;

public class Location {
    private Long id ;
    private Date dateLocation ;
    private Date dateRendu ;


    private List<Location> Velos ;

    public Long getId() {
        return id;
    }

    public Date getDateLocation() {
        return dateLocation;
    }

    public Date getDateRendu() {
        return dateRendu;
    }

}
