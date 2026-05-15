package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.Resena;

import java.util.Date;

public class TestResena {

    public static void main(String[] args) {

        System.out.println("===== PRUEBA DE FUNCIONAMIENTO: RESEÑA =====");

        Date fechaCreacion = new Date();

        Resena resena = new Resena(
                1,
                5,
                "Excelente comida y buena atención.",
                fechaCreacion
        );

        System.out.println("\nReseña registrada:");
        System.out.println(resena);

        if (resena != null
                && resena.getIdResena() == 1
                && resena.getCalificacion() == 5
                && "Excelente comida y buena atención.".equals(resena.getComentario())
                && resena.getFechaCreacion() != null) {

            System.out.println("Resultado: La reseña fue creada correctamente.");
        } else {
            System.out.println("Resultado: Error al crear la reseña.");
        }

        System.out.println("\nActualizando datos de la reseña...");

        resena.setCalificacion(4);
        resena.setComentario("Buena comida, pero el servicio puede mejorar.");

        System.out.println("Reseña actualizada:");
        System.out.println(resena);

        if (resena.getCalificacion() == 4
                && "Buena comida, pero el servicio puede mejorar.".equals(resena.getComentario())) {

            System.out.println("Resultado: Los datos de la reseña fueron actualizados correctamente.");
        } else {
            System.out.println("Resultado: Error al actualizar los datos de la reseña.");
        }

        System.out.println("\nEjecutando acciones de la reseña...");

        resena.crearResena();
        resena.consultarResena();
        resena.actualizarResena();
        resena.eliminarResena();

        System.out.println("Resultado: Las acciones de la reseña se ejecutaron sin errores.");

        System.out.println("\n===== FIN DE LA PRUEBA RESEÑA =====");
    }
}