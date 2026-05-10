package ec.edu.uce.proyectocentralfood.dominio;
import java.util.ArrayList;
public class puntoReferenciaUniversitario {
    private int idPuntoReferencia;
    private String nombre;
    private String descripcion;

    // Relación uno a muchos
    private ArrayList<usuarioFinal> usuarios;

    // =========================
    // CONSTRUCTOR POR DEFECTO
    // =========================

    public puntoReferenciaUniversitario() {

        this.usuarios = new ArrayList<>();
    }

    // =========================
    // CONSTRUCTOR CON PARÁMETROS
    // =========================

    public puntoReferenciaUniversitario(int idPuntoReferencia,
                                        String nombre,
                                        String descripcion) {

        this.idPuntoReferencia = idPuntoReferencia;
        this.nombre = nombre;
        this.descripcion = descripcion;

        this.usuarios = new ArrayList<>();
    }

    // =========================
    // GETTERS Y SETTERS
    // =========================

    public int getIdPuntoReferencia() {
        return idPuntoReferencia;
    }

    public void setIdPuntoReferencia(int idPuntoReferencia) {
        this.idPuntoReferencia = idPuntoReferencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<usuarioFinal> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<usuarioFinal> usuarios) {
        this.usuarios = usuarios;
    }

    // =========================
    // MÉTODOS
    // =========================

    public void mostrarPuntoReferencia() {
        System.out.println("Mostrando punto de referencia");
    }

    public void actualizarPuntoReferencia() {
        System.out.println("Punto de referencia actualizado");
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {
        return "puntoReferenciaUniversitaria{" +
                "idPuntoReferencia=" + idPuntoReferencia +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}