package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.model.Bornette;
import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.repository.api.BornetteRepository;


import javax.persistence.EntityManager;

import java.util.List;


public class BornetteRepositoryImpl extends BaseRepositoryImpl implements BornetteRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public BornetteRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public Bornette findById(Long id) {
        return entityManager.find(Bornette.class, id);
    }

    public List<Bornette> getAll(){
        return entityManager.createNamedQuery("get-all-bornettes", Bornette.class ).getResultList();

    }

}
