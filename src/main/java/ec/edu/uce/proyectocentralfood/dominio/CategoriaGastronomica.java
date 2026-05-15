package ec.edu.uce.proyectocentralfood.dominio;

public class CategoriaGastronomica {

    // 1. Atributos privados
    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;

    // 2. Constructor por defecto
    public CategoriaGastronomica() {
    }

    // 3. Constructor con parámetros
    public CategoriaGastronomica(int idCategoria, String nombreCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
    }

    // 4. Métodos accesores (get) y modificadores (set)
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // 5. Método toString() para representar el objeto
    @Override
    public String toString() {
        return "CategoriaGastronomica [" +
                "ID: " + idCategoria +
                " | Nombre: '" + nombreCategoria + '\'' +
                " | Descripción: '" + descripcion + '\'' +
                ']';
    }
}