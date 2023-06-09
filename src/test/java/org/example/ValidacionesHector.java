package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// El email será válido cuando se compone (en el siguiente orden) de
//     - parte local (al menos una letra)
//     - arroba
//     - dominio (al menos dos letras, un punto y al menos otras dos letras)
//      Además, se permite el uso de los caracteres punto (".") y guión ("-") pero
//     - el punto no puede estar al principio o al final de la parte local (antes de la arroba)
//     ni al final del email
//     - el guión no puede estar al principio o final de la parte de domino, ni después del punto
//     - no puede haber dos puntos consecutivos.

class ValidacionesHector {

    @Test
    void isEmailInvalido() {

        Assertions.assertAll(

                () -> assertFalse(Validaciones.isEmailInvalido("hector@gmail.com")),
                () -> assertTrue(Validaciones.isEmailInvalido("")),


                //     - parte local (al menos una letra)
                () -> assertFalse(Validaciones.isEmailInvalido("h@gmail.com")),
                () -> assertTrue(Validaciones.isEmailInvalido("@gmail.com")),

                //     - arroba
                () -> assertFalse(Validaciones.isEmailInvalido("hector@gmail.com")),
                () -> assertTrue(Validaciones.isEmailInvalido("hectorgmail.com")),

                //     - dominio (al menos dos letras, un punto y al menos otras dos letras)
                () -> assertFalse(Validaciones.isEmailInvalido("hector@gm.co")),
                () -> assertTrue(Validaciones.isEmailInvalido("hector@g.co")),
                () -> assertTrue(Validaciones.isEmailInvalido("hector@gm.c")),
                () -> assertTrue(Validaciones.isEmailInvalido("hector@gmco")),

                //      - Además, del punto (".") pero
                // no puede estar
                // ni al principio o al final de la parte local (antes de la arroba)
                // ni al final del email
                // **no puede haber dos puntos consecutivos**

                () -> assertFalse(Validaciones.isEmailInvalido("hector@.gmail.com")),
                () -> assertFalse(Validaciones.isEmailInvalido("he.ctor@gmail.com")),
                () -> assertFalse(Validaciones.isEmailInvalido("hector@gm.ail.com")),
                () -> assertTrue(Validaciones.isEmailInvalido("hector@gm..ail.com")),
                () -> assertTrue(Validaciones.isEmailInvalido("he..ctor@gmail.com")),
                () -> assertTrue(Validaciones.isEmailInvalido(".hector@gmail.com")),
                () -> assertTrue(Validaciones.isEmailInvalido("hector.@gmail.com")),
                () -> assertTrue(Validaciones.isEmailInvalido("hector.@gmail.com.")),

                //     - el uso el guión no puede estar
                //     ni al principio o final de la parte de domino,
                //     ni después del punto

                () -> assertTrue(Validaciones.isEmailInvalido("hector@-gmail.com")),
                () -> assertTrue(Validaciones.isEmailInvalido("hector@gmail.com-")),
                () -> assertTrue(Validaciones.isEmailInvalido("hector@gmail.-com")),
                () -> assertTrue(Validaciones.isEmailInvalido("hector@gmail.co-m")),

                () -> assertFalse(Validaciones.isEmailInvalido("he-ctor@gmail.com")),
                () -> assertFalse(Validaciones.isEmailInvalido("hector@gm-ail.com")),
                () -> assertFalse(Validaciones.isEmailInvalido("hector@gmail-.com"))

        );
    }
}