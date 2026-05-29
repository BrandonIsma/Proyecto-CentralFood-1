package ec.edu.uce.proyectocentralfood;

import ec.edu.uce.proyectocentralfood.interfaz.MenuConsola;

/**
 * Clase principal y punto de entrada para el sistema Central Food.
 */
public class Main {

    public static void main(String[] args) {
        // Mensajes de inicialización del sistema
        System.out.println("[i] Iniciando el Sistema Central Food...");
        System.out.println("[i] Cargando base de datos en memoria y motores de validación...");

        try {

            MenuConsola menu = new MenuConsola();


            menu.iniciar();

        } catch (Exception e) {
            System.err.println("\n[✖] ERROR CRÍTICO: Ocurrió un problema inesperado al ejecutar la aplicación.");
            e.printStackTrace();
        }
    }
}