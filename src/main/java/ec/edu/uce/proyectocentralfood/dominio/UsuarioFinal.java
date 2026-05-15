package ec.edu.uce.proyectocentralfood.dominio;

public class UsuarioFinal {
    private int idUsuario;
    private String nombre;

    // Método Constructor
    public UsuarioFinal(int idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    // Métodos Get y Set
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "UsuarioFinal{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + '}';

    }
}