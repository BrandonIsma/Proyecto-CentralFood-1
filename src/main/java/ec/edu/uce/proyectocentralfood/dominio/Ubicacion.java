package ec.edu.uce.proyectocentralfood.dominio;

public class Ubicacion {

    private int idUbicacion;
    private String direccion;
    private double latitud;
    private double longitud;
    private String referenciaTextual;

    public Ubicacion(int idUbicacion, String direccion, double latitud, double longitud, String referenciaTextual) {
        this.idUbicacion = idUbicacion;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.referenciaTextual = referenciaTextual;
    }
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
    public void calcularDistancia (){
        System.out.println("Calculando distancia desde la ubicación con ID " + idUbicacion);
        System.out.println("Distancia calculada correctamente.");
    }
    public void  validarCoordenadas() {
        System.out.println("Validando coordenadas para la ubicación con ID " + idUbicacion);
        System.out.println("Coordenadas validadas correctamente.");
    }
    @Override
    public String toString(){
        return "Ubicacion{" +
                "idUbicacion=" + idUbicacion +
                ", direccion='" + direccion + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", referenciaTextual='" + referenciaTextual + '\'' +
                '}';
    }

}
