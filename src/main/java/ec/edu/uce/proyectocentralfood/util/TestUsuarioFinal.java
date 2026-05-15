package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.UsuarioFinal;

public class TestUsuarioFinal {

    public static void main(String[] args) {

        System.out.println("--- TEST USUARIO FINAL ---");

        UsuarioFinal usuario = new UsuarioFinal(
                1,
                "Brandon"
        );

        System.out.print("Prueba ID usuario: ");
        if (usuario.getIdUsuario() == 1) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }


        System.out.print("Prueba nombre: ");
        if ("Brandon".equals(usuario.getNombre())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        usuario.setIdUsuario(2);
        usuario.setNombre("Ismael");

        System.out.print("Prueba actualización ID usuario: ");
        if (usuario.getIdUsuario() == 2) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.print("Prueba actualización nombre: ");
        if ("Ismael".equals(usuario.getNombre())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DEL USUARIO FINAL:");
        System.out.println(usuario);

        System.out.println("--- FIN TEST USUARIO FINAL ---");
    }
}
