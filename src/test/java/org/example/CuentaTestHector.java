package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTestHector {

    @Test
    void restarASaldo() throws CantidadMayorQueSaldoException {

        Cuenta c1 = new Cuenta("Eduardo@gmail.com", 250f);
        c1.restarASaldo(50f);

        Assertions.assertAll(
                ()-> assertEquals(200f,c1.getSaldo()),
                ()-> assertThrows(CantidadMayorQueSaldoException.class, ()->{
                    c1.restarASaldo(300f);
                })
        );
    }

    @Test
    void sumarASaldo() {
        Cuenta c1 = new Cuenta("Eduardo@gmail.com", 250f);
        c1.sumarASaldo(50f);

        Assertions.assertEquals(300f,c1.getSaldo());



    }
}