package com.example.projetspring.repository;

import com.example.projetspring.repository.api.AbonneRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbonneTest extends Base {

    AbonneRepository subjectRepository;

    @BeforeEach
    void before() {
        subjectRepository = daoFactory.newAbonneRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveSubject() {



    }



}
