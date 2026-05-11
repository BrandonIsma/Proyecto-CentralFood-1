package ec.edu.uce.proyectocentralfood.dominio;
import java.util.ArrayList;
public class usuarioFinal {
    private int telefono;

    // Relaciones uno a muchos
    private ArrayList<Resena> resenas;
    private ArrayList<favorito> favoritos;

    // Relación uno a uno
    private puntoReferenciaUniversitario puntoReferencia;

    // =========================
    // CONSTRUCTOR POR DEFECTO
    // =========================

    public usuarioFinal() {

        super();

        this.resenas = new ArrayList<>();
        this.favoritos = new ArrayList<>();
    }

    // =========================
    // CONSTRUCTOR CON PARÁMETROS
    // =========================

    public usuarioFinal(int telefono) {

        super();

        this.telefono = telefono;

        this.resenas = new ArrayList<>();
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

    public ArrayList<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(ArrayList<Resena> reseñas) {
        this.resenas = reseñas;
    }

    public ArrayList<favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ArrayList<favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public puntoReferenciaUniversitario getPuntoReferencia() {
        return puntoReferencia;
    }

    public void setPuntoReferencia(puntoReferenciaUniversitario puntoReferencia) {
        this.puntoReferencia = puntoReferencia;
    }

    // =========================
    // MÉTODOS
    // =========================

    public void crearResena() {
        System.out.println("Reseña creada");
    }

    public void actualizarResena() {
        System.out.println("Reseña actualizada");
    }

    public void eliminarResena() {
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
                ", reseñas=" + resenas +
                ", favoritos=" + favoritos +
                ", puntoReferencia=" + puntoReferencia +
                '}';
    }
}

