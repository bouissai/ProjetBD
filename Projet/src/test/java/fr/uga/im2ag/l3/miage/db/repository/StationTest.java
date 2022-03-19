package fr.uga.im2ag.l3.miage.db.repository;
import
        java.sql.Date;

import static fr.uga.im2ag.l3.miage.db.model.Statut.*;
import static org.assertj.core.api.Assertions.assertThat;


import fr.uga.im2ag.l3.miage.db.model.Station;
import fr.uga.im2ag.l3.miage.db.repository.impl.StationRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StationTest extends Base {

    StationRepositoryImpl stationRepository;

    @BeforeEach
    void before() {
        stationRepository = (StationRepositoryImpl) daoFactory.newStationRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveStation() {
        // TODO
        final var station = new Station();
        station.setStatus(VPLUS);
        station.setAdresse("Rue de bonheur");

        entityManager.getTransaction().begin();
        entityManager.persist(station);
        entityManager.getTransaction().commit();
        entityManager.detach(station);

        var T_station = stationRepository.findById(station.getId());
        assertThat(T_station.getId() == station.getId());

    	

    }



}
