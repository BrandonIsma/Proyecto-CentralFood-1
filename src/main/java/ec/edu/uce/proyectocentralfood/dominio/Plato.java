package ec.edu.uce.proyectocentralfood.dominio;

public class Plato {
    // 1. Atributos (Según diagrama de clases)
    private int idPlato;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;
    private int fechaActualizacion;

    // 2. Constructor por defecto
    public Plato() {}

    // 3. Constructor con parámetros
    public Plato(int idPlato, String nombre, String categoria, String descripcion, double precio, int fechaActualizacion) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaActualizacion = fechaActualizacion;
    }

    // 4. Métodos Accesores y Modificadores (Getters y Setters) Puros
    public int getIdPlato() { return idPlato; }
    public void setIdPlato(int idPlato) { this.idPlato = idPlato; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String get濃esripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(int fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }

    // 5. Método toString()
    @Override
    public String toString() {
        return "Plato [" +
                "ID: " + idPlato +
                " | Nombre: '" + nombre + '\'' +
                " | Categoría: '" + categoria + '\'' +
                " | Precio: $" + precio +
                " | Fecha: " + fechaActualizacion +
                ']';
    }
}
