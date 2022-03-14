package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long id ;
    private Date dateLocation ;
    private Date dateRendu ;


    public Location() {
    }

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
