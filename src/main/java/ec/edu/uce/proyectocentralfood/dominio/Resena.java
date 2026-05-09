package ec.edu.uce.proyectocentralfood.dominio;

import java.util.Date;

public class Resena {

    private int idResena;
    private int calificacion;
    private String comentario;
    private Date fechaCreacion;
    private String estadoResena;

    public Resena() {
    }
    public Resena(int idResena, int calificacion, String comentario, Date fechaCreacion, String estadoResena) {
        this.idResena = idResena;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaCreacion = fechaCreacion;
        this.estadoResena = estadoResena;
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
    public String getEstadoResena() {
        return estadoResena;
    }
    public void setEstadoResena(String estadoResena) {
        this.estadoResena = estadoResena;
    }
    public void crearResena() {
        System.out.println("Reseña creada correctamente.");
    }
    public void consultarResena() {
        System.out.println("Consultando reseña:");
        System.out.println("ID reseña: " + idResena);
        System.out.println("Calificación: " + calificacion);
        System.out.println("Comentario: " + comentario);
        System.out.println("Fecha de creación: " + fechaCreacion);
        System.out.println("Estado: " + estadoResena);
    }
    public void actualizarResena() {
        System.out.println("Reseña actualizada correctamente.");
    }
    public void eliminarResena() {
        System.out.println("Reseña eliminada correctamente.");
    }
    public void validarContenido() {
        if (comentario != null && !comentario.isBlank()) {
            System.out.println("El contenido de la reseña es válido.");
        } else {
            System.out.println("El contenido de la reseña no es válido.");
        }
    }
    public void marcarComoInvalida() {
        this.estadoResena = "Inválida";
        System.out.println("La reseña fue marcada como inválida.");
    }
    @Override
    public String toString() {
        return "Resena{" +
                "idResena=" + idResena +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estadoResena='" + estadoResena + '\'' +
                '}';
    }
}