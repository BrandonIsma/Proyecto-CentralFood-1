package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;

public class CategoriaGastronomica {

    // 1. Atributos privados
    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;

    // 2. Constructor por defecto
    public CategoriaGastronomica() {
    }

    // 3. Constructor con parámetros
    public CategoriaGastronomica(int idCategoria, String nombreCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
    }

    // 4. Métodos accesores (Getters) y modificadores (Setters)
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        // Usamos el validador antes de asignar el valor
        if (Validador.esTextoValido(nombreCategoria)) {
            this.nombreCategoria = nombreCategoria;
        } else {
            this.nombreCategoria = "Dato Inválido";
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (Validador.esTextoValido(descripcion)) {
            this.descripcion = descripcion;
        } else {
            this.descripcion = "Descripción Inválida";
        }
    }

    // 5. toString() para representar el objeto como texto
    @Override
    public String toString() {
        return "CategoriaGastronomica [" +
                "ID: " + idCategoria +
                " | Nombre: '" + nombreCategoria + '\'' +
                " | Descripción: '" + descripcion + '\'' +
                ']';
    }
}