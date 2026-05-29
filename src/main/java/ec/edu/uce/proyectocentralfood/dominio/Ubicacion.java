package ec.edu.uce.proyectocentralfood.dominio;

public class Ubicacion {

    private String direccion;
    private double latitud;
    private double longitud;
    private String referenciaTextual;

    private Facultad facultad;
    private LocalComida localComida;

    // CONSTRUCTOR VACÍO INICIALIZADO
    public Ubicacion() {
        this.direccion = "Sin dirección";
        this.latitud = 0.0;
        this.longitud = 0.0;
        this.referenciaTextual = "Sin referencia";
    }

    public Ubicacion(String direccion, double latitud, double longitud, String referenciaTextual) {
        setDireccion(direccion);
        setLatitud(latitud);
        setLongitud(longitud);
        setReferenciaTextual(referenciaTextual);
    }

    public String getDireccion() { return direccion; }
    public boolean setDireccion(String direccion) {
        if (direccion != null && !direccion.trim().isEmpty()) { this.direccion = direccion; return true; }
        return false;
    }

    public double getLatitud() { return latitud; }
    public boolean setLatitud(double latitud) {
        if (latitud >= -90 && latitud <= 90) { this.latitud = latitud; return true; }
        return false;
    }

    public double getLongitud() { return longitud; }
    public boolean setLongitud(double longitud) {
        if (longitud >= -180 && longitud <= 180) { this.longitud = longitud; return true; }
        return false;
    }

    public String getReferenciaTextual() { return referenciaTextual; }
    public boolean setReferenciaTextual(String referenciaTextual) {
        if (referenciaTextual != null && !referenciaTextual.trim().isEmpty()) { this.referenciaTextual = referenciaTextual; return true; }
        return false;
    }

    public Facultad getFacultad() { return facultad; }
    public void setFacultad(Facultad facultad) { this.facultad = facultad; }

    public LocalComida getLocalComida() { return localComida; }
    public void setLocalComida(LocalComida localComida) { this.localComida = localComida; }

    @Override
    public String toString() {
        return "Ubicacion [Dirección: '" + direccion + "' | Coordenadas: (" + latitud + ", " + longitud + ")]";
    }
}