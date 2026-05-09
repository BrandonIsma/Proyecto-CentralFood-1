package ec.edu.uce.proyectocentralfood.dominio;
import java.util.ArrayList;
public class UsuarioFinal {
    private int telefono;

    // Relaciones uno a muchos
    private ArrayList<Reseña> reseñas;
    private ArrayList<favorito> favoritos;

    // Relación uno a uno
    private puntoReferenciaUniversitaria puntoReferencia;

    // =========================
    // CONSTRUCTOR POR DEFECTO
    // =========================

    public UsuarioFinal() {

        super();

        this.reseñas = new ArrayList<>();
        this.favoritos = new ArrayList<>();
    }

    // =========================
    // CONSTRUCTOR CON PARÁMETROS
    // =========================

    public UsuarioFinal(int telefono) {

        super();

        this.telefono = telefono;

        this.reseñas = new ArrayList<>();
        this.favoritos = new ArrayList<>();
    }

    // =========================
    // GETTERS Y SETTERS
    // =========================

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Reseña> getReseñas() {
        return reseñas;
    }

    public void setReseñas(ArrayList<Reseña> reseñas) {
        this.reseñas = reseñas;
    }

    public ArrayList<favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ArrayList<favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public puntoReferenciaUniversitaria getPuntoReferencia() {
        return puntoReferencia;
    }

    public void setPuntoReferencia(puntoReferenciaUniversitaria puntoReferencia) {
        this.puntoReferencia = puntoReferencia;
    }

    // =========================
    // MÉTODOS
    // =========================

    public void crearReseña() {
        System.out.println("Reseña creada");
    }

    public void actualizarReseña() {
        System.out.println("Reseña actualizada");
    }

    public void eliminarReseña() {
        System.out.println("Reseña eliminada");
    }

    public void agregarFavorito() {
        System.out.println("Favorito agregado");
    }

    public void consultarFavoritos() {
        System.out.println("Consultando favoritos");
    }

    public void eliminarFavorito() {
        System.out.println("Favorito eliminado");
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {
        return "usuarioFinal{" +
                "telefono=" + telefono +
                ", reseñas=" + reseñas +
                ", favoritos=" + favoritos +
                ", puntoReferencia=" + puntoReferencia +
                '}';
    }
}

