package ec.edu.uce.proyectocentralfood;

import ec.edu.uce.proyectocentralfood.dominio.Resena;

import java.util.Date;

public class pruebaResena {

    public static void main(String[] args) {

        Resena resena = new Resena(
                1,
                5,
                "Muy buena comida y atención rápida.",
                new Date(),
                "Válida"
        );

        System.out.println(resena);

        resena.crearResena();
        resena.consultarResena();
        resena.validarContenido();
        resena.actualizarResena();
        resena.marcarComoInvalida();
        resena.consultarResena();
        resena.eliminarResena();
    }
}