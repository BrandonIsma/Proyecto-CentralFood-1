package ec.edu.uce.proyectocentralfood.dominio;
import java.util.ArrayList;
public class localComida {
    private int idLocal;
    private String nombre;
    private String descripcion;
    private String horarioAtencion;

    // Relación uno a uno
    private ubicacion ubicacion;

    // Relaciones uno a muchos
    private ArrayList<plato> platos;
    private ArrayList<Resena> resenas;
    private ArrayList<categoriaGastronomica> categorias;

    // =========================
    // CONSTRUCTOR POR DEFECTO
    // =========================

    public localComida() {

        this.platos = new ArrayList<>();
        this.resenas = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    // =========================
    // CONSTRUCTOR CON PARÁMETROS
    // =========================

    public localComida(int idLocal, String nombre,
                       String descripcion, String horarioAtencion) {

        this.idLocal = idLocal;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horarioAtencion = horarioAtencion;

        this.platos = new ArrayList<>();
        this.resenas = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    // =========================
    // GETTERS Y SETTERS
    // =========================

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<plato> platos) {
        this.platos = platos;
    }

    public ArrayList<Resena> getReseñas() {
        return resenas;
    }

    public void setReseñas(ArrayList<Resena> reseñas) {
        this.resenas = reseñas;
    }

    public ArrayList<categoriaGastronomica> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<categoriaGastronomica> categorias) {
        this.categorias = categorias;
    }

    // =========================
    // MÉTODOS
    // =========================

    public void mostrarMenu() {
        System.out.println("Mostrando menú");
    }

    public void mostrarReseñas() {
        System.out.println("Mostrando reseñas");
    }

    public void agregarPlato() {
        System.out.println("Plato agregado");
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {
        return "localComida{" +
                "idLocal=" + idLocal +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", horarioAtencion='" + horarioAtencion + '\'' +
                ", ubicacion=" + ubicacion +
                ", platos=" + platos +
                ", reseñas=" + resenas +
                ", categorias=" + categorias +
                '}';
    }
}

