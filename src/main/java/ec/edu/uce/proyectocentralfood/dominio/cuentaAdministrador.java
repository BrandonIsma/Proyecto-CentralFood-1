package ec.edu.uce.proyectocentralfood.dominio;

public class cuentaAdministrador {

    private String codigoAdministrador;

    // CONSTRUCTOR VACÍO
    public cuentaAdministrador() {
    }

    // CONSTRUCTOR CON PARÁMETROS
    public cuentaAdministrador(String codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }

    // GETTERS Y SETTERS

    public String getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(String codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }

    // MÉTODOS

    public void crearCategoria() {
        System.out.println("Categoría creada");
    }

    public void actualizarCategoria() {
        System.out.println("Categoría actualizada");
    }

    public void eliminarCategoria() {
        System.out.println("Categoría eliminada");
    }

    public void crearPuntoReferencia() {
        System.out.println("Punto de referencia creado");
    }

    public void actualizarPuntoReferencia() {
        System.out.println("Punto de referencia actualizado");
    }

    public void eliminarPuntoReferencia() {
        System.out.println("Punto de referencia eliminado");
    }

    public void crearLocal() {
        System.out.println("Local creado");
    }

    public void actualizarLocal() {
        System.out.println("Local actualizado");
    }

    public void eliminarLocal() {
        System.out.println("Local eliminado");
    }

    public void crearPlato() {
        System.out.println("Plato creado");
    }

    public void actualizarPlato() {
        System.out.println("Plato actualizado");
    }

    public void eliminarPlato() {
        System.out.println("Plato eliminado");
    }

    public void moderarResena() {
        System.out.println("Reseña moderada");
    }

    public void gestionarUsuario() {
        System.out.println("Usuario gestionado");
    }

    @Override
    public String toString() {
        return "CuentaAdministrador{" +
                "codigoAdministrador='" + codigoAdministrador + '\'' +
                '}';
    }
}