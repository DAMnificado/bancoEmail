package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTestHector {

    Repository repo;
    Cuenta c1;
    Cuenta c2;
    Cuenta c3;

    @BeforeEach
    void setUp() {
    repo = new Repository();
    c1 = new Cuenta("angel@gmail.com", 100);
    c2 = new Cuenta("fresas@gmail.com",400);
    c3 = new Cuenta("fresas@gmail.com",400);
        repo.add(c1);
    }

    @Test
    void add() {
        Assertions.assertAll(
                () -> assertTrue(repo.add(c2)),
                () -> assertFalse(repo.add(c2)),
                () -> assertFalse(repo.add(c3))
        );

    }

    @Test
    void findByEmail() {

        Assertions.assertEquals(c1.getEmail(), repo.findByEmail("angel@gmail.com").getEmail());
        Assertions.assertEquals(c1.getSaldo(), repo.findByEmail("angel@gmail.com").getSaldo());
        Assertions.assertNull(repo.findByEmail("pepe@gmail.com"));
    }

    @Test
    void ingresarDinero() {

        repo.ingresarDinero("angel@gmail.com",20);
        Assertions.assertEquals(120,repo.findByEmail("angel@gmail.com").getSaldo());

    }

    @Test
    void sacarDinero() throws CantidadMayorQueSaldoException {
        repo.sacarDinero("angel@gmail.com", 50);

      Assertions.assertEquals(50,repo.findByEmail("angel@gmail.com").getSaldo());
      Assertions.assertThrows(CantidadMayorQueSaldoException.class, ()->{
          repo.sacarDinero("angel@gmail.com", 200);
        });
    }
}