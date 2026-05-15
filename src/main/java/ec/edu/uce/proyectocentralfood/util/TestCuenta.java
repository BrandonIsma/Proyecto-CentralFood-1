package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.Cuenta;

import java.util.Date;

public class TestCuenta {

    public static void main(String[] args) {

        System.out.println("--- TEST CUENTA ---");

        Date fechaNacimiento = new Date();

        Cuenta cuenta = new Cuenta(
                1,
                "Brandon",
                "brandon@uce.edu.ec",
                fechaNacimiento
        );

        // PRUEBA ID PERSONA
        System.out.print("Prueba ID persona: ");
        if (cuenta.getIdPersona() == 1) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA NOMBRE
        System.out.print("Prueba nombre: ");
        if ("Brandon".equals(cuenta.getNombre())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA CORREO
        System.out.print("Prueba correo: ");
        if ("brandon@uce.edu.ec".equals(cuenta.getCorreo())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA FECHA NACIMIENTO
        System.out.print("Prueba fecha nacimiento: ");
        if (fechaNacimiento.equals(cuenta.getFechaNacimiento())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ACTUALIZACIÓN DE DATOS
        cuenta.setNombre("Ismael");
        cuenta.setCorreo("ismael@uce.edu.ec");

        System.out.print("Prueba actualización nombre: ");
        if ("Ismael".equals(cuenta.getNombre())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización correo: ");
        if ("ismael@uce.edu.ec".equals(cuenta.getCorreo())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // EJECUCIÓN DE MÉTODOS DEL DIAGRAMA
        cuenta.iniciarSesion();
        cuenta.actualizarCredenciales();
        cuenta.consultarPerfil();
        cuenta.cerrarSesion();

        System.out.println("\nDATOS DE LA CUENTA:");
        System.out.println(cuenta);

        System.out.println("--- FIN TEST CUENTA ---");
    }
}