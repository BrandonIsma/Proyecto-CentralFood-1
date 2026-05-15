package ec.edu.uce.proyectocentralfood.util;
import ec.edu.uce.proyectocentralfood.dominio.CuentaAdministrador;
public class TestCuentaAdministrador {

    public static void main(String[] args) {

        System.out.println("--- INICIANDO PRUEBAS DE ADMINISTRADOR ---");

        // 1. CREAR OBJETO
        // Asegúrate de que la clase CuentaAdministrador tenga un constructor que acepte un String
        CuentaAdministrador administrador = new CuentaAdministrador("ADM001");

        // 2. MOSTRAR OBJETO (Llama automáticamente al método toString)
        System.out.println("Estado inicial: " + administrador);

        // 3. USAR GET Y SET
        System.out.println("Código actual: " + administrador.getCodigoAdministrador());

        administrador.setCodigoAdministrador("ADM002");
        System.out.println("Código actualizado: " + administrador.getCodigoAdministrador());

        // 4. PRUEBA DE MÉTODOS DE GESTIÓN
        System.out.println("\nEjecutando acciones de gestión:");

        administrador.crearCategoria();
        administrador.actualizarCategoria();
        administrador.eliminarCategoria();

        System.out.println("--- Gestión de Puntos de Referencia ---");
        administrador.crearPuntoReferencia();
        administrador.actualizarPuntoReferencia();
        administrador.eliminarPuntoReferencia();

        System.out.println("--- Gestión de Locales ---");
        administrador.crearLocal();
        administrador.actualizarLocal();
        administrador.eliminarLocal();

        System.out.println("--- Gestión de Platos ---");
        administrador.crearPlato();
        administrador.actualizarPlato();
        administrador.eliminarPlato();

        System.out.println("--- Otras Funciones ---");
        administrador.moderarResena();
        administrador.gestionarUsuario();

        System.out.println("\n--- PRUEBAS FINALIZADAS CON ÉXITO ---");
    }
}