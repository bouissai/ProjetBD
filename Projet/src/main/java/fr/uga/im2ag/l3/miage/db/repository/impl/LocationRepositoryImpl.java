package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.model.Location;
import fr.uga.im2ag.l3.miage.db.model.velo;
import fr.uga.im2ag.l3.miage.db.repository.api.LocationRepository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

    public Location findById(Long id) {
        return entityManager.find(Location.class, id);
    }

    public List<Location> getAll(){
        return entityManager.createNamedQuery("get-all-locations", Location.class ).getResultList();

    }

}
