package ec.edu.uce.proyectocentralfood.util;
import ec.edu.uce.proyectocentralfood.dominio.Plato;
public class TestPlato {
    public static void main(String[] args) {

        System.out.println("--- TEST PLATO ---");

        Plato plato = new Plato(
                1,
                "Seco de pollo",
                "Almuerzo",
                "Plato con arroz, pollo y ensalada.",
                2.50,
                20260515
        );

        // PRUEBA ID PLATO
        System.out.print("Prueba ID plato: ");
        if (plato.getIdPlato() == 1) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA NOMBRE
        System.out.print("Prueba nombre: ");
        if ("Seco de pollo".equals(plato.getNombre())) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA CATEGORÍA
        System.out.print("Prueba categoría: ");
        if ("Almuerzo".equals(plato.getCategoria())) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA DESCRIPCIÓN
        System.out.print("Prueba descripción: ");
        if ("Plato con arroz, pollo y ensalada.".equals(plato.getDescripcion())) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA PRECIO
        System.out.print("Prueba precio: ");
        if (plato.getPrecio() == 2.50) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA FECHA ACTUALIZACIÓN
        System.out.print("Prueba fecha actualización: ");
        if (plato.getFechaActualizacion() == 20260515) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ACTUALIZACIÓN DE DATOS
        plato.setNombre("Encebollado");
        plato.setCategoria("Desayuno");
        plato.setDescripcion("Sopa tradicional con pescado y yuca.");
        plato.setPrecio(3.00);
        plato.setFechaActualizacion(20260516);

        System.out.print("Prueba actualización nombre: ");
        if ("Encebollado".equals(plato.getNombre())) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización precio: ");
        if (plato.getPrecio() == 3.00) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DEL PLATO:");
        System.out.println(plato);

        System.out.println("--- FIN TEST PLATO ---");
    }
}
