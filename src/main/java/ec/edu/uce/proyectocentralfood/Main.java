package ec.edu.uce.proyectocentralfood;

import ec.edu.uce.proyectocentralfood.interfaz.MenuConsola;

public class Main {
    public static void main(String[] args) {
        // Opcional: Un mensaje de bienvenida antes de cargar el menú
        System.out.println("Cargando el sistema CentralFood...");

        // Instanciamos el menú de la consola
        MenuConsola menu = new MenuConsola();


        menu.iniciar();
    }
}
