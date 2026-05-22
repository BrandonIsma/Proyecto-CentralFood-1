package ec.edu.uce.proyectocentralfood.dominio;
import ec.edu.uce.proyectocentralfood.util.Validador;
public class CategoriaGastronomica {
    // Atributos
    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;

    // RELACIONES: Una categoría tiene muchos platos y muchos locales de comida
    private Plato[] platos;
    private LocalComida[] locales;

    // Constructor vacío original
    public CategoriaGastronomica() {
    }

    // Constructor parametrizado inteligente (incluye los atributos originales y las relaciones)
    public CategoriaGastronomica(int idCategoria, String nombreCategoria, String descripcion, Plato[] platos, LocalComida[] locales) {
        setIdCategoria(idCategoria);
        setNombreCategoria(nombreCategoria);
        setDescripcion(descripcion);
        setPlatos(platos);
        setLocales(locales);
    }

    // Métodos accesores y modificadores booleanos validados
    public int getIdCategoria() {
        return idCategoria;
    }

    public boolean setIdCategoria(int idCategoria) {
        if (Validador.esIdCategoriaValido(idCategoria)) {
            this.idCategoria = idCategoria;
            return true;
        }
        return false;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public boolean setNombreCategoria(String nombreCategoria) {
        if (Validador.esNombreCategoriaValido(nombreCategoria)) {
            this.nombreCategoria = nombreCategoria;
            return true;
        }
        return false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean setDescripcion(String descripcion) {
        if (Validador.esDescripcionCategoriaValida(descripcion)) {
            this.descripcion = descripcion;
            return true;
        }
        return false;
    }

    public Plato[] getPlatos() {
        return platos;
    }

    public boolean setPlatos(Plato[] platos) {
        if (platos != null) {
            this.platos = platos;
            return true;
        }
        return false;
    }

    public LocalComida[] getLocales() {
        return locales;
    }

    public boolean setLocales(LocalComida[] locales) {
        if (locales != null) {
            this.locales = locales;
            return true;
        }
        return false;
    }

    // Método toString() original extendido con las nuevas relaciones
    @Override
    public String toString() {
        return "CategoriaGastronomica [" +
                "ID: " + idCategoria +
                " | Nombre: '" + nombreCategoria + '\'' +
                " | Descripción: '" + descripcion + '\'' +
                " | Cantidad de Platos: " + (platos != null ? platos.length : 0) +
                " | Cantidad de Locales: " + (locales != null ? locales.length : 0) +
                ']';
    }
}