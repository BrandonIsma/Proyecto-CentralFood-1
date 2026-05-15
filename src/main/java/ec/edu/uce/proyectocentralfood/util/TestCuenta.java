package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.Cuenta;

import java.util.Date;

public class TestCuenta {

    public static void main(String[] args) {

        System.out.println("===== PRUEBA DE FUNCIONAMIENTO: CUENTA =====");

        Date fechaNacimiento = new Date();

        Cuenta cuenta = new Cuenta(
                1,
                "Brandon",
                "brandon@uce.edu.ec",
                fechaNacimiento
        );

        System.out.println("\nCuenta registrada:");
        System.out.println(cuenta);

        if (cuenta != null
                && cuenta.getIdPersona() == 1
                && "Brandon".equals(cuenta.getNombre())
                && "brandon@uce.edu.ec".equals(cuenta.getCorreo())
                && cuenta.getFechaNacimiento() != null) {

            System.out.println("Resultado: La cuenta fue creada correctamente.");
        } else {
            System.out.println("Resultado: Error al crear la cuenta.");
        }

        System.out.println("\nActualizando datos de la cuenta...");

        cuenta.setNombre("Brandon Tacuri");
        cuenta.setCorreo("brandon.tacuri@uce.edu.ec");

        System.out.println("Cuenta actualizada:");
        System.out.println(cuenta);

        if ("Brandon Tacuri".equals(cuenta.getNombre())
                && "brandon.tacuri@uce.edu.ec".equals(cuenta.getCorreo())) {

            System.out.println("Resultado: Los datos de la cuenta fueron actualizados correctamente.");
        } else {
            System.out.println("Resultado: Error al actualizar los datos de la cuenta.");
        }

        System.out.println("\nEjecutando acciones de la cuenta...");

        cuenta.iniciarSesion();
        cuenta.actualizarCredenciales();
        cuenta.consultarPerfil();
        cuenta.cerrarSesion();

        System.out.println("Resultado: Las acciones de la cuenta se ejecutaron sin errores.");

        System.out.println("\n===== FIN DE LA PRUEBA CUENTA =====");
    }
}