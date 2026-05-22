package ec.edu.uce.proyectocentralfood.util;
import ec.edu.uce.proyectocentralfood.dominio.CategoriaGastronomica;
public class TestCategoriaGastronomica {
    public static void main(String[] args) {

        System.out.println("--- TEST CATEGORÍA GASTRONÓMICA ---");

        CategoriaGastronomica categoria = new CategoriaGastronomica(
                1,
                "Almuerzos",
                "Opciones de almuerzo para estudiantes."
        );

        // PRUEBA ID CATEGORÍA
        System.out.print("Prueba ID categoría: ");
        if (categoria.getIdCategoria() == 1) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA NOMBRE CATEGORÍA
        System.out.print("Prueba nombre categoría: ");
        if ("Almuerzos".equals(categoria.getNombreCategoria())) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA DESCRIPCIÓN
        System.out.print("Prueba descripción: ");
        if ("Opciones de almuerzo para estudiantes.".equals(categoria.getDescripcion())) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ACTUALIZACIÓN DE DATOS
        categoria.setIdCategoria(2);
        categoria.setNombreCategoria("Desayunos");
        categoria.setDescripcion("Opciones de desayuno cerca de la universidad.");

        System.out.print("Prueba actualización ID categoría: ");
        if (categoria.getIdCategoria() == 2) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización nombre categoría: ");
        if ("Desayunos".equals(categoria.getNombreCategoria())) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DE LA CATEGORÍA:");
        System.out.println(categoria);

        System.out.println("--- FIN TEST CATEGORÍA GASTRONÓMICA ---");
    }
}
