package ec.edu.uce.proyectocentralfood;

import ec.edu.uce.proyectocentralfood.dominio.*;
import java.util.Date;
import java.util.Scanner;

public class main {
    private static Scanner sc = new Scanner(System.in);

    // --- INSTANCIACIÓN DE OBJETOS CON DATOS INICIALES ---
    private static categoriaGastronomica cat = new categoriaGastronomica(1, "Comida Rápida", "Snacks y bebidas", "Express");
    private static cuenta miCuenta = new cuenta(101, "Ariel", "García", "ariel.garcia@uce.edu.ec", new Date());
    private static cuentaAdministrador adminPoder = new cuentaAdministrador("ADM-UCE-2026");
    private static favorito miFav = new favorito("FAV-99", "USR-500", "Facultad de Economía", "12/05/2026", "12/05/2026");
    private static plato miPlato = new plato("PLT-123", "Encebollado", "Tradicional", 3.50, "Pescado con yuca y cebolla", "12/05/2026");
    private static puntoReferenciaUniversitario puntoRef = new puntoReferenciaUniversitario(5, "Pileta UCE", "Punto central del campus");
    private static Resena miResena = new Resena(1, 5, "Muy buena sazón", new Date(), "Pendiente");
    private static ubicacion miUbi = new ubicacion(20, "Entrada Gato Soberón", -0.198, -78.502, "Junto al coliseo");
    private static usuarioFinal userFinal = new usuarioFinal(987654321, 500);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEMA INTEGRAL CENTRAL FOOD - UCE  ");
            System.out.println("========================================");
            System.out.println("1. INGRESAR COMO ADMINISTRADOR");
            System.out.println("2. INGRESAR COMO USUARIO (ESTUDIANTE)");
            System.out.println("3. SALIR");
            System.out.print("Seleccione rol: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1: menuAdministrador(); break;
                case 2: menuUsuario(); break;
            }
        } while (opcion != 3);
    }

    // --- PANEL DE ADMINISTRACIÓN ---
    private static void menuAdministrador() {
        int opt;
        do {
            System.out.println("\n--- GESTIÓN DE CLASES (ADMINISTRADOR) ---");
            System.out.println("1. Probar Clase: plato");
            System.out.println("2. Probar Clase: categoriaGastronomica");
            System.out.println("3. Probar Clase: cuentaAdministrador ");
            System.out.println("4. Probar Clase: puntoReferenciaUniversitario");
            System.out.println("5. Probar Clase: cuenta ");
            System.out.println("9. REGRESAR");
            System.out.print("Seleccione clase a probar: ");
            opt = leerEntero();

            switch (opt) {
                case 1: // FUNCIONALIDAD COMPLETA DE PLATO
                    System.out.println("\n[EJECUTANDO MÉTODOS DE LA CLASE PLATO]");
                    miPlato.crearPlato();
                    miPlato.consultarPlato();
                    miPlato.actualizarPlato("Encebollado Especial", "Tradicional", "Pescado con chifle y pan", "13/05/2026");
                    miPlato.actualizarPrecio(4.00, "14/05/2026");
                    miPlato.set_id_plato("PLT-999"); // Prueba de validación Regex
                    miPlato.consultarPlato();
                    miPlato.eliminarPlato();
                    break;

                case 2: // FUNCIONALIDAD CATEGORÍA
                    System.out.println("\n[EJECUTANDO MÉTODOS DE CATEGORIAGASTRONOMICA]");
                    cat.mostrarCategoria();
                    cat.actualizarCategoria();
                    System.out.println("Resumen: " + cat.toString());
                    break;

                case 3: // FUNCIONALIDAD CUENTA ADMINISTRADOR
                    System.out.println("\n[EJECUTANDO MÉTODOS DE CUENTAADMINISTRADOR]");
                    System.out.println("Admin Código: " + adminPoder.getCodigoAdministrador());
                    adminPoder.crearCategoria();
                    adminPoder.crearLocal();
                    adminPoder.crearPlato();
                    adminPoder.crearPuntoReferencia();
                    adminPoder.moderarResena();
                    adminPoder.gestionarUsuario();
                    adminPoder.eliminarPlato();
                    break;

                case 4: // FUNCIONALIDAD PUNTO REFERENCIA
                    System.out.println("\n[EJECUTANDO MÉTODOS DE PUNTOREFERENCIAUNIVERSITARIO]");
                    puntoRef.crearPuntoReferenciaUniversitaria();
                    puntoRef.consultarPuntoReferenciaUniversitaria();
                    puntoRef.actualizarPuntoReferenciaUniversitaria();
                    puntoRef.validarCoordenadas();
                    puntoRef.eliminarPuntoReferenciaUniversitaria();
                    break;

                case 5: // FUNCIONALIDAD CUENTA
                    System.out.println("\n[EJECUTANDO MÉTODOS DE CUENTA]");
                    miCuenta.iniciarSesion();
                    miCuenta.consultarPerfil();
                    miCuenta.actualizarCredenciales();
                    miCuenta.cerrarSesion();
                    break;
            }
        } while (opt != 9);
    }

    // --- PANEL DE USUARIO ---
    private static void menuUsuario() {
        int opt;
        do {
            System.out.println("\n--- GESTIÓN DE CLASES (USUARIO) ---");
            System.out.println("1. Probar Clase: usuarioFinal");
            System.out.println("2. Probar Clase: favorito");
            System.out.println("3. Probar Clase: Resena");
            System.out.println("4. Probar Clase: ubicacion");
            System.out.println("5. Ver Plato (Consulta)");
            System.out.println("9. REGRESAR");
            System.out.print("Seleccione clase a probar: ");
            opt = leerEntero();

            switch (opt) {
                case 1: // FUNCIONALIDAD USUARIO FINAL
                    System.out.println("\n[EJECUTANDO MÉTODOS DE USUARIOFINAL]");
                    userFinal.agregarFavorito();
                    userFinal.crearResena();
                    userFinal.actualizarResena();
                    userFinal.consultarFavorito();
                    userFinal.eliminarFavorito();
                    userFinal.eliminarResena();
                    break;

                case 2: // FUNCIONALIDAD FAVORITO
                    System.out.println("\n[EJECUTANDO MÉTODOS DE FAVORITO]");
                    miFav.agregarFavorito();
                    miFav.set_id_usuario("USR-777"); // Prueba de validación Regex
                    miFav.actualizarFavorito("Comedor Facultad de Artes", "15/05/2026");
                    miFav.consultarFavorito();
                    miFav.eliminarFavorito();
                    break;

                case 3: // FUNCIONALIDAD RESEÑA
                    System.out.println("\n[EJECUTANDO MÉTODOS DE RESENA]");
                    miResena.crearResena();
                    miResena.validarContenido();
                    miResena.consultarResena();
                    miResena.actualizarResena();
                    miResena.marcarComoInvalida();
                    miResena.eliminarResena();
                    break;

                case 4: // FUNCIONALIDAD UBICACIÓN
                    System.out.println("\n[EJECUTANDO MÉTODOS DE UBICACION]");
                    System.out.println(miUbi.toString());
                    miUbi.validarCoordenadas();
                    miUbi.calcularDistancia();
                    break;

                case 5: // VISTA DE PLATO PARA EL USUARIO
                    System.out.println("\n[VISTA DE CONSULTA]");
                    miPlato.consultarPlato();
                    break;
            }
        } while (opt != 9);
    }

    private static int leerEntero() {
        try {
            int n = sc.nextInt();
            sc.nextLine();
            return n;
        } catch (Exception e) {
            sc.nextLine();
            return -1;
        }
    }
}