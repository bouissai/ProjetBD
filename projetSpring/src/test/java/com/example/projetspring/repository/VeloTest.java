package com.example.projetspring.repository;

import static com.example.projetspring.Statut.VPLUS;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.projetspring.Etat;
import com.example.projetspring.Marque;
import com.example.projetspring.Station;
import com.example.projetspring.Velo;
import com.example.projetspring.repository.api.VeloRepository;
import com.example.projetspring.repository.impl.VeloRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
@DataJpaTest
class VeloTest extends Base {

    VeloRepositoryImpl veloRepository;

    @BeforeEach
    void before() {
        veloRepository = (VeloRepositoryImpl) daoFactory.newVeloRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveVelo() {
        final var velo = new Velo();
        velo.setModele(Marque.VTT);
        velo.setEtat(Etat.OK);
        velo.setDateMisesEnService(new Date(2021,03,05));

        entityManager.getTransaction().begin();
        entityManager.persist(velo);
        entityManager.getTransaction().commit();
        entityManager.detach(velo);

        var v = veloRepository.findById(velo.getNumeroVelo());
        assertThat(v.getNumeroVelo() == velo.getNumeroVelo());


    }

    @Test
    void shouldFindStudentHavingGradeAverageAbove() {
    }

}
