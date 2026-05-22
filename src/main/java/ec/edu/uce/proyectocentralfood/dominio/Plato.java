package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;

public class Plato {

    // Los 6 atributos primitivos originales estrictos
    private int idPlato;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;
    private int fechaActualizacion;

    // ATRIBUTOS DE RELACIÓN (Asociaciones y Estados)
    private LocalComida localComida;                 // El plato pertenece a un local de comida
    private CategoriaGastronomica categoriaGastro;   // Está clasificado en una categoría gastronómica
    private boolean esFavorito;                      // Estado que define si está marcado como favorito

    // CONSTRUCTOR VACÍO
    public Plato() {
    }

    // CONSTRUCTOR CON PARÁMETROS ORIGINALES
    public Plato(int idPlato, String nombre, String categoria, String descripcion, double precio, int fechaActualizacion) {
        setIdPlato(idPlato);
        setNombre(nombre);
        setCategoria(categoria);
        setDescripcion(descripcion);
        setPrecio(precio);
        setFechaActualizacion(fechaActualizacion);
    }

    // GETTERS Y SETTERS CON VALIDACIÓN (Atributos Primitivos)

    public int getIdPlato() {
        return idPlato;
    }

    public boolean setIdPlato(int idPlato) {
        if (Validador.esIdPlatoValido(idPlato)) {
            this.idPlato = idPlato;
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if (Validador.esNombrePlatoValido(nombre)) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean setCategoria(String categoria) {
        if (Validador.esCategoriaPlatoValida(categoria)) {
            this.categoria = categoria;
            return true;
        }
        return false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean setDescripcion(String descripcion) {
        if (Validador.esDescripcionPlatoValida(descripcion)) {
            this.descripcion = descripcion;
            return true;
        }
        return false;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean setPrecio(double precio) {
        if (Validador.esPrecioPlatoValido(precio)) {
            this.precio = precio;
            return true;
        }
        return false;
    }

    public int getFechaActualizacion() {
        return fechaActualizacion;
    }

    public boolean setFechaActualizacion(int fechaActualizacion) {
        if (Validador.esFechaActualizacionValida(fechaActualizacion)) {
            this.fechaActualizacion = fechaActualizacion;
            return true;
        }
        return false;
    }

    // GETTERS Y SETTERS DE LAS RELACIONES

    public LocalComida getLocalComida() {
        return localComida;
    }

    public void setLocalComida(LocalComida localComida) {
        this.localComida = localComida;
    }

    public CategoriaGastronomica getCategoriaGastro() {
        return categoriaGastro;
    }

    public void setCategoriaGastro(CategoriaGastronomica categoriaGastro) {
        this.categoriaGastro = categoriaGastro;
    }

    public boolean isEsFavorito() {
        return esFavorito;
    }

    public void setEsFavorito(boolean esFavorito) {
        this.esFavorito = esFavorito;
    }

    // TOSTRING ACTUALIZADO (Muestra los datos y los nombres de los objetos asociados)
    @Override
    public String toString() {
        String nombreLocal = (localComida != null) ? localComida.getNombre() : "No asignado";
        String nombreCat = (categoriaGastro != null) ? categoriaGastro.getNombreCategoria() : "No asignada";
        return "Plato [" +
                "ID: " + idPlato +
                " | Nombre: " + nombre +
                " | Precio: $" + precio +
                " | Local: " + nombreLocal +
                " | Categoría: " + nombreCat +
                " | ¿Favorito?: " + (esFavorito ? "Sí" : "No") +
                ']';
    }
}