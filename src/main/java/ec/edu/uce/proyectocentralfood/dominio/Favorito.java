package ec.edu.uce.proyectocentralfood.dominio;

public class Favorito {

    private int idFavorito;
    private int fechaAgregado;


    private LocalComida local;

    // CONSTRUCTOR VACÍO
    public Favorito() {
        this.idFavorito = 0;
        this.fechaAgregado = 0;
        this.local = new LocalComida(); // Se inicializa para evitar NullPointer
    }

    // CONSTRUCTOR CON PARÁMETROS
    public Favorito(int idFavorito, int fechaAgregado, LocalComida local) {
        setIdFavorito(idFavorito);
        setFechaAgregado(fechaAgregado);
        setLocal(local);
    }

    public int getIdFavorito() { return idFavorito; }
    public boolean setIdFavorito(int idFavorito) {
        if (idFavorito > 0) { this.idFavorito = idFavorito; return true; }
        return false;
    }

    public int getFechaAgregado() { return fechaAgregado; }
    public boolean setFechaAgregado(int fechaAgregado) {
        if (fechaAgregado > 0) { this.fechaAgregado = fechaAgregado; return true; }
        return false;
    }

    public LocalComida getLocal() { return local; }
    public void setLocal(LocalComida local) {
        if (local != null) { this.local = local; }
    }

    @Override
    public String toString() {
        String nombreLocal = (local != null) ? local.getNombre() : "Ninguno";
        return "Favorito [" +
                "ID: " + idFavorito +
                " | Local Guardado: " + nombreLocal +
                " | Fecha: " + fechaAgregado +
                ']';
    }
}