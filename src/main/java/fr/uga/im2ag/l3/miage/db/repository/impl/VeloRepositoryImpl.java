package fr.uga.im2ag.l3.miage.db.repository.impl;



import fr.uga.im2ag.l3.miage.db.repository.api.VeloRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;


public class VeloRepositoryImpl extends BaseRepositoryImpl implements VeloRepository {

    public VeloRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


}
