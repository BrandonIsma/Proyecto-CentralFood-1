package ec.edu.uce.proyectocentralfood.dominio;

public class CategoriaGastronomica {

    // Atributos
    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;

    // CONSTRUCTOR VACÍO (Inicializado)
    public CategoriaGastronomica() {
        this.idCategoria = 0;
        this.nombreCategoria = "Sin nombre";
        this.descripcion = "Sin descripción";
    }

    // CONSTRUCTOR CON PARÁMETROS
    public CategoriaGastronomica(int idCategoria, String nombreCategoria, String descripcion) {
        setIdCategoria(idCategoria);
        setNombreCategoria(nombreCategoria);
        setDescripcion(descripcion);
    }

    // MÉTODOS ACCESORES Y MODIFICADORES (Validaciones de fondo)
    public int getIdCategoria() {
        return idCategoria;
    }

    public boolean setIdCategoria(int idCategoria) {
        if (idCategoria > 0) {
            this.idCategoria = idCategoria;
            return true;
        }
        return false;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public boolean setNombreCategoria(String nombreCategoria) {
        if (nombreCategoria != null && !nombreCategoria.trim().isEmpty()) {
            this.nombreCategoria = nombreCategoria;
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

    @Override
    public String toString() {
        return "CategoriaGastronomica [" +
                "ID: " + idCategoria +
                " | Nombre: '" + nombreCategoria + '\'' +
                " | Descripción: '" + descripcion + '\'' +
                ']';
    }
}