package org.example;


public class Cuenta {

    private final String email;
    public String getEmail() { return email; }

    private float saldo;
    public float getSaldo() { return saldo; }

    public Cuenta(String email, float saldo) {
        this.email = email;
        this.saldo = saldo;
    }

    /**
     * Método para restar saldo a una cuenta
     * @param cantidad tipo float
     * @throws CantidadMayorQueSaldoException salta una exepcion en caso de que la cantidad a restar sea mayor que el saldo
     */
    public void restarASaldo(float cantidad) throws CantidadMayorQueSaldoException {
        if (cantidad > saldo) throw new CantidadMayorQueSaldoException();
        this.saldo -= cantidad;
    }

    /**
     * Metodo para sumar saldo a una cuenta
     * @param cantidad tipo float
     */
    public void sumarASaldo(float cantidad) {
        this.saldo += cantidad;
    }

}
