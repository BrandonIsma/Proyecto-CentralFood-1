package ec.edu.uce.proyectocentralfood.util;
import ec.edu.uce.proyectocentralfood.dominio.Favorito;

public class TestFavorito {
    public static void main(String[] args) {

        System.out.println("--- TEST FAVORITO ---");

        Favorito favorito = new Favorito(
                1,
                10,
                5,
                20260515
        );

        // PRUEBA ID FAVORITO
        System.out.print("Prueba ID favorito: ");
        if (favorito.getIdFavorito() == 1) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ID USUARIO
        System.out.print("Prueba ID usuario: ");
        if (favorito.getIdUsuario() == 10) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ID LOCAL
        System.out.print("Prueba ID local: ");
        if (favorito.getIdLocal() == 5) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA FECHA AGREGADO
        System.out.print("Prueba fecha agregado: ");
        if (favorito.getFechaAgregado() == 20260515) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ACTUALIZACIÓN DE DATOS
        favorito.setIdFavorito(2);
        favorito.setIdUsuario(20);
        favorito.setIdLocal(8);
        favorito.setFechaAgregado(20260516);

        System.out.print("Prueba actualización ID favorito: ");
        if (favorito.getIdFavorito() == 2) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización ID local: ");
        if (favorito.getIdLocal() == 8) {
            System.out.println("PASÓ ✔️");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DEL FAVORITO:");
        System.out.println(favorito);

        System.out.println("--- FIN TEST FAVORITO ---");
    }
}
