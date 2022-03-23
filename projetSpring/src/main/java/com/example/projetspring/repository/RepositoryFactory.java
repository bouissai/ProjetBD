package com.example.projetspring.repository;


import com.example.projetspring.repository.api.*;
import com.example.projetspring.repository.impl.*;


import javax.persistence.EntityManager;

public class RepositoryFactory {

    public StationRepository newStationRepository(EntityManager entityManager) {
        return new StationRepositoryImpl(entityManager);
    }

    public BornetteRepository newBornetteRepository(EntityManager entityManager) {
        return new BornetteRepositoryImpl(entityManager);
    }

    public VeloRepository newVeloRepository(EntityManager entityManager) {
        return new VeloRepositoryImpl(entityManager);
    }

    public LocationRepository newLocationRepository(EntityManager entityManager) {
        return new LocationRepositoryImpl(entityManager);
    }

    public ModeleRepository newModeleRepository(EntityManager entityManager) {
        return new ModeleRepositoryImpl(entityManager);
    }

    public ClientRepository newClientRepository(EntityManager entityManager) {
        return new ClientRepositoryImpl(entityManager);
    }

    public AbonneRepository newAbonneRepository(EntityManager entityManager) {
        return new AbonneRepositoryImpl(entityManager);
    }
    public NonAbonneRepository newNonAbonneRepository(EntityManager entityManager) {
        return new NonAbonneRepositoryImpl(entityManager);
    }

}
