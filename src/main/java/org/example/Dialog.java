package org.example;

import java.util.Scanner;

import static org.example.Validaciones.isEmailInvalido;

public class Dialog {
    private final Controller controller = new Controller();
    private final Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("Banco Chachi");
        System.out.println("======");
        String opcion;

        do {
            System.out.println("1. Registrar cuenta");
            System.out.println("2. Recibir dinero");
            System.out.println("3. Enviar dinero");
            System.out.println("4. Consultar saldo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextLine();
        } while (!(0 <= opcion.compareTo("0") && opcion.compareTo("4") <= 0));

        switch (Integer.parseInt(opcion)) {
            case 1 -> initRegistrarCuenta();
            case 2 -> initIngresarDinero();
            case 3 -> intEnviarDinero();
            case 4 -> initConsultarSaldo();
        }
        System.out.println();
        System.out.println("Hasta pronto");
    }

    public void initConsultarSaldo() {
        System.out.println("\nIntroduce email: ");
        String email = sc.nextLine();
        if (isEmailInvalido(email)) System.err.println("Email inválido");
        System.out.println("---------------");
        System.out.println("Consultar saldo");

        try {
            System.out.println("El saldo es: " + controller.consultarSaldo(email));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println();
        }

    }

    public void intEnviarDinero() {
        System.out.println("\nSacar dinero");
        System.out.println("Introduce email: ");
        String email = sc.nextLine();
        if (isEmailInvalido(email)) System.err.println("Email inválido");
        System.out.println("---------------");
        System.out.println("Introduce la cantidad:");
        try {
            float cantidad = Float.parseFloat(sc.nextLine());
            controller.sacarDinero(email, cantidad);
            System.out.println("Dinero enviado correctamente");
        } catch (NumberFormatException e) {
            System.err.println("Debe introducir un número (decimales separados con punto)");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println();
        }

    }

    public void initIngresarDinero() {
        System.out.println();
        System.out.println("Ingreso");
        System.out.println("==============");
        System.out.println("Introduce el email:");
        String email = sc.nextLine();
        if (isEmailInvalido(email)) {
            System.err.println("Email inválido\n");
            return;
        }
        System.out.println("Introduce la cantidad:");

        try {
            float cantidad = Float.parseFloat(sc.nextLine());
            controller.ingresarDinero(email, cantidad);
            System.out.println("Cuenta registrada correctamente");
        } catch (NumberFormatException e) {
            System.err.println("Debe introducir un número (decimales separados con punto)");
        } catch (Exception e) {
            System.err.println("ERROR");
        } finally {
            System.out.println();
        }

    }

    public void initRegistrarCuenta() {
        System.out.println("Registrar cuenta");
        System.out.println("===============");
        System.out.println("Introduce tu email:");
        String email = sc.nextLine();
        if (isEmailInvalido(email)) {
            System.err.println("Email inválido\n");
        } else {
            System.out.println("Introduce la cantidad inicial:");
            try {
                float cantidad = Float.parseFloat(sc.nextLine());
                if (controller.registrarCuenta(email, cantidad))
                    System.out.println("Cuenta registrada correctamente");
                else
                    System.err.println("Ya existe una cuenta con ese email");
            } catch (NumberFormatException e) {
                System.err.println("Debe introducir un número (decimales separados con punto)");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                System.out.println();
            }

        }

    }

}