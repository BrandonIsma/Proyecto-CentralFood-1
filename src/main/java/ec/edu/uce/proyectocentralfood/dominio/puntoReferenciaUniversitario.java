package ec.edu.uce.proyectocentralfood.dominio;

public class puntoReferenciaUniversitaria {
    private int idPuntoReferencia;
    private String nombre;
    private String descripcion;

    public puntoReferenciaUniversitaria(int idPuntoReferencia, String nombre, String descripcion) {
        this.idPuntoReferencia = idPuntoReferencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public int getIdPuntoReferencia() {
        return idPuntoReferencia;
    }
    public void setIdPuntoReferencia(int idPuntoReferencia) {
        this.idPuntoReferencia = idPuntoReferencia;
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
    public void crearPuntoReferenciaUniversitaria(){
        System.out.println("Ingrese su punto de referencia"+idPuntoReferencia);
    }
    public void consultarPuntoReferenciaUniversitaria(){
        System.out.println("Consultando punto de referencia universitaria: "+idPuntoReferencia);
        System.out.println("Nombre: "+nombre);
        System.out.println("Descripción: "+descripcion);
    }
    public void actualizarPuntoReferenciaUniversitaria() {
        System.out.println("Actualizando punto de referencia universitaria: " + idPuntoReferencia);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Punto de referencia universitaria actualizado correctamente.");
    }
    public void eliminarPuntoReferenciaUniversitaria(){
        System.out.println("Punto de referencia universitaria con ID " + idPuntoReferencia + " ha sido eliminado.");
        System.out.println("Punto de referencia universitaria eliminado correctamente.");
    }
    public void validarCoordenadas(){
        System.out.println("Validando coordenadas para el punto de referencia universitaria con ID " + idPuntoReferencia);
        System.out.println("Coordenadas validadas correctamente.");
    }
    @Override
    public String toString() {
        return "puntoReferenciaUniversitaria{" +
                "idPuntoReferencia=" + idPuntoReferencia +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
