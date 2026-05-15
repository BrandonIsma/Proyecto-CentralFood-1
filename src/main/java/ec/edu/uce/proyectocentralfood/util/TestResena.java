package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.Resena;

import java.util.Date;

public class TestResena {

    public static void main(String[] args) {

        System.out.println("--- TEST RESEÑA ---");

        Date fechaCreacion = new Date();

        Resena resena = new Resena(
                1,
                5,
                "Excelente comida y buena atención.",
                fechaCreacion
        );

        // PRUEBA ID RESEÑA
        System.out.print("Prueba ID reseña: ");
        if (resena.getIdResena() == 1) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA CALIFICACIÓN
        System.out.print("Prueba calificación: ");
        if (resena.getCalificacion() == 5) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA COMENTARIO
        System.out.print("Prueba comentario: ");
        if ("Excelente comida y buena atención.".equals(resena.getComentario())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA FECHA CREACIÓN
        System.out.print("Prueba fecha creación: ");
        if (fechaCreacion.equals(resena.getFechaCreacion())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ACTUALIZACIÓN DE DATOS
        resena.setCalificacion(4);
        resena.setComentario("Buena comida, pero puede mejorar.");

        System.out.print("Prueba actualización calificación: ");
        if (resena.getCalificacion() == 4) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización comentario: ");
        if ("Buena comida, pero puede mejorar.".equals(resena.getComentario())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // EJECUCIÓN DE MÉTODOS DEL DIAGRAMA
        resena.crearResena();
        resena.consultarResena();
        resena.actualizarResena();
        resena.eliminarResena();

        System.out.println("\nDATOS DE LA RESEÑA:");
        System.out.println(resena);

        System.out.println("--- FIN TEST RESEÑA ---");
    }
}