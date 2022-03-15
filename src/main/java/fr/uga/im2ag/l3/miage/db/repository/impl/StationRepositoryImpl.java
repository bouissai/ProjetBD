package fr.uga.im2ag.l3.miage.db.repository.impl;


import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.repository.api.StationRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class StationRepositoryImpl  extends BaseRepositoryImpl implements StationRepository {


    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public StationRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public void save(Station entity) { entityManager.persist(entity);}

    public void delete(Station entity) { entityManager.remove(entity);}

    public Station findById(Long id) {
        return entityManager.find(Station.class, id);
    }

    public List<Station> getAll(){
        return entityManager.createNamedQuery("get-all-stations", Station.class ).getResultList();

    }


}
