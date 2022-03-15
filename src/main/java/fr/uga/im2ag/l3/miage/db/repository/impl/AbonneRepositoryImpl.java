package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.repository.api.AbonneRepository;

import javax.persistence.EntityManager;

public class AbonneRepositoryImpl  extends BaseRepositoryImpl implements AbonneRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public AbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
