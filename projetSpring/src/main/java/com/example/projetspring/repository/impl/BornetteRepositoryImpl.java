package com.example.projetspring.repository.impl;

import com.example.projetspring.Bornette;
import com.example.projetspring.Station;
import com.example.projetspring.Velo;
import com.example.projetspring.repository.api.BornetteRepository;


import javax.persistence.EntityManager;

import java.util.List;


public class BornetteRepositoryImpl extends BaseRepositoryImpl implements BornetteRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public BornetteRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    public Bornette findById(Long id) {
        return entityManager.find(Bornette.class, id);
    }

    public List<Bornette> getAll(){
        return entityManager.createNamedQuery("get-all-bornettes", Bornette.class ).getResultList();
    }

    public Bornette findByIdVelo(long idVelo){
          return (Bornette) entityManager.createQuery("select b from Bornette b join b.Propose v where v.numeroVelo=?1",Bornette.class).setParameter(1,idVelo).getSingleResult();
    }
    public void saveBornette(Bornette b){
        entityManager.getTransaction().begin();
        entityManager.persist(b);
        entityManager.getTransaction().commit();
        entityManager.detach(b);
    }

}
