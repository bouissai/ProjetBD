package com.example.projetspring.repository.impl;


import com.example.projetspring.Client;
import com.example.projetspring.Station;
import com.example.projetspring.repository.api.ClientRepository;

import javax.persistence.EntityManager;


public class ClientRepositoryImpl extends BaseRepositoryImpl implements ClientRepository {


    public ClientRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


    public Client findById(int id) {
        return entityManager.find(Client.class, id);
    }

}
