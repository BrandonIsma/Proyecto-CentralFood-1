package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.Cuenta;

import java.util.Date;

public class TestCuenta {

    public static void main(String[] args) {

        System.out.println("--- INICIANDO PRUEBAS DE CUENTA ---");

        Date fechaNacimiento = new Date();

        Cuenta cuenta = new Cuenta(
                1,
                "Brandon",
                "brandon@uce.edu.ec",
                fechaNacimiento
        );

        System.out.println();
        System.out.println("Estado inicial: " + cuenta);

        System.out.println();
        System.out.println("--- Probando getters ---");
        System.out.println("ID persona actual: " + cuenta.getIdPersona());
        System.out.println("Nombre actual: " + cuenta.getNombre());
        System.out.println("Correo actual: " + cuenta.getCorreo());
        System.out.println("Fecha de nacimiento actual: " + cuenta.getFechaNacimiento());

        System.out.println();
        System.out.println("--- Probando setters ---");
        cuenta.setIdPersona(2);
        cuenta.setNombre("Ismael");
        cuenta.setCorreo("ismael@uce.edu.ec");
        cuenta.setFechaNacimiento(new Date());

        System.out.println("ID persona actualizado: " + cuenta.getIdPersona());
        System.out.println("Nombre actualizado: " + cuenta.getNombre());
        System.out.println("Correo actualizado: " + cuenta.getCorreo());
        System.out.println("Fecha de nacimiento actualizada: " + cuenta.getFechaNacimiento());

        System.out.println();
        System.out.println("Estado actualizado: " + cuenta);

        System.out.println();
        System.out.println("--- Ejecutando acciones de cuenta ---");
        cuenta.iniciarSesion();
        System.out.println("--- Iniciar sesión ejecutado ---");

        cuenta.cerrarSesion();
        System.out.println("--- Cerrar sesión ejecutado ---");

        cuenta.actualizarCredenciales();
        System.out.println("--- Actualizar credenciales ejecutado ---");

        cuenta.consultarPerfil();
        System.out.println("--- Consultar perfil ejecutado ---");

        System.out.println();
        System.out.println("--- PRUEBAS FINALIZADAS CON ÉXITO ---");
    }
}