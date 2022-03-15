package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.model.Modele;
import fr.uga.im2ag.l3.miage.db.repository.api.ModeleRepository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

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
