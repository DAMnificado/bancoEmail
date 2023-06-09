package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTestHector {

    Controller control;
    Cuenta cuenta;

    @BeforeEach
    void setUp(){
        control = new Controller();
    }

    @Test
    void registrarCuenta(){

      Assertions.assertAll(
              () ->  assertTrue(control.registrarCuenta("fresi@gmail.com",50)),
              () ->  assertFalse(control.registrarCuenta("fresi@gmail.com",50)),

              () ->  assertThrows(CantidadInicialMenorOIgualQueCeroException.class, () ->{
                  control.registrarCuenta("pep@gmail.com",0);
                  control.registrarCuenta("pap@gmail.com",-2);
              })
      );
    }

    @Test
    void consultarSaldo() throws CantidadInicialMenorOIgualQueCeroException, CuentaNoExisteException {

        control.registrarCuenta("eee@gmail.com",70);
        Assertions.assertAll(
                () -> assertEquals(70,control.consultarSaldo("eee@gmail.com")),
                () -> assertThrows(CuentaNoExisteException.class, ()->{
                    control.consultarSaldo("hahaha@gmail.com");
                })
        );


    }

    @Test
    void ingresarDinero() throws CantidadInicialMenorOIgualQueCeroException, CantidadInIntervaloValidoException {

        control.registrarCuenta("mipene@gmail.com",100);
        control.ingresarDinero("mipene@gmail.com",50);

        control.registrarCuenta("mi@gmail.com",200);
        control.registrarCuenta("pene@gmail.com",105);

        Assertions.assertAll(

                () -> assertEquals(150,control.consultarSaldo("mipene@gmail.com")),

                () -> assertThrows(CantidadInicialMenorOIgualQueCeroException.class, () ->{
                    control.ingresarDinero("mipene@gmail.com",0);
                    control.ingresarDinero("mipene@gmail.com",-5);

                }),

              () -> assertThrows(CantidadInIntervaloValidoException.class, () ->{
                    control.ingresarDinero("mi@gmail.com",0.25f);
                    control.ingresarDinero("pene@gmail.com",600);

        })

        );

    }

    @Test
    void sacarDinero() throws CantidadInicialMenorOIgualQueCeroException, CantidadMayorQueSaldoException, CantidadInIntervaloValidoException {
        control.registrarCuenta("kote@gmail.com",150);
        control.sacarDinero("kote@gmail.com",50);

        control.registrarCuenta("auri@gmail.com",100);
        control.registrarCuenta("elodin@gmail.com",125);

        Assertions.assertAll(
                () -> assertEquals(100,control.consultarSaldo("kote@gmail.com")),
                () -> assertThrows(CantidadInicialMenorOIgualQueCeroException.class, () ->{
                    control.sacarDinero("auri@gmail.com",0);
                    control.sacarDinero("auri@gmail.com",-10);
                }),
                () -> assertThrows(CantidadInIntervaloValidoException.class, () ->{
                    control.sacarDinero("elodin@gmail.com",0.25f);
                    control.sacarDinero("elodin@gmail.com",600);
                }),
                ()-> assertThrows(CantidadMayorQueSaldoException.class, () ->{
                    control.sacarDinero("elodin@gmail.com",126);
                })

        );
    }
}