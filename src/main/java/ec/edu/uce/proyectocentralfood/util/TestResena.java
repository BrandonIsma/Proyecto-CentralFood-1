package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.Resena;

import java.util.Date;

public class TestResena {

    public static void main(String[] args) {

        System.out.println("--- TEST RESEÑA ---");

        Resena resena = new Resena(
                1,
                5,
                "Excelente atención y comida deliciosa.",
                new Date()
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
        if ("Excelente atención y comida deliciosa.".equals(resena.getComentario())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA FECHA
        System.out.print("Prueba fecha creación: ");
        if (resena.getFechaCreacion() != null) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // ACTUALIZAR DATOS
        resena.setCalificacion(4);
        resena.setComentario("Buen servicio y ambiente agradable.");

        // PRUEBA ACTUALIZACIÓN CALIFICACIÓN
        System.out.print("Prueba actualización calificación: ");
        if (resena.getCalificacion() == 4) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización comentario: ");
        if ("Buen servicio y ambiente agradable.".equals(resena.getComentario())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DE LA RESEÑA:");
        System.out.println(resena);

        System.out.println("--- FIN TEST RESEÑA ---");
    }
}