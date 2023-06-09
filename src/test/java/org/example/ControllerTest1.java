package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest1 {

    Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller();
    }

    @Test
    void tests() throws CantidadInicialMenorOIgualQueCeroException, CuentaNoExisteException, CantidadMayorQueSaldoException, CantidadInIntervaloValidoException {

        assertThrows(CantidadInicialMenorOIgualQueCeroException.class, () -> {
            controller.registrarCuenta("pepe@pepe.com", 0); // Valor límite
        });
        assertTrue(controller.registrarCuenta("pepe@pepe.com", 0.01f)); // Valor límite
        assertTrue(controller.registrarCuenta("pepe2@pepe.com", 600));
        assertFalse(controller.registrarCuenta("pepe@pepe.com", 2)); // Cuenta ya existente

        // Recuperamos el saldo de la cuenta ya creada, comprobando que se creó correctamente y que consultar saldo funciona
        assertEquals(0.01f, controller.consultarSaldo("pepe@pepe.com"));

        assertThrows(CuentaNoExisteException.class, () -> {
            controller.consultarSaldo("pepe@pep.com");
        });


        assertThrows(CantidadInicialMenorOIgualQueCeroException.class, () -> {
            controller.ingresarDinero("pepe@pepe.com", 0);
        });
        assertThrows(CantidadInicialMenorOIgualQueCeroException.class, () -> {
            controller.ingresarDinero("pepe@pepe.com", -1);
        });

        assertThrows(CantidadInIntervaloValidoException.class, () -> {
            controller.ingresarDinero("pepe@pepe.com", 0.49f);
        });
        assertThrows(CantidadInIntervaloValidoException.class, () -> {
            controller.ingresarDinero("pepe@pepe.com", 500.01f);
        });

        controller.ingresarDinero("pepe@pepe.com", 500);
        assertEquals(500.01, controller.consultarSaldo("pepe@pepe.com"), 0.001);



        assertThrows(CantidadInicialMenorOIgualQueCeroException.class, () -> {
            controller.sacarDinero("pepe@pepe.com", 0);
        });
        assertThrows(CantidadInicialMenorOIgualQueCeroException.class, () -> {
            controller.sacarDinero("pepe@pepe.com", -1);
        });

        assertThrows(CantidadInIntervaloValidoException.class, () -> {
            controller.sacarDinero("pepe@pepe.com", 0.49f);
        });
        assertThrows(CantidadInIntervaloValidoException.class, () -> {
            controller.sacarDinero("pepe@pepe.com", 500.01f);
        });

        controller.sacarDinero("pepe@pepe.com", 300);
        assertEquals(200.01, controller.consultarSaldo("pepe@pepe.com"), 0.001);
    }

}