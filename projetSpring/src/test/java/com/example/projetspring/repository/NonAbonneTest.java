package com.example.projetspring.repository;

import com.example.projetspring.Abonne;
import com.example.projetspring.Client;
import com.example.projetspring.NonAbonne;
import com.example.projetspring.repository.api.AbonneRepository;
import com.example.projetspring.repository.impl.NonAbonneRepositoryImpl;
import com.example.projetspring.repository.impl.VeloRepositoryImpl;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class NonAbonneTest extends Base{
    NonAbonneRepositoryImpl nonAbonneRepository;

    @BeforeEach
    void before() {
        nonAbonneRepository = (NonAbonneRepositoryImpl) daoFactory.newNonAbonneRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

   /* @Test
    void shouldSaveNonAbonne(){
        final NonAbonne nonAbonne = new NonAbonne(123456,7654);

        entityManager.getTransaction().begin();
        entityManager.persist(nonAbonne);
        entityManager.getTransaction().commit();
        entityManager.detach(nonAbonne);

        Client c = nonAbonneRepository.findById(nonAbonne.getCodeSecret());

        assertThat(c.getCodeSecret() == nonAbonne.getCodeSecret());
    }*/
}
