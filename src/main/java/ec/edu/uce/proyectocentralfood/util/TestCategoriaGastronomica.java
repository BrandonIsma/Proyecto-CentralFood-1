package ec.edu.uce.proyectocentralfood.util;
import ec.edu.uce.proyectocentralfood.dominio.CategoriaGastronomica;
public class TestCategoriaGastronomica {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO TEST DE CATEGORIA GASTRONOMICA ===");
//
        // 1. Instancia mediante constructor con parámetros
        CategoriaGastronomica cat1 = new CategoriaGastronomica(10, "Almuerzos", "Comida completa del dia");

        // 2. Instancia mediante constructor vacío y setters
        CategoriaGastronomica cat2 = new CategoriaGastronomica();
        cat2.setIdCategoria(20);
        cat2.setNombreCategoria("Desayunos");
        cat2.setDescripcion("Opciones matutinas nutritivas");

        // 3. Prueba de VALIDACIÓN (Intentar meter datos incorrectos)
        CategoriaGastronomica catError = new CategoriaGastronomica();
        catError.setIdCategoria(99);
        catError.setNombreCategoria("Plat0_Mal0"); // Contiene número, debería fallar en el validador
        catError.setDescripcion("Error @#$%");    // Contiene símbolos

        // 4. Mostrar resultados usando el método toString()
        System.out.println("\n[PRUEBA 1 - Constructor]: " + cat1.toString());
        System.out.println("[PRUEBA 2 - Setters]: " + cat2.toString());
        System.out.println("[PRUEBA 3 - Error de Validación]: " + catError.toString());

        System.out.println("\n=== TEST FINALIZADO CORRECTAMENTE ===");
    }
}
