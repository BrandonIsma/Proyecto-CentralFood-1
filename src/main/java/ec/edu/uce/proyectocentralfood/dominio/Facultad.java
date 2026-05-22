package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;

public class Facultad {

    // Atributos
    private String nombre;
    private String descripcion;

    // RELACIÓN: Una facultad tiene una ubicación asignada (Relación 1 a 1)
    private Ubicacion ubicacion;

    // CONSTRUCTOR VACÍO
    public Facultad() {
    }

    // CONSTRUCTOR CON PARÁMETROS
    public Facultad(String nombre, String descripcion, Ubicacion ubicacion) {
        setNombre(nombre);
        setDescripcion(descripcion);
        setUbicacion(ubicacion);
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        // Usa tu método exacto del Validador
        if (Validador.esNombreFacultadValido(nombre)) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean setDescripcion(String descripcion) {
        // Usa tu método exacto del Validador
        if (Validador.esDescripcionFacultadValida(descripcion)) {
            this.descripcion = descripcion;
            return true;
        }
        return false;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public boolean setUbicacion(Ubicacion ubicacion) {
        if (ubicacion != null) {
            this.ubicacion = ubicacion;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Facultad [" +
                "Nombre: '" + nombre + '\'' +
                " | Descripción: '" + descripcion + '\'' +
                " | Ubicación: " + (ubicacion != null ? ubicacion.getDireccion() : "No asignada") +
                ']';
    }
}