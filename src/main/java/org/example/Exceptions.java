package org.example;

/* TODO: Debería estar cada una en una clase en un paquete si queremos que
*   sean públicas. Las puse todas aquí por simplificar este caso. */


class CantidadInicialMenorOIgualQueCeroException extends Exception {
    @Override
    public String getMessage() {
        return "Una cuenta nueva debe crearse con un saldo inicial positivo";
    }
}

class CantidadInIntervaloValidoException extends Exception {
    @Override
    public String getMessage() {
        return "La cantidad debe estar entre 0.50 y 500";
    }
}

class CantidadMayorQueSaldoException extends Exception {
    @Override
    public String getMessage() {
        return "No hay suficiente saldo para realizar esta transacción";
    }
}

class CuentaNoExisteException extends Exception {
    @Override
    public String getMessage() {
        return "La cuenta no existe";
    }
}

