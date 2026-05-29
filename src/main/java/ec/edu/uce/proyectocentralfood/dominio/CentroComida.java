package ec.edu.uce.proyectocentralfood.dominio;

public class CentroComida {

    private String nombre;
    private String codigoAdministrador;

    private Cuenta[] cuentas;
    private LocalComida[] locales;
    private CategoriaGastronomica[] categorias;
    private Facultad[] facultades;

    // CONSTRUCTOR VACÍO INICIALIZADO
    public CentroComida() {
        this.nombre = "Centro Principal";
        this.codigoAdministrador = "ADM-000";
        this.cuentas = new Cuenta[0];
        this.locales = new LocalComida[0];
        this.categorias = new CategoriaGastronomica[0];
        this.facultades = new Facultad[0];
    }

    public CentroComida(String codigoAdministrador) {
        this();
        setCodigoAdministrador(codigoAdministrador);
    }

    public CentroComida(String nombre, Cuenta[] cuentas, LocalComida[] locales, CategoriaGastronomica[] categorias, Facultad[] facultades) {
        setNombre(nombre);
        setCuentas(cuentas);
        setLocales(locales);
        setCategorias(categorias);
        setFacultades(facultades);
    }

    public String getNombre() { return nombre; }
    public boolean setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) { this.nombre = nombre; return true; }
        return false;
    }

    public String getCodigoAdministrador() { return codigoAdministrador; }
    public boolean setCodigoAdministrador(String codigoAdministrador) {
        if (codigoAdministrador != null && !codigoAdministrador.trim().isEmpty()) {
            this.codigoAdministrador = codigoAdministrador;
            return true;
        }
        return false;
    }

    public Cuenta[] getCuentas() { return cuentas; }
    public void setCuentas(Cuenta[] cuentas) { if (cuentas != null) this.cuentas = cuentas; }

    public LocalComida[] getLocales() { return locales; }
    public void setLocales(LocalComida[] locales) { if (locales != null) this.locales = locales; }

    public CategoriaGastronomica[] getCategorias() { return categorias; }
    public void setCategorias(CategoriaGastronomica[] categorias) { if (categorias != null) this.categorias = categorias; }

    public Facultad[] getFacultades() { return facultades; }
    public void setFacultades(Facultad[] facultades) { if (facultades != null) this.facultades = facultades; }

    // Métodos operativos conservados
    public void crearCategoria() {}
    public void actualizarCategoria() {}
    public void eliminarCategoria() {}
    public void crearFacultad() {}
    public void actualizarFacultad() {}
    public void eliminarFacultad() {}
    public void crearLocal() {}
    public void actualizarLocal() {}
    public void eliminarLocal() {}
    public void crearPlato() {}
    public void actualizarPlato() {}
    public void eliminarPlato() {}
    public void moderarResena() {}
    public void gestionarUsuario() {}

    @Override
    public String toString() {
        return "CentroComida [Admin Código: " + codigoAdministrador + " | Cuentas: " + cuentas.length + " | Locales: " + locales.length + "]";
    }
}