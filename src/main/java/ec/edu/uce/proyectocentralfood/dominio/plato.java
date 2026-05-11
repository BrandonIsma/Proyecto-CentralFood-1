package ec.edu.uce.proyectocentralfood.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class plato {
    // 1. Atributos (Corregidos según diagrama de clases)
    private String id_plato;
    private String nombre;
    private String categoria;
    private double precio;
    private String descripcion;
    private String fecha_actualizacion;

    // 2. Constructores
    public plato() {}

    public plato(String id_plato, String nombre, String categoria, double precio, String descripcion, String fecha_actualizacion) {
        this.id_plato = id_plato;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    // 3. Métodos Get y Set
    public String get_id_plato() { return id_plato; }
    public void set_id_plato(String id_plato) {
        String regla = "^PLT-\\d+$";
        Pattern pattern = Pattern.compile(regla);
        Matcher matcher = pattern.matcher(id_plato);
        if (matcher.matches()) {
            this.id_plato = id_plato;
        } else {
            System.out.println("[ERROR] Formato de ID incorrecto (PLT-###).");
        }
    }

    public String get_nombre() { return nombre; }
    public void set_nombre(String nombre) { this.nombre = nombre; }

    public String get_categoria() { return categoria; }
    public void set_categoria(String categoria) { this.categoria = categoria; }

    public double get_precio() { return precio; }
    public void set_precio(double precio) { this.precio = precio; }

    public String get_descripcion() { return descripcion; }
    public void set_descripcion(String descripcion) { this.descripcion = descripcion; }

    public String get_fecha_actualizacion() { return fecha_actualizacion; }
    public void set_fecha_actualizacion(String fecha_actualizacion) { this.fecha_actualizacion = fecha_actualizacion; }

    // --- 4. FUNCIONALIDADES ---

    public void crearPlato() {
        System.out.println("[SISTEMA] Registrando nuevo plato: " + this.nombre + " (Fecha: " + this.fecha_actualizacion + ")");
    }

    public void consultarPlato() {
        System.out.println("\n--- DATOS DEL PLATO ---");
        System.out.println("ID: " + this.id_plato);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Categoría: " + this.categoria);
        System.out.println("Precio: $" + this.precio);
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Última actualización: " + this.fecha_actualizacion);
    }

    // Al actualizar, se pide la fecha para que quede el registro
    public void actualizarPlato(String nuevoNombre, String nuevaCat, String nuevaDesc, String nuevaFecha) {
        this.nombre = nuevoNombre;
        this.categoria = nuevaCat;
        this.descripcion = nuevaDesc;
        this.fecha_actualizacion = nuevaFecha;
        System.out.println("[SISTEMA] La información general de '" + this.id_plato + "' ha sido actualizada el " + nuevaFecha + ".");
    }

    public void eliminarPlato() {
        System.out.println("[SISTEMA] Eliminando '" + this.nombre + "' del registro.");
    }

    // También actualizamos la fecha al cambiar el precio
    public void actualizarPrecio(double nuevoPrecio, String nuevaFecha) {
        this.precio = nuevoPrecio;
        this.fecha_actualizacion = nuevaFecha;
        System.out.println("[SISTEMA] Nuevo precio establecido para '" + this.nombre + "': $" + nuevoPrecio + " (Actualizado: " + nuevaFecha + ")");
    }
}
