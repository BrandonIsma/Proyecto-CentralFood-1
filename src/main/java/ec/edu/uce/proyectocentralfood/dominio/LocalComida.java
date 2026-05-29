package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;
import java.util.ArrayList;
import java.util.List;

public class LocalComida {

    // Los 7 atributos primitivos originales estrictos
    private int idLocal;
    private String nombre;
    private String descripcion;
    private String telefono;
    private String horarioAtencion;
    private String estadoLocal;
    private String rangoPrecio;

    // ATRIBUTOS DE RELACIÓN (Asociaciones y Agregaciones)
    private Ubicacion ubicacion;         // Tiene una ubicación
    private List<Plato> platos;          // Ofrece múltiples platos
    private List<Resena> resenas;        // Recibe múltiples reseñas

    // CONSTRUCTOR VACÍO (Inicializa las listas para evitar NullPointerException)
    public LocalComida() {
        this.platos = new ArrayList<>();
        this.resenas = new ArrayList<>();
    }

    // CONSTRUCTOR CON PARÁMETROS ORIGINALES
    public LocalComida(int idLocal, String nombre, String descripcion, String telefono,
                       String horarioAtencion, String estadoLocal, String rangoPrecio) {
        this(); // Llama al constructor vacío para inicializar las listas
        setIdLocal(idLocal);
        setNombre(nombre);
        setDescripcion(descripcion);
        setTelefono(telefono);
        setHorarioAtencion(horarioAtencion);
        setEstadoLocal(estadoLocal);
        setRangoPrecio(rangoPrecio);
    }

    // GETTERS Y SETTERS CON VALIDACIÓN (Atributos Primitivos)

    public int getIdLocal() {
        return idLocal;
    }

    public boolean setIdLocal(int idLocal) {
        if (Validador.esIdLocalValido(idLocal)) {
            this.idLocal = idLocal;
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if (Validador.esNombreLocalValido(nombre)) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean setDescripcion(String descripcion) {
        if (Validador.esDescripcionLocalValida(descripcion)) {
            this.descripcion = descripcion;
            return true;
        }
        return false;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean setTelefono(String telefono) {
        if (Validador.esTelefonoValido(telefono)) {
            this.telefono = telefono;
            return true;
        }
        return false;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public boolean setHorarioAtencion(String horarioAtencion) {
        if (Validador.esHorarioAtencionValido(horarioAtencion)) {
            this.horarioAtencion = horarioAtencion;
            return true;
        }
        return false;
    }

    public String getEstadoLocal() {
        return estadoLocal;
    }

    public boolean setEstadoLocal(String estadoLocal) {
        if (Validador.esEstadoLocalValido(estadoLocal)) {
            this.estadoLocal = estadoLocal;
            return true;
        }
        return false;
    }

    public String getRangoPrecio() {
        return rangoPrecio;
    }

    public boolean setRangoPrecio(String rangoPrecio) {
        if (Validador.esRangoPrecioValido(rangoPrecio)) {
            this.rangoPrecio = rangoPrecio;
            return true;
        }
        return false;
    }

    // GETTERS Y SETTERS DE LAS RELACIONES

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        if (platos != null) {
            this.platos = platos;
        }
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        if (resenas != null) {
            this.resenas = resenas;
        }
    }

    // MÉTODOS PARA GESTIONAR LAS RELACIONES INDIVIDUALMENTE

    public void agregarPlato(Plato plato) {
        if (plato != null) {
            this.platos.add(plato);
        }
    }

    public void recibirResena(Resena resena) {
        if (resena != null) {
            this.resenas.add(resena);
        }
    }

    // TOSTRING ACTUALIZADO (Muestra los datos del local y el conteo de sus elementos vinculados)
    @Override
    public String toString() {
        String infoUbicacion = (ubicacion != null) ? ubicacion.getDireccion() : "No asignada";
        return "LocalComida [" +
                "ID: " + idLocal +
                " | Nombre: " + nombre +
                " | Teléfono: " + telefono +
                " | Horario: " + horarioAtencion +
                " | Estado: " + estadoLocal +
                " | Rango Precio: " + rangoPrecio +
                " | Ubicación: " + infoUbicacion +
                " | Platos ofrecidos: " + platos.size() +
                " | Reseñas recibidas: " + resenas.size() +
                ']';
    }
}

