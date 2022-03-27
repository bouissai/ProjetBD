package com.example.projetspring.repository.impl;


import com.example.projetspring.Client;
import com.example.projetspring.Location;
import com.example.projetspring.Station;
import com.example.projetspring.Velo;
import com.example.projetspring.repository.api.ClientRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class ClientRepositoryImpl extends BaseRepositoryImpl implements ClientRepository {


    public ClientRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public void saveClient(Client c){
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
        entityManager.detach(c);
    }

    public Client findById(Long id) {
        return entityManager.find(Client.class, id);
    }

        /*
    public void clientLoueUnVelo(Client client, Velo velo){
        Location l = new Location();
        Date today = Calendar.getInstance().getTime();
        l.setDateLocation(today);
        entityManager.getTransaction().begin();
        entityManager.persist(l);
        entityManager.getTransaction().commit();
        entityManager.detach(l);
        velo.setLocation(l);
        client.addLoue(l);
    }*/

    public List<Location> findLocationByClient(long codeSecret){
        final List<Location> locations = entityManager.createQuery("select c.loue from Client c join c.loue l  where c.codeSecret = ?1 and l.dateRendu = ?2").setParameter(1,codeSecret).setParameter(2,null).getResultList();
        return locations;
    }


}
