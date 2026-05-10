package ec.edu.uce.proyectocentralfood.dominio;

public class ubicacion {
    private int idUbicacion;
    private String direccion;
    private double latitud;
    private double longitud;
    private String referenciaTextual;

    // Relación uno a uno
    private localComida local;

    // =========================
    // CONSTRUCTOR POR DEFECTO
    // =========================

    public ubicacion() {

    }

    // =========================
    // CONSTRUCTOR CON PARÁMETROS
    // =========================

    public ubicacion(int idUbicacion, String direccion,
                     double latitud, double longitud,
                     String referenciaTextual) {

        this.idUbicacion = idUbicacion;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.referenciaTextual = referenciaTextual;
    }

    // =========================
    // GETTERS Y SETTERS
    // =========================

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getReferenciaTextual() {
        return referenciaTextual;
    }

    public void setReferenciaTextual(String referenciaTextual) {
        this.referenciaTextual = referenciaTextual;
    }

    public localComida getLocal() {
        return local;
    }

    public void setLocal(localComida local) {
        this.local = local;
    }

    // =========================
    // MÉTODOS
    // =========================

    public void calcularDistancia() {
        System.out.println("Calculando distancia...");
    }

    public void validarCoordenadas() {
        System.out.println("Validando coordenadas...");
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {
        return "Ubicacion{" +
                "idUbicacion=" + idUbicacion +
                ", direccion='" + direccion + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", referenciaTextual='" + referenciaTextual + '\'' +
                ", local=" + local +
                '}';
    }
}
