package ec.edu.uce.proyectocentralfood.dominio;

public class Plato {

    private int idPlato;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;
    private int fechaActualizacion;

    public Plato() {
    }

    public Plato(int idPlato, String nombre, String categoria, String descripcion, double precio, int fechaActualizacion) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(int fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "idPlato=" + idPlato +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }
}