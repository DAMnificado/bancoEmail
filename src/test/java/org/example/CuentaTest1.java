package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest1 {


    @Test
    void restarASaldo() throws CantidadMayorQueSaldoException {
        Cuenta cuenta = new Cuenta("pepe@pepe.com", 500.33f);
        cuenta.restarASaldo(300.11f);
        assertEquals(200.22f, cuenta.getSaldo());
        cuenta.restarASaldo(200.22f);
        assertEquals(0, cuenta.getSaldo());

        Cuenta cuenta2 = cuenta;
        assertThrows(CantidadMayorQueSaldoException.class, () -> {
            cuenta2.restarASaldo(0.01f);
        });
        Cuenta cuenta3 = new Cuenta("pepe@pepe.com", 500.33f);
        assertThrows(CantidadMayorQueSaldoException.class, () -> {
            cuenta3.restarASaldo(500.34f);
        });
    }


    @Test
    void sumarASaldo() {
        Cuenta cuenta = new Cuenta("pepe@pepe.com", 500.33f);
        cuenta.sumarASaldo(300.11f);
        assertEquals(800.44f, cuenta.getSaldo(), 1E-3);
    }
}