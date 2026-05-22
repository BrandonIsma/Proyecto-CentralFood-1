package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;
import java.util.Date;

public class Resena {

    private int idResena;
    private int calificacion;
    private String comentario;
    private Date fechaCreacion;

    // RELACIONES: Es dada por un UsuarioFinal y la recibe un LocalComida
    private UsuarioFinal usuario;
    private LocalComida localComida;

    // CONSTRUCTOR VACÍO
    public Resena() {
    }

    // CONSTRUCTOR CON PARÁMETROS ORIGINALES
    public Resena(int idResena, int calificacion, String comentario, Date fechaCreacion) {
        setIdResena(idResena);
        setCalificacion(calificacion);
        setComentario(comentario);
        setFechaCreacion(fechaCreacion);
    }

    // GETTERS Y SETTERS CON VALIDACIÓN

    public int getIdResena() {
        return idResena;
    }

    public boolean setIdResena(int idResena) {
        if (Validador.esIdResenaValido(idResena)) {
            this.idResena = idResena;
            return true;
        }
        return false;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public boolean setCalificacion(int calificacion) {
        if (Validador.esCalificacionValida(calificacion)) {
            this.calificacion = calificacion;
            return true;
        }
        return false;
    }

    // --- GETTER Y SETTER PARA COMENTARIO ---
    public String getComentario() {
        return comentario;
    }

    public boolean setComentario(String comentario) {
        if (Validador.esComentarioResenaValido(comentario)) {
            this.comentario = comentario;
            return true;
        }
        return false;
    }
    // -----------------------------------------------------

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public boolean setFechaCreacion(Date fechaCreacion) {
        if (Validador.esFechaCreacionValida(fechaCreacion)) {
            this.fechaCreacion = fechaCreacion;
            return true;
        }
        return false;
    }

    // GETTERS Y SETTERS DE LAS RELACIONES

    public UsuarioFinal getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioFinal usuario) {
        this.usuario = usuario;
    }

    public LocalComida getLocalComida() {
        return localComida;
    }

    public void setLocalComida(LocalComida localComida) {
        this.localComida = localComida;
    }

    // TOSTRING
    @Override
    public String toString() {
        String nombreUsuario = (usuario != null) ? usuario.getNombre() : "Anónimo";
        String nombreLocal = (localComida != null) ? localComida.getNombre() : "No asignado";
        return "Resena [" +
                "ID Resaña: " + idResena +
                " | Calificación: " + calificacion + "★" +
                " | Comentario: '" + comentario + '\'' +
                " | Usuario Autor: " + nombreUsuario +
                " | Local Reseñado: " + nombreLocal +
                ']';
    }
}