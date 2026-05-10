package ec.edu.uce.proyectocentralfood.dominio;

import java.util.ArrayList;

public class cuentaAdministrador {
    private String codigoAdministrador;

    // Relaciones uno a muchos
    private ArrayList<Resena> resenasModeradas;
    private ArrayList<localComida> locales;
    private ArrayList<plato> platos;
    private ArrayList<categoriaGastronomica> categorias;
    private ArrayList<puntoReferenciaUniversitario> puntosReferencia;

    // =========================
    // CONSTRUCTOR POR DEFECTO
    // =========================

    public cuentaAdministrador() {

        super();

        this.resenasModeradas = new ArrayList<>();
        this.locales = new ArrayList<>();
        this.platos = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.puntosReferencia = new ArrayList<>();
    }

    // =========================
    // CONSTRUCTOR CON PARÁMETROS
    // =========================

    public cuentaAdministrador(String codigoAdministrador) {

        super();

        this.codigoAdministrador = codigoAdministrador;

        this.resenasModeradas = new ArrayList<>();
        this.locales = new ArrayList<>();
        this.platos = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.puntosReferencia = new ArrayList<>();
    }

    // =========================
    // GETTERS Y SETTERS
    // =========================

    public String getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(String codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }

    public ArrayList<Resena> getResenasModeradas() {
        return resenasModeradas;
    }

    public void setResenasModeradas(ArrayList<Resena> reseñasModeradas) {
        this.resenasModeradas = reseñasModeradas;
    }

    public ArrayList<localComida> getLocales() {
        return locales;
    }

    public void setLocales(ArrayList<localComida> locales) {
        this.locales = locales;
    }

    public ArrayList<plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<plato> platos) {
        this.platos = platos;
    }

    public ArrayList<categoriaGastronomica> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<categoriaGastronomica> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<puntoReferenciaUniversitario> getPuntosReferencia() {
        return puntosReferencia;
    }

    public void setPuntosReferencia(ArrayList<puntoReferenciaUniversitario> puntosReferencia) {
        this.puntosReferencia = puntosReferencia;
    }

    // =========================
    // MÉTODOS
    // =========================

    public void crearCategoria() {
        System.out.println("Categoría creada");
    }

    public void actualizarCategoria() {
        System.out.println("Categoría actualizada");
    }

    public void eliminarCategoria() {
        System.out.println("Categoría eliminada");
    }

    public void crearPuntoReferencia() {
        System.out.println("Punto de referencia creado");
    }

    public void actualizarPuntoReferencia() {
        System.out.println("Punto de referencia actualizado");
    }

    public void eliminarPuntoReferencia() {
        System.out.println("Punto de referencia eliminado");
    }

    public void crearLocal() {
        System.out.println("Local creado");
    }

    public void actualizarLocal() {
        System.out.println("Local actualizado");
    }

    public void eliminarLocal() {
        System.out.println("Local eliminado");
    }

    public void crearPlato() {
        System.out.println("Plato creado");
    }

    public void actualizarPlato() {
        System.out.println("Plato actualizado");
    }

    public void eliminarPlato() {
        System.out.println("Plato eliminado");
    }

    public void moderarResena() {
        System.out.println("Reseña moderada");
    }

    public void gestionarUsuario() {
        System.out.println("Usuario gestionado");
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {
        return "cuentaAdministrador{" +
                "codigoAdministrador='" + codigoAdministrador + '\'' +
                ", reseñasModeradas=" + resenasModeradas +
                ", locales=" + locales +
                ", platos=" + platos +
                ", categorias=" + categorias +
                ", puntosReferencia=" + puntosReferencia +
                '}';
    }
}