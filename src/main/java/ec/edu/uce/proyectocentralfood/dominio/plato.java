package ec.edu.uce.proyectocentralfood.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class plato {
    private String id_plato;
    private String nombre;
    private double precio;

    public plato() {}

    public plato(String id_plato, String nombre, double precio) {
        this.id_plato = id_plato;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public String get_id_plato() { return id_plato; }
    public void set_id_plato(String id_plato) {
        String regla = "^PLT-\\d+$";
        Pattern pattern = Pattern.compile(regla);
        Matcher matcher = pattern.matcher(id_plato);
        if (matcher.matches()) {
            this.id_plato = id_plato;
        } else {
            System.out.println("Error: Formato PLT-### incorrecto.");
        }
    }

    public String get_nombre() { return nombre; }
    public void set_nombre(String nombre) { this.nombre = nombre; }

    public double get_precio() { return precio; }
    public void set_precio(double precio) { this.precio = precio; }

    // --- MÉTODOS EXACTOS DEL DIAGRAMA DE CASOS DE USO ---

    public void crearPlato() {
        System.out.println("[CASO DE USO: Crear Plato] Registrando '" + this.nombre + "' en el sistema.");
    }

    public void consultarPlato() {
        System.out.println("[CASO DE USO: Consultar Plato]");
        System.out.println("Detalles -> ID: " + this.id_plato + " | Nombre: " + this.nombre + " | Precio: $" + this.precio);
    }

    public void actualizarPlato(String nuevoNombre, double nuevoPrecio) {
        this.nombre = nuevoNombre;
        this.precio = nuevoPrecio;
        System.out.println("[CASO DE USO: Actualizar Plato] Datos modificados para el ID: " + this.id_plato);
    }

    public void eliminarPlato() {
        System.out.println("[CASO DE USO: Eliminar Plato] El plato " + this.nombre + " ha sido removido.");
    }
}
