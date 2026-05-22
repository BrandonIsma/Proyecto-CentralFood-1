package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;

public class Ubicacion {

    private String direccion;
    private double latitud;
    private double longitud;
    private String referenciaTextual;

    // RELACIONES: Se asocia a una Facultad y pertenece a un LocalComida
    private Facultad facultad;
    private LocalComida localComida;

    // CONSTRUCTOR VACÍO
    public Ubicacion() {
    }

    // CONSTRUCTOR CON PARÁMETROS ORIGINALES
    public Ubicacion(String direccion, double latitud, double longitud, String referenciaTextual) {
        setDireccion(direccion);
        setLatitud(latitud);
        setLongitud(longitud);
        setReferenciaTextual(referenciaTextual);
    }

    // GETTERS Y SETTERS CON VALIDACIÓN

    public String getDireccion() {
        return direccion;
    }

    public boolean setDireccion(String direccion) {
        if (Validador.esDireccionValida(direccion)) {
            this.direccion = direccion;
            return true;
        }
        return false;
    }

    public double getLatitud() {
        return latitud;
    }

    public boolean setLatitud(double latitud) {
        if (Validador.esLatitudValida(latitud)) {
            this.latitud = latitud;
            return true;
        }
        return false;
    }

    public double getLongitud() {
        return longitud;
    }

    public boolean setLongitud(double longitud) {
        if (Validador.esLongitudValida(longitud)) {
            this.longitud = longitud;
            return true;
        }
        return false;
    }

    public String getReferenciaTextual() {
        return referenciaTextual;
    }

    public boolean setReferenciaTextual(String referenciaTextual) {
        if (Validador.esReferenciaTextualValida(referenciaTextual)) {
            this.referenciaTextual = referenciaTextual;
            return true;
        }
        return false;
    }

    // GETTERS Y SETTERS DE LAS RELACIONES

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public LocalComida getLocalComida() {
        return localComida;
    }

    public void setLocalComida(LocalComida localComida) {
        this.localComida = localComida;
    }

    // TOSTRING ACTUALIZADO
    @Override
    public String toString() {
        String nombreFacultad = (facultad != null) ? facultad.getNombre() : "No asociada a facultad";
        String nombreLocal = (localComida != null) ? localComida.getNombre() : "No asignado a local";
        return "Ubicacion [" +
                "Dirección: '" + direccion + '\'' +
                " | Coordenadas: (" + latitud + ", " + longitud + ")" +
                " | Ref: '" + referenciaTextual + '\'' +
                " | Campus/Facultad: " + nombreFacultad +
                " | Local: " + nombreLocal +
                ']';
    }
}