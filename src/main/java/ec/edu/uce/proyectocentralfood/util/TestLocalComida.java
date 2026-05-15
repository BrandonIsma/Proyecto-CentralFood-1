package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.LocalComida;

public class TestLocalComida {

    public static void main(String[] args) {

        System.out.println("--- TEST LOCAL COMIDA ---");

        LocalComida local = new LocalComida(
                1,
                "Comedor Central",
                "Local de comida ubicado cerca de la facultad.",
                "0999999999",
                "08:00-17:00",
                "ABIERTO",
                "BAJO"
        );

        // PRUEBA ID LOCAL
        System.out.print("Prueba ID local: ");
        if (local.getIdLocal() == 1) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }


        System.out.print("Prueba nombre: ");
        if ("Comedor Central".equals(local.getNombre())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }


        System.out.print("Prueba teléfono: ");
        if ("0999999999".equals(local.getTelefono())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }


        System.out.print("Prueba horario de atención: ");
        if ("08:00-17:00".equals(local.getHorarioAtencion())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ESTADO
        System.out.print("Prueba estado local: ");
        if ("ABIERTO".equals(local.getEstadoLocal())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA RANGO PRECIO
        System.out.print("Prueba rango precio: ");
        if ("BAJO".equals(local.getRangoPrecio())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        local.setNombre("Cafetería Universitaria");
        local.setEstadoLocal("CERRADO");
        local.setRangoPrecio("MEDIO");

        System.out.print("Prueba actualización nombre: ");
        if ("Cafetería Universitaria".equals(local.getNombre())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización estado: ");
        if ("CERRADO".equals(local.getEstadoLocal())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DEL LOCAL:");
        System.out.println(local);

        System.out.println("--- FIN TEST LOCAL COMIDA ---");
    }
}