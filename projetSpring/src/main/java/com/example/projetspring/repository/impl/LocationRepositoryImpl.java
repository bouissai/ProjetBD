package com.example.projetspring.repository.impl;

import com.example.projetspring.Location;
import com.example.projetspring.repository.api.LocationRepository;


import javax.persistence.EntityManager;

import java.util.List;



public class LocationRepositoryImpl extends BaseRepositoryImpl implements LocationRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public LocationRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public void saveLocation(Location l){
        entityManager.getTransaction().begin();
        entityManager.persist(l);
        entityManager.getTransaction().commit();
        entityManager.detach(l);
    }

    public Location findById(Long id) {
        return entityManager.find(Location.class, id);
    }

    public List<Location> getAll(){
        return entityManager.createNamedQuery("get-all-locations", Location.class ).getResultList();

    }

}
