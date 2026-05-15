package ec.edu.uce.proyectocentralfood.dominio;

import java.util.Date;

public class Cuenta {

    private int idPersona;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaNacimiento;

    public Cuenta() {
    }
    public Cuenta(int idPersona, String nombre, String apellido, String correo, Date fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        System.out.println("La cuenta con correo " + correo + " ha iniciado sesión.");
    }
    public void cerrarSesion() {
        System.out.println("La cuenta con correo " + correo + " ha cerrado sesión.");
    }
    public void actualizarCredenciales() {
        System.out.println("Las credenciales de la cuenta de " + nombre + " " + apellido + " han sido actualizadas.");
    }
    public void consultarPerfil() {
        System.out.println("Perfil de la cuenta:");
        System.out.println("ID persona: " + idPersona);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Correo: " + correo);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
    }
    @Override
    public String toString() {
        return "Cuenta{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}