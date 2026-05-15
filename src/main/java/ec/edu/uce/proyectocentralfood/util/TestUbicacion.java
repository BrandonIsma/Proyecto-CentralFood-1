package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.Ubicacion;

public class TestUbicacion {

    public static void main(String[] args) {

        System.out.println("--- TEST UBICACIÓN ---");

        Ubicacion ubicacion = new Ubicacion(
                "Av. Universitaria y América",
                -0.1995,
                -78.5001,
                "Cerca de la entrada principal de la universidad."
        );

        System.out.print("Prueba dirección: ");
        if ("Av. Universitaria y América".equals(ubicacion.getDireccion())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba latitud: ");
        if (ubicacion.getLatitud() == -0.1995) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }


        System.out.print("Prueba longitud: ");
        if (ubicacion.getLongitud() == -78.5001) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }


        System.out.print("Prueba referencia textual: ");
        if ("Cerca de la entrada principal de la universidad.".equals(ubicacion.getReferenciaTextual())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }


        ubicacion.setDireccion("Facultad de Ingeniería");
        ubicacion.setReferenciaTextual("Frente al bloque principal.");

        System.out.print("Prueba actualización dirección: ");
        if ("Facultad de Ingeniería".equals(ubicacion.getDireccion())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización referencia: ");
        if ("Frente al bloque principal.".equals(ubicacion.getReferenciaTextual())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DE LA UBICACIÓN:");
        System.out.println(ubicacion);

        System.out.println("--- FIN TEST UBICACIÓN ---");
    }
}