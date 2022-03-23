package com.example.projetspring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.projetspring.repository.api.BornetteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class BornetteTest extends Base {

    BornetteRepository classRepository;

    @BeforeEach
    void before() {
        classRepository = daoFactory.newBornetteRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveClass() {
		// TODO


	}




}
