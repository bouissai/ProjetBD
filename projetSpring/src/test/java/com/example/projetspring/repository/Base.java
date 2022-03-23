package com.example.projetspring.repository;

import org.junit.jupiter.api.BeforeEach;

import javax.persistence.*;


public abstract class Base {
    protected EntityManager entityManager;
    protected RepositoryFactory daoFactory = new RepositoryFactory();

    /**
     * Creates fresh thus empty database for each test method.
     */
    @BeforeEach
    public final void setup() {
        entityManager = Persistence.createEntityManagerFactory("Test")
                .createEntityManager();
        //entityManager = Persistence.createEntityManagerFactory("test").createEntityManager();
    }
}
