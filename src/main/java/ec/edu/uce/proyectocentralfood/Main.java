package ec.edu.uce.proyectocentralfood;

import ec.edu.uce.proyectocentralfood.interfaz.MenuConsola;

/**
 * Clase principal y punto de entrada para el sistema Central Food.
 */
public class Main {

    public static void main(String[] args) {

        try {
            // Instanciamos el menú que ya contiene toda la nueva lógica
            MenuConsola menu = new MenuConsola();

            // Iniciamos el ciclo de vida de la aplicación
            menu.iniciar();

        } catch (Exception e) {
            System.err.println("\n[✖] ERROR CRÍTICO: Ocurrió un problema inesperado al ejecutar la aplicación.");
            e.printStackTrace();
        }
    }
}