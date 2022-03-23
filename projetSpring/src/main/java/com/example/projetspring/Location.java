package com.example.projetspring;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
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
    @Column(nullable = false)
    private Date dateRendu ;

    @OneToMany(mappedBy = "location")
    private List<Velo> Velos ;

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
