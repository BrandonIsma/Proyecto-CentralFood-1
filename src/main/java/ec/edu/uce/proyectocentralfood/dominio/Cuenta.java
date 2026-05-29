package ec.edu.uce.proyectocentralfood.dominio;

import java.util.Date;

public class Cuenta {

    private String nombre;
    private String correo;
    private Date fechaNacimiento;

    // CONSTRUCTOR VACÍO INICIALIZADO
    public Cuenta() {
        this.nombre = "Sin nombre";
        this.correo = "sin@uce.edu.ec";
        this.fechaNacimiento = new Date(); // Fecha actual por defecto
    }

    // CONSTRUCTOR PARAMETRIZADO
    public Cuenta(String nombre, String correo, Date fechaNacimiento) {
        setNombre(nombre);
        setCorreo(correo);
        setFechaNacimiento(fechaNacimiento);
    }

    // GETTERS Y SETTERS CON VALIDACIÓN DE FONDO
    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean setCorreo(String correo) {
        if (correo != null && !correo.trim().isEmpty()) {
            this.correo = correo;
            return true;
        }
        return false;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean setFechaNacimiento(Date fechaNacimiento) {
        if (fechaNacimiento != null && fechaNacimiento.before(new Date())) {
            this.fechaNacimiento = fechaNacimiento;
            return true;
        }
        return false;
    }

    public void iniciarSesion() {}
    public void cerrarSesion() {}
    public void actualizarCredenciales() {}
    public void consultarPerfil() {}

    @Override
    public String toString() {
        return "Cuenta [Nombre: '" + nombre + "' | Correo: '" + correo + "' | Fecha Nacimiento: " + fechaNacimiento + "]";
    }
}