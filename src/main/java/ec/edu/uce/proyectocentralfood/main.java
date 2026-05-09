package ec.edu.uce.proyectocentralfood;

import ec.edu.uce.proyectocentralfood.dominio.cuenta;
import ec.edu.uce.proyectocentralfood.dominio.favorito;

import java.util.Date;
import java.util.GregorianCalendar;

public class main {

    public static void main(String[] args) {

        Date fechaNacimiento = new GregorianCalendar(2004, 5, 15).getTime();

        cuenta cuenta = new cuenta(
                1,
                "Brandon",
                "Tacuri",
                "brandon.tacuri@uce.edu.ec",
                fechaNacimiento
        );

        System.out.println(cuenta);

        cuenta.iniciarSesion();
        cuenta.consultarPerfil();
        cuenta.actualizarCredenciales();
        cuenta.cerrarSesion();
    }
}

package ec.edu.uce.proyectocentralfood;
import ec.edu.uce.proyectocentralfood.dominio.favorito;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        favorito miFav = new favorito();

        System.out.println("--- PRUEBA DE CLASE FAVORITO ---");

        // Probando la validación del ID
        System.out.print("Ingrese ID de usuario (Ej: USR-10): ");
        String idInput = sc.nextLine();
        miFav.set_id_usuario(idInput);

        // Modificando otros datos
        miFav.set_id_favorito("F001");
        miFav.set_id_local("Local_Facultad_Ingenieria");
        miFav.set_fecha_agregado("09/05/2026");

        // Obteniendo los datos para confirmar
        System.out.println("\nResumen del Favorito:");
        System.out.println("Usuario: " + miFav.get_id_usuario());
        System.out.println("Local: " + miFav.get_id_local());

        // Ejecutando métodos del diagrama
        miFav.agregarFavorito();
        miFav.mostrarFavoritos();
    }
}