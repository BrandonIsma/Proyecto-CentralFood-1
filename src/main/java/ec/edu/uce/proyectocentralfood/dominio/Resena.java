package ec.edu.uce.proyectocentralfood.dominio;

import java.util.Date;

public class Resena {

    private int idResena;
    private int calificacion;
    private String comentario;
    private Date fechaCreacion;

    private UsuarioFinal usuario;
    private LocalComida localComida;

    // CONSTRUCTOR VACÍO INICIALIZADO
    public Resena() {
        this.idResena = 0;
        this.calificacion = 5;
        this.comentario = "Sin comentario";
        this.fechaCreacion = new Date();
    }

    public Resena(int idResena, int calificacion, String comentario, Date fechaCreacion) {
        setIdResena(idResena);
        setCalificacion(calificacion);
        setComentario(comentario);
        setFechaCreacion(fechaCreacion);
    }

    public int getIdResena() { return idResena; }
    public boolean setIdResena(int idResena) {
        if (idResena > 0) { this.idResena = idResena; return true; }
        return false;
    }

    public int getCalificacion() { return calificacion; }
    public boolean setCalificacion(int calificacion) {
        if (calificacion >= 1 && calificacion <= 5) {
            this.calificacion = calificacion;
            return true;
        }
        return false;
    }

    public String getComentario() { return comentario; }
    public boolean setComentario(String comentario) {
        if (comentario != null && !comentario.trim().isEmpty()) {
            this.comentario = comentario;
            return true;
        }
        return false;
    }

    public Date getFechaCreacion() { return fechaCreacion; }
    public boolean setFechaCreacion(Date fechaCreacion) {
        if (fechaCreacion != null) { this.fechaCreacion = fechaCreacion; return true; }
        return false;
    }

    public UsuarioFinal getUsuario() { return usuario; }
    public void setUsuario(UsuarioFinal usuario) { this.usuario = usuario; }

    public LocalComida getLocalComida() { return localComida; }
    public void setLocalComida(LocalComida localComida) { this.localComida = localComida; }

    @Override
    public String toString() {
        String autor = (usuario != null) ? usuario.getNombre() : "Anónimo";
        return "Resena [ID: " + idResena + " | Calificación: " + calificacion + "★ | Comentario: '" + comentario + "' | Autor: " + autor + "]";
    }
}