package ec.edu.uce.proyectocentralfood.dominio;

import java.util.Date;
import ec.edu.uce.proyectocentralfood.util.Validador;

public class Cuenta {

    // Atributos (idPersona eliminado por corrección del diagrama)
    private String nombre;
    private String correo;
    private Date fechaNacimiento;

    // Constructor vacío
    public Cuenta() {
    }

    // Constructor con parámetros
    public Cuenta(String nombre, String correo, Date fechaNacimiento) {
        setNombre(nombre);
        setCorreo(correo);
        setFechaNacimiento(fechaNacimiento);
    }

    public Cuenta(int idPersona, String nombre, String correo, Date fechaNacimiento) {
    }

    // Métodos accesores y modificadores booleanos validados
    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if (Validador.esNombreValido(nombre)) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean setCorreo(String correo) {
        if (Validador.esCorreoUCEValido(correo)) {
            this.correo = correo;
            return true;
        }
        return false;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean setFechaNacimiento(Date fechaNacimiento) {
        if (Validador.esFechaNacimientoValida(fechaNacimiento)) {
            this.fechaNacimiento = fechaNacimiento;
            return true;
        }
        return false;
    }

    // Métodos originales de la clase (conservados intactos)
    public void iniciarSesion() {
        // Lógica para iniciar sesión
    }

    public void cerrarSesion() {
        // Lógica para cerrar sesión
    }

    public void actualizarCredenciales() {
        // Lógica para actualizar credenciales
    }

    public void consultarPerfil() {
        // Lógica para consultar perfil
    }

    @Override
    public String toString() {
        return "Cuenta [" +
                "Nombre: '" + nombre + '\'' +
                " | Correo: '" + correo + '\'' +
                " | Fecha de Nacimiento: " + fechaNacimiento +
                ']';
    }
}