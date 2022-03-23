package com.example.projetspring.repository.impl;

import com.example.projetspring.repository.api.ModeleRepository;


import javax.persistence.EntityManager;

public class ModeleRepositoryImpl extends BaseRepositoryImpl implements ModeleRepository {


    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public ModeleRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


}
