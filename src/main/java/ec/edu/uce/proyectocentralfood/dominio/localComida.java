package ec.edu.uce.proyectocentralfood.dominio;

public class localComida {

    private int idlocal;
    private String nombre;
    private String descripcion;
    private String telefono;
    private String horarioAtencion;
    private String estadolocal;
    private String precio;

    public localComida(int idPersona, String nombre, String descripcion, String telefono, String horarioAtencion, String estadolocal, String precio) {
        this.idlocal = idPersona;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.horarioAtencion = horarioAtencion;
        this.estadolocal = estadolocal;
        this.precio = precio;


    }
    public int getIdlocal() {
        return idlocal;
    }
    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
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
    public String getEstadolocal() {
        return estadolocal;
    }
    public void setEstadolocal(String estadolocal) {
        this.estadolocal = estadolocal;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public void crearlocal() {
        System.out.println("Ingrese el nombre del local de comida:"+  nombre);
        System.out.printf("Ingrese la descripción del local de comida:"+descripcion);
        System.out.printf("Ingrese el teléfono del local de comida:"+telefono);
        System.out.printf("Ingrese el horario de atención del local de comida:"+horarioAtencion);
        System.out.println("El local de comida " + nombre + " ha sido creado.");
    }
    public void consularlocal() {
        System.out.println("Ingrese el nombre del local de comida:"+nombre);
    }
    public void actualizarlocal() {
        System.out.println("Actualizar el horario de atencion del local" + horarioAtencion + ".");
        System.out.println("Actualizar el estado del local de comida " + estadolocal + ".");
        System.out.println("Actualizar el precio del plato de comida " + precio + ".");
    }
    public void eliminarlocal() {
        System.out.println("El local de comida " + nombre + " ha sido eliminado.");
    }
    public void consultarEstadoApertura() {
        System.out.println("Estado del local");
        System.out.println("El local de comida " + nombre + " está actualmente " + estadolocal + ".");
    }
    public void consultarPrecio() {
        System.out.println("Precio del plato de comida");
        System.out.println("El precio del plato de comida " + nombre + " es " + precio + ".");
    }
    @Override
    public String toString() {
        return "localComida{" +
                "idlocal=" + idlocal +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", horarioAtencion='" + horarioAtencion + '\'' +
                ", estadolocal='" + estadolocal + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }

}


