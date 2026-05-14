package ec.edu.uce.proyectocentralfood.dominio;
import ec.edu.uce.proyectocentralfood.dominio.cuenta;

import java.util.Date;

public class usuarioFinal extends cuenta {

    private int idUsuario = getIdPersona();

    public usuarioFinal() {}

    public usuarioFinal( int idPersona,
                         String nombre,
                         String apellido,
                         String correo,
                         Date fechaNacimiento,
                         int telefono) {

        super(idPersona, nombre, apellido, correo, fechaNacimiento, telefono);

    }

    public void crearResena(){
        System.out.println("Ingrese su reseña: "+ idUsuario);
        System.out.println("Reseña creada correctamente.");
    }
    public void actualizarResena(){
        System.out.println("Actualizando reseña del usuario con ID " + idUsuario);
        System.out.println("Reseña actualizada correctamente.");
    }
    public void eliminarResena(){
        System.out.println("Reseña del usuario con ID " + idUsuario + " ha sido eliminada.");
        System.out.println("Reseña eliminada correctamente.");
    }
    public void agregarFavorito(){
        System.out.println("Agregando favorito para el usuario con ID " + idUsuario);
        System.out.println("Favorito agregado correctamente.");
    }
    public void consultarFavorito(){
        System.out.println("Consultar favorito para el usuario con ID " + idUsuario);
        System.out.println("Favorito consultado correctamente.");
    }
    public void eliminarFavorito(){
        System.out.println("Eliminando favorito para el usuario con ID " + idUsuario);
        System.out.println("Favorito eliminado correctamente.");
    }
        @Override
    public String toString() {
        return "Usuario final: " + idUsuario;
    }
}
