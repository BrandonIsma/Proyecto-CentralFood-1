package ec.edu.uce.proyectocentralfood.dominio;

public class LocalComida {
    private int idLocal;
    private String nombre;
    private String descripcion;
    private String telefono;
    private String horarioAtencion;
    private String estadoLocal;
    private String rangoPrecio;

    // Método Constructor

    public LocalComida(int idLocal, String nombre, String descripcion, String telefono,
                       String horarioAtencion, String estadoLocal, String rangoPrecio) {
        this.idLocal = idLocal;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.horarioAtencion = horarioAtencion;
        this.estadoLocal = estadoLocal;
        this.rangoPrecio = rangoPrecio;
    }

    // Métodos Get y Set
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public String getEstadoLocal() {
        return estadoLocal;
    }

    public void setEstadoLocal(String estadoLocal) {
        this.estadoLocal = estadoLocal;
    }

    public String getRangoPrecio() {
        return rangoPrecio;
    }

    public void setRangoPrecio(String rangoPrecio) {
        this.rangoPrecio = rangoPrecio;
    }
    @Override
    public String toString() {
        return "LocalComida{" +
                "idLocal=" + idLocal +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", horarioAtencion='" + horarioAtencion + '\'' +
                ", estadoLocal='" + estadoLocal + '\'' +
                ", rangoPrecio='" + rangoPrecio + '\'' +
                '}';
    }
}



