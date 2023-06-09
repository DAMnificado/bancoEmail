package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionesTest1 {

    @Test
    void isEmailInValido() {
        assertTrue(Validaciones.isEmailInvalido(""));
        assertFalse(Validaciones.isEmailInvalido("pepe@pepe.com"));

        assertTrue(Validaciones.isEmailInvalido("@pepe.com"));
        //assertTrue(Validaciones.isEmailInvalido("5@pepe.com"));
        assertTrue(Validaciones.isEmailInvalido(".@pepe.com"));
        //assertTrue(Validaciones.isEmailInvalido("-@pepe.com"));
        assertFalse(Validaciones.isEmailInvalido("p@pepe.com"));


        assertTrue(Validaciones.isEmailInvalido("pepe.com"));
        assertTrue(Validaciones.isEmailInvalido("p@p.com"));
        assertTrue(Validaciones.isEmailInvalido("p@pcom"));
        assertTrue(Validaciones.isEmailInvalido("p@pe.c"));

        assertFalse(Validaciones.isEmailInvalido("p.p@.pe.pe.co.um"));
        assertTrue(Validaciones.isEmailInvalido("p.@pepe.com"));
        assertTrue(Validaciones.isEmailInvalido(".p@pepe.com"));
        assertTrue(Validaciones.isEmailInvalido("p@pepe.com."));

        assertFalse(Validaciones.isEmailInvalido("p-p@pe-pe.com"));
        assertTrue(Validaciones.isEmailInvalido("p@pepe.com-"));
        assertTrue(Validaciones.isEmailInvalido("p@-pepe.com"));
        assertTrue(Validaciones.isEmailInvalido("p@pepe.-com"));


        assertTrue(Validaciones.isEmailInvalido("p..p@pepe.com"));
        assertTrue(Validaciones.isEmailInvalido("p.p@pe..pe.com"));
        assertTrue(Validaciones.isEmailInvalido("p..p@pepe..com"));
        assertTrue(Validaciones.isEmailInvalido("p..p@p.epe..com"));

    }

}