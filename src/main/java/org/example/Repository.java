package org.example;

import java.util.*;

public class Repository {

    private final List<Cuenta> baseDeDatos = new ArrayList<>();

    /**
     * Método que añade una cuenta a nuestra base de datos
     * @param cuenta tipo cuenta
     * @return si existe la cuenta me da false // si NO existe la cuenta la añade a la base de datos
     */
    public boolean add(Cuenta cuenta) {
        if (findByEmail(cuenta.getEmail())!=null) return false;
        else return baseDeDatos.add(cuenta);
    }

    /**
     * Metodo que busca una cuenta por el email
     * @param email tipo String
     * @return devuelve la cuenta asociada al email en caso de que exista en nuestra base // si no encuentra email devuelve null
     */
    public Cuenta findByEmail(String email) {
        return baseDeDatos.stream().filter(e -> e.getEmail().equals(email)).findAny().orElse(null);
    }

    /**
     * Método para ingresar dinero a una cuenta buscándola por su email
     * @param emailOrigen tipo String
     * @param cantidad tipo float
     */
    public void ingresarDinero(String emailOrigen, float cantidad) {
        findByEmail(emailOrigen).sumarASaldo(cantidad);
    }

    /**
     * Método para sacar dinero a una cuenta buscándola por su email
     * @param emailDestino tipo String
     * @param cantidad tipo cantidad
     * @throws CantidadMayorQueSaldoException salta una exepción en caso de que la cantidad a restar sea mayor que el saldo
     */
    public void sacarDinero(String emailDestino, float cantidad) throws CantidadMayorQueSaldoException {
        findByEmail(emailDestino).restarASaldo(cantidad);
    }
}
