package fr.uga.im2ag.l3.miage.db.repository.impl;


import fr.uga.im2ag.l3.miage.db.repository.api.ClientRepository;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;


public class ClientRepositoryImpl extends BaseRepositoryImpl implements ClientRepository {


    public ClientRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


}
