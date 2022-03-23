package com.example.projetspring.repository;

import com.example.projetspring.Client;
import com.example.projetspring.NonAbonne;
import com.example.projetspring.repository.api.ClientRepository;
import com.example.projetspring.repository.impl.ClientRepositoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClientTest extends Base{
    ClientRepositoryImpl clientRepository;
    @AfterAll
    static void afterAll() {

    }

    @BeforeAll
    static void beforeAll() {

    }



}
