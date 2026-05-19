package ec.edu.uce.proyectocentralfood.util;

import ec.edu.uce.proyectocentralfood.dominio.CuentaAdministrador;

public class TestCuentaAdministrador {

    public static void main(String[] args) {

        System.out.println("--- TEST CUENTA ADMINISTRADOR ---");

        CuentaAdministrador administrador = new CuentaAdministrador(
                "ADM-001"
        );

        // PRUEBA CÓDIGO ADMINISTRADOR
        System.out.print("Prueba código administrador: ");
        if ("ADM-001".equals(administrador.getCodigoAdministrador())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA ACTUALIZACIÓN
        administrador.setCodigoAdministrador("ADM-002");

        System.out.print("Prueba actualización código administrador: ");
        if ("AD7-002".equals(administrador.getCodigoAdministrador())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // EJECUCIÓN DE MÉTODOS DEL DIAGRAMA
        administrador.crearCategoria();
        administrador.actualizarCategoria();
        administrador.eliminarCategoria();

        administrador.crearPuntoReferencia();
        administrador.actualizarPuntoReferencia();
        administrador.eliminarPuntoReferencia();

        administrador.crearLocal();
        administrador.actualizarLocal();
        administrador.eliminarLocal();

        administrador.crearPlato();
        administrador.actualizarPlato();
        administrador.eliminarPlato();

        administrador.moderarResena();
        administrador.gestionarUsuario();

        System.out.println("Prueba métodos de gestión: PASÓ ✔");

        System.out.println("\nDATOS DE LA CUENTA ADMINISTRADOR:");
        System.out.println(administrador);

        System.out.println("--- FIN TEST CUENTA ADMINISTRADOR ---");
    }
}