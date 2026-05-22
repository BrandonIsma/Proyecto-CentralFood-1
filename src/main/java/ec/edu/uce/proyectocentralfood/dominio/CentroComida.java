package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;

public class CentroComida {

    // Atributo principal
    private String nombre;

    // RELACIONES: Un centro de comida administra múltiples elementos del sistema
    private Cuenta[] cuentas;
    private LocalComida[] locales;
    private CategoriaGastronomica[] categorias;
    private Facultad[] facultades;

    // CONSTRUCTOR VACÍO
    public CentroComida() {
    }

    // CONSTRUCTOR CON PARÁMETROS (Inteligente)
    public CentroComida(String nombre, Cuenta[] cuentas, LocalComida[] locales, CategoriaGastronomica[] categorias, Facultad[] facultades) {
        setNombre(nombre);
        setCuentas(cuentas);
        setLocales(locales);
        setCategorias(categorias);
        setFacultades(facultades);
    }

    // GETTERS Y SETTERS (Booleanos y con validación)
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

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public boolean setCuentas(Cuenta[] cuentas) {
        if (cuentas != null) {
            this.cuentas = cuentas;
            return true;
        }
        return false;
    }

    public LocalComida[] getLocales() {
        return locales;
    }

    public boolean setLocales(LocalComida[] locales) {
        if (locales != null) {
            this.locales = locales;
            return true;
        }
        return false;
    }

    public CategoriaGastronomica[] getCategorias() {
        return categorias;
    }

    public boolean setCategorias(CategoriaGastronomica[] categorias) {
        if (categorias != null) {
            this.categorias = categorias;
            return true;
        }
        return false;
    }

    public Facultad[] getFacultades() {
        return facultades;
    }

    public boolean setFacultades(Facultad[] facultades) {
        if (facultades != null) {
            this.facultades = facultades;
            return true;
        }
        return false;
    }

    // MÉTODOS ORIGINALES CONSERVADOS (Adaptados al cambio de PuntoReferencia a Facultad)

    public void crearCategoria() {
    }

    public void actualizarCategoria() {
    }

    public void eliminarCategoria() {
    }

    public void crearFacultad() {
    }

    public void actualizarFacultad() {
    }

    public void eliminarFacultad() {
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

    // TOSTRING ACTUALIZADO WITH RESUMEN DE RELACIONES
    @Override
    public String toString() {
        return "CentroComida [" +
                "Nombre: '" + nombre + '\'' +
                " | Cuentas: " + (cuentas != null ? cuentas.length : 0) +
                " | Locales: " + (locales != null ? locales.length : 0) +
                " | Categorías: " + (categorias != null ? categorias.length : 0) +
                " | Facultades: " + (facultades != null ? facultades.length : 0) +
                ']';
    }
}