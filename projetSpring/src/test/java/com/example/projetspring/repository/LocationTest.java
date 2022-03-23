package com.example.projetspring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.projetspring.repository.api.LocationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocationTest extends Base {

	LocationRepository teacherRepository;

    @BeforeEach
    void before() {
        teacherRepository = daoFactory.newLocationRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }
    @Test
    void shouldSaveLocation(){

    }






}
