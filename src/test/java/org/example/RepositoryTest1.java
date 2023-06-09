package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest1 {

    Repository repository;

    @BeforeEach
    void setUp() {
        repository = new Repository();
    }


    @Test
    void test1() {
        assertNull(repository.findByEmail("pepe@pepe.com"));
        Cuenta cuenta1 = new Cuenta("pepe@pepe.com", 500);
        assertTrue(repository.add(cuenta1));
        assertEquals(cuenta1,repository.findByEmail("pepe@pepe.com") );
        assertEquals(500, repository.findByEmail("pepe@pepe.com").getSaldo());
        assertFalse(repository.add(new Cuenta("pepe@pepe.com", 400)));


        repository.ingresarDinero("pepe@pepe.com", 200.11f);
        assertEquals(700.11f, repository.findByEmail("pepe@pepe.com").getSaldo());

    }




}