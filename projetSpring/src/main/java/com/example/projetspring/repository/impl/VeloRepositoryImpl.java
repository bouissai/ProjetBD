package com.example.projetspring.repository.impl;



import com.example.projetspring.Velo;
import com.example.projetspring.repository.api.VeloRepository;

import javax.persistence.EntityManager;

import java.util.List;


public class VeloRepositoryImpl extends BaseRepositoryImpl implements VeloRepository {

    public VeloRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public void saveVelo(Velo v){
        entityManager.getTransaction().begin();
        entityManager.persist(v);
        entityManager.getTransaction().commit();
        entityManager.detach(v);
    }

    public Velo findById(Long id) {
        return entityManager.find(Velo.class, id);
    }

    public List<Velo> getAll(){
        return entityManager.createNamedQuery("get-all-velos", Velo.class ).getResultList();

    }

}