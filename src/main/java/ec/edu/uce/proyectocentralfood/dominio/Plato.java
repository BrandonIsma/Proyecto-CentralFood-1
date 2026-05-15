package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;

public class Plato {
    // 1. Atributos (Según el diagrama)
    private int idPlato;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;
    private int fechaActualizacion;

    // 2. Constructor por defecto
    public Plato() {}

    // 3. Constructor con parámetros
    public Plato(int idPlato, String nombre, String categoria, String descripcion, double precio, int fechaActualizacion) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaActualizacion = fechaActualizacion;
    }

    // 4. Métodos Accesores y Modificadores con Validación
    public int getIdPlato() { return idPlato; }
    public void setIdPlato(int idPlato) { this.idPlato = idPlato; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (Validador.esTextoValido(nombre)) {
            this.nombre = nombre;
        } else {
            this.nombre = "Nombre Inválido";
        }
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) {
        if (Validador.esTextoValido(categoria)) {
            this.categoria = categoria;
        } else {
            this.categoria = "Categoría Inválida";
        }
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        if (Validador.esTextoValido(descripcion)) {
            this.descripcion = descripcion;
        } else {
            this.descripcion = "Descripción Inválida";
        }
    }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        // Validación lógica: el precio debe ser mayor a 0
        if (precio > 0) {
            this.precio = precio;
        } else {
            this.precio = 0.0;
        }
    }

    public int getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(int fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }

    // 5. toString() para representar el objeto
    @Override
    public String toString() {
        return "Plato [" +
                "ID: " + idPlato +
                " | Nombre: '" + nombre + '\'' +
                " | Categoría: '" + categoria + '\'' +
                " | Precio: $" + precio +
                " | Actualizado: " + fechaActualizacion +
                ']';
    }
}
