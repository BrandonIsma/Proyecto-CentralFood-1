package ec.edu.uce.proyectocentralfood.dominio;

public class Facultad {

    private String nombre;
    private String descripcion;
    private Ubicacion ubicacion;

    // CONSTRUCTOR VACÍO INICIALIZADO
    public Facultad() {
        this.nombre = "Sin nombre";
        this.descripcion = "Sin descripción";
    }

    // CONSTRUCTORES ADAPTADOS AL MENÚ
    public String getNombre() { return nombre; }
    public Facultad(String nombre, String descripcion) {
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public Facultad(String nombre, String descripcion, Ubicacion ubicacion) {
        setNombre(nombre);
        setDescripcion(descripcion);
        setUbicacion(ubicacion);
    }

    public boolean setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) { this.nombre = nombre; return true; }
        return false;
    }

    public String getDescripcion() { return descripcion; }
    public boolean setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) { this.descripcion = descripcion; return true; }
        return false;
    }

    public Ubicacion getUbicacion() { return ubicacion; }
    public void setUbicacion(Ubicacion ubicacion) { this.ubicacion = ubicacion; }

    @Override
    public String toString() {
        return "Facultad [Nombre: '" + nombre + "' | Descripción: '" + descripcion + "']";
    }
}