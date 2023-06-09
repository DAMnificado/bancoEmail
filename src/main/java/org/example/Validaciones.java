package org.example;

import java.util.regex.Pattern;

public final class Validaciones {
    private Validaciones(){}

    // Patrón para verificar un email utilizando expresiones regulares

    private static final String REGEX_EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    // El email será válido cuando se compone (en el siguiente orden) de
    //     - parte local (al menos una letra)
    //     - arroba
    //     - dominio (al menos dos letras, un punto y al menos otras dos letras)
    // Además, se permite el uso de los caracteres punto (".") y guión ("-") pero
    //     - el punto no puede estar al principio o al final de la parte local (antes de la arroba)
    //     ni al final del email
    //     - el guión no puede estar al principio o final de la parte de domino, ni después del punto
    //     - no puede haber dos puntos consecutivos.

    /**
     * Método para comprobar si el email que recibe es INVÁLIDO
     * @param email tipo string
     * @return devuelve FALSE si el email es válido
     */
    public static boolean isEmailInvalido(String email) {
        return !Pattern.compile(REGEX_EMAIL_PATTERN).matcher(email).matches();
    }
}
