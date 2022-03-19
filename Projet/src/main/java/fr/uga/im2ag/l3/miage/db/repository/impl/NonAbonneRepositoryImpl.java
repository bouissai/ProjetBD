package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.model.NonAbonne;
import fr.uga.im2ag.l3.miage.db.repository.api.NonAbonneRepository;

import javax.persistence.EntityManager;

public class NonAbonneRepositoryImpl  extends BaseRepositoryImpl implements NonAbonneRepository {
    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public NonAbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
