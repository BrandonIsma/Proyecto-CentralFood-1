package ec.edu.uce.proyectocentralfood.dominio;

public class categoriaGastronomica {

    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private String tipoComida;

    // Constructor vacío
    public categoriaGastronomica() {
    }

    // Constructor con parámetros
    public categoriaGastronomica(int idCategoria,
                                 String nombreCategoria,
                                 String descripcion,
                                 String tipoComida) {

        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.tipoComida = tipoComida;
    }

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

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    // Métodos

    public void mostrarCategoria() {
        System.out.println("Categoría gastronómica: " + nombreCategoria);
    }

    public void actualizarCategoria() {
        System.out.println("La categoría ha sido actualizada.");
    }

    @Override
    public String toString() {
        return "CategoriaGastronomica{" +
                "idCategoria=" + idCategoria +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipoComida='" + tipoComida + '\'' +
                '}';
    }
}