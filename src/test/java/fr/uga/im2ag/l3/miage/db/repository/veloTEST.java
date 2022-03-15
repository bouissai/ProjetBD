package fr.uga.im2ag.l3.miage.db.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import fr.uga.im2ag.l3.miage.db.repository.api.VeloRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class veloTEST extends Base {

    VeloRepository studentRepository;

    @BeforeEach
    void before() {
        studentRepository = daoFactory.newVeloRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveStudent() {



    }

    @Test
    void shouldFindStudentHavingGradeAverageAbove() {
    }

}
