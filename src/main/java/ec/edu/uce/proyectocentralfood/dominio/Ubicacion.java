package ec.edu.uce.proyectocentralfood.dominio;

public class Ubicacion {
    private String direccion;
    private double latitud;
    private double longitud;
    private String referenciaTextual;

    public Ubicacion(String direccion, double latitud, double longitud, String referenciaTextual) {
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.referenciaTextual = referenciaTextual;
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
    @Override
    public String toString() {
        return "Ubicacion{" +
                "direccion='" + direccion + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", referenciaTextual='" + referenciaTextual + '\'' +
                '}';
    }
}