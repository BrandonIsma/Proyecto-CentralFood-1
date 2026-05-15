package ec.edu.uce.proyectocentralfood.dominio;

import java.util.Date;

public class Resena {

    private int idResena;
    private int calificacion;
    private String comentario;
    private Date fechaCreacion;

    public Resena() {
    }

    public Resena(int idResena, int calificacion, String comentario, Date fechaCreacion) {
        this.idResena = idResena;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdResena() {
        return idResena;
    }

    public void setIdResena(int idResena) {
        this.idResena = idResena;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void crearResena() {
    }

    public void consultarResena() {
    }

    public void actualizarResena() {
    }

    public void eliminarResena() {
    }

    @Override
    public String toString() {
        return "Resena{" +
                "idResena=" + idResena +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}