package org.example;

public class Controller {

    private final Repository repository = new Repository();

    private static final float MIN_CANTIDAD_TRANSACCION = 0.50f;
    private static final float MAX_CANTIDAD_TRANSACCION = 500f;


    /**
     * Metedo que registra una cuenta
     * @param emailRegistro tipo String
     * @param cantidadInicial tipo float
     * @return crea una cuenta con el email y la cantidad que recibe y la añade a la base de datos
     * @throws CantidadInicialMenorOIgualQueCeroException salta una excepción si la cantidad es igual o menor a 0
     */

    public boolean registrarCuenta(String emailRegistro, float cantidadInicial) throws CantidadInicialMenorOIgualQueCeroException {
        if (cantidadInicial <= 0) throw new CantidadInicialMenorOIgualQueCeroException();
        return repository.add(new Cuenta(emailRegistro, cantidadInicial));
    }

    /**
     * Método que consulta el saldo de una cuenta
     * @param email tipo String
     * @return devuelve el saldo una cuenta si su email existe en la BdD
     * @throws CuentaNoExisteException salta una excepción si en el objeto cuenta hemos guardado un null (porque el método findbyEmail devuelve null en caso de que el email que le pasas no existe en la BdD)
     */
    public float consultarSaldo(String email) throws CuentaNoExisteException {
        //findbyEmail devuelve una cuenta en caso de que el email que le pasas coincida con alguno de los que están en la BdD y null si no existe
        //Por lo tanto, en el objeto cuenta que creamos en la siguiente linea puede haber o una cuenta o un null
        Cuenta cuenta = repository.findByEmail(email);
        if (cuenta==null) throw new CuentaNoExisteException();
        else return cuenta.getSaldo();
    }

    /**
     * Método que ingresa dinero en una cuenta
     * @param emailOrigen tipo String
     * @param cantidad tipo float
     * @throws CantidadInicialMenorOIgualQueCeroException salta una excepción si la cantidad es menor o igual a 0
     * @throws CantidadInIntervaloValidoException  salta una excepción si la cantidad es menor que la mínima o mayor que la máxima
     */
    public void ingresarDinero(String emailOrigen, float cantidad) throws CantidadInicialMenorOIgualQueCeroException, CantidadInIntervaloValidoException {
        if (cantidad <= 0) throw new CantidadInicialMenorOIgualQueCeroException();
        if ((cantidad < MIN_CANTIDAD_TRANSACCION) || (cantidad > MAX_CANTIDAD_TRANSACCION))
            throw new CantidadInIntervaloValidoException();
        repository.ingresarDinero(emailOrigen,cantidad);
    }

    /**
     * Método que saca dinero de una cuenta
     * @param emailDestino tipo String
     * @param cantidad tipo float
     * @throws CantidadInicialMenorOIgualQueCeroException salta una excepción si la cantidad es menor o igual a 0
     * @throws CantidadInIntervaloValidoException salta una excepción si la cantidad es menor que la mínima o mayor que la máxima
     * @throws CantidadMayorQueSaldoException  salta una excepción en caso de que la cantidad a restar sea mayor que el saldo
     */
    public void sacarDinero(String emailDestino, float cantidad) throws CantidadInicialMenorOIgualQueCeroException, CantidadInIntervaloValidoException,CantidadMayorQueSaldoException {
        if (cantidad <= 0) throw new CantidadInicialMenorOIgualQueCeroException();
        if ((cantidad < MIN_CANTIDAD_TRANSACCION) || (cantidad > MAX_CANTIDAD_TRANSACCION)) throw new CantidadInIntervaloValidoException();
        repository.sacarDinero(emailDestino, cantidad);
    }


}
