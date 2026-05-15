package ec.edu.uce.proyectocentralfood.dominio;

public class CuentaAdministrador {

    // ATRIBUTO
    private String codigoAdministrador;

    // CONSTRUCTOR VACÍO
    public CuentaAdministrador() {
    }

    // CONSTRUCTOR CON PARÁMETROS
    public CuentaAdministrador(String codigoAdministrador) {
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

    }

    public void actualizarCategoria() {

    }

    public void eliminarCategoria() {

    }

    public void crearPuntoReferencia() {

    }

    public void actualizarPuntoReferencia() {

    }

    public void eliminarPuntoReferencia() {

    }

    public void crearLocal() {

    }

    public void actualizarLocal() {

    }

    public void eliminarLocal() {

    }

    public void crearPlato() {

    }

    public void actualizarPlato() {

    }

    public void eliminarPlato() {

    }

    public void moderarResena() {

    }

    public void gestionarUsuario() {

    }

    // TOSTRING

    @Override
    public String toString() {
        return "CuentaAdministrador{" +
                "codigoAdministrador='" + codigoAdministrador + '\'' +
                '}';
    }
}