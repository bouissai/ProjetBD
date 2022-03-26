package com.example.projetspring.repository.impl;

import com.example.projetspring.Client;
import com.example.projetspring.NonAbonne;
import com.example.projetspring.repository.api.NonAbonneRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

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

    public NonAbonne findById(long id) {
        return entityManager.find(NonAbonne.class, id);
    }

    public void delete(NonAbonne nonAbonne) {
        entityManager.remove(nonAbonne);
    }

    public void save(Client na, int numCarte){
        na.setNumeroCB(numCarte);
        entityManager.getTransaction().begin();
        entityManager.persist(na);
        entityManager.getTransaction().commit();
        entityManager.detach(na);
    }
}