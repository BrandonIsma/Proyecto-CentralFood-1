package ec.edu.uce.proyectocentralfood.dominio;

import java.util.Date;

public class Cuenta {

    private int idPersona;
    private String nombre;
    private String correo;
    private Date fechaNacimiento;

    public Cuenta(String nombre, String correo, Date fechaNacimiento) {
    }

    public Cuenta(int idPersona, String nombre, String correo, Date fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void iniciarSesion() {
    }

    public void cerrarSesion() {
    }

    public void actualizarCredenciales() {
    }

    public void consultarPerfil() {
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}