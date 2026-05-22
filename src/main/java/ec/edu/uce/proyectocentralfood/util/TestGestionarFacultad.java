package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.Facultad;

public class TestGestionarFacultad {

    public static void main(String[] args) {

        System.out.println("--- TEST PUNTO DE Gestionar Facultad ---");

        Facultad punto = new Facultad(
                "Facultad de Ingeniería",
                "Punto de referencia ubicado dentro del campus universitario."
        );

        // PRUEBA NOMBRE
        System.out.print("Prueba nombre: ");
        if ("Facultad de Ingeniería".equals(punto.getNombre())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA DESCRIPCIÓN
        System.out.print("Prueba descripción: ");
        if ("Punto de referencia ubicado dentro del campus universitario.".equals(punto.getDescripcion())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ACTUALIZACIÓN
        punto.setNombre("Biblioteca General");
        punto.setDescripcion("Espacio universitario usado como punto de referencia.");

        System.out.print("Prueba actualización nombre: ");
        if ("Biblioteca General".equals(punto.getNombre())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización descripción: ");
        if ("Espacio universitario usado como punto de referencia.".equals(punto.getDescripcion())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DEL PUNTO DE REFERENCIA:");
        System.out.println(punto);

        System.out.println("--- FIN TEST PUNTO DE REFERENCIA UNIVERSITARIO ---");
    }
}