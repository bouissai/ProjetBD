package com.example.projetspring.repository.impl;

import com.example.projetspring.repository.api.AbonneRepository;

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
