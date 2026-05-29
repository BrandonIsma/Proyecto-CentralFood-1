package ec.edu.uce.proyectocentralfood.dominio;

public class Plato {

    private int idPlato;
    private String nombre;
    private String descripcion;
    private double precio;
    private int fechaActualizacion;

    // RELACIONES
    private CategoriaGastronomica categoriaGastro;
    private boolean esFavorito;

    // CONSTRUCTOR VACÍO
    public Plato() {
        this.idPlato = 0;
        this.nombre = "Sin nombre";
        this.descripcion = "Sin descripción";
        this.precio = 0.0;
        this.fechaActualizacion = 0;
        this.categoriaGastro = new CategoriaGastronomica();
        this.esFavorito = false;
    }

    // CONSTRUCTOR CON PARÁMETROS
    public Plato(int idPlato, String nombre, String descripcion, double precio, int fechaActualizacion, CategoriaGastronomica categoriaGastro) {
        setIdPlato(idPlato);
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setFechaActualizacion(fechaActualizacion);
        setCategoriaGastro(categoriaGastro);
    }

    // GETTERS Y SETTERS (Validación de fondo)
    public int getIdPlato() {
        return idPlato;
    }

    public boolean setIdPlato(int idPlato) {
        if (idPlato > 0) {
            this.idPlato = idPlato;
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
            return true;
        }
        return false;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
            return true;
        }
        return false;
    }

    public int getFechaActualizacion() {
        return fechaActualizacion;
    }

    public boolean setFechaActualizacion(int fechaActualizacion) {
        if (fechaActualizacion > 0) {
            this.fechaActualizacion = fechaActualizacion;
            return true;
        }
        return false;
    }

    public CategoriaGastronomica getCategoriaGastro() {
        return categoriaGastro;
    }

    public void setCategoriaGastro(CategoriaGastronomica categoriaGastro) {
        if (categoriaGastro != null) {
            this.categoriaGastro = categoriaGastro;
        }
    }

    public boolean isEsFavorito() {
        return esFavorito;
    }

    public void setEsFavorito(boolean esFavorito) {
        this.esFavorito = esFavorito;
    }

    @Override
    public String toString() {
        String nombreCat = (categoriaGastro != null) ? categoriaGastro.getNombreCategoria() : "No asignada";
        return "Plato [" +
                "ID: " + idPlato +
                " | Nombre: " + nombre +
                " | Precio: $" + precio +
                " | Categoría: " + nombreCat +
                ']';
    }
}