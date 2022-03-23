package com.example.projetspring.repository.impl;

import com.example.projetspring.Client;
import com.example.projetspring.NonAbonne;
import com.example.projetspring.repository.api.NonAbonneRepository;

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

    public NonAbonne findById(int id) {
        return entityManager.find(NonAbonne.class, id);
    }
}
