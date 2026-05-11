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

