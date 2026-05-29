package ec.edu.uce.proyectocentralfood.dominio;

public class MenuDelDia extends Plato {

    private String entrada;
    private String sopa;
    private String segundo;
    private String bebida;
    private String postre;

    // CONSTRUCTOR VACÍO
    public MenuDelDia() {
        super();
        this.entrada = "Sin entrada";
        this.sopa = "Sin sopa";
        this.segundo = "Sin segundo";
        this.bebida = "Sin bebida";
        this.postre = "Sin postre";
    }

    // CONSTRUCTOR CON PARÁMETROS - Corregido para coincidir con Plato
    public MenuDelDia(int idPlato, String nombre, String descripcion, double precio,
                      int fechaActualizacion, CategoriaGastronomica categoriaGastro,
                      String entrada, String sopa, String segundo, String bebida, String postre) {

        // Llamada correcta al constructor de Plato
        super(idPlato, nombre, descripcion, precio, fechaActualizacion, categoriaGastro);

        this.entrada = entrada;
        this.sopa = sopa;
        this.segundo = segundo;
        this.bebida = bebida;
        this.postre = postre;
    }

    // GETTERS Y SETTERS CON VALIDACIÓN DE FONDO

    public String getEntrada() { return entrada; }
    public boolean setEntrada(String entrada) {
        if (entrada != null && !entrada.trim().isEmpty()) { this.entrada = entrada; return true; }
        return false;
    }

    public String getSopa() { return sopa; }
    public boolean setSopa(String sopa) {
        if (sopa != null && !sopa.trim().isEmpty()) { this.sopa = sopa; return true; }
        return false;
    }

    public String getSegundo() { return segundo; }
    public boolean setSegundo(String segundo) {
        if (segundo != null && !segundo.trim().isEmpty()) { this.segundo = segundo; return true; }
        return false;
    }

    public String getBebida() { return bebida; }
    public boolean setBebida(String bebida) {
        if (bebida != null && !bebida.trim().isEmpty()) { this.bebida = bebida; return true; }
        return false;
    }

    public String getPostre() { return postre; }
    public boolean setPostre(String postre) {
        if (postre != null && !postre.trim().isEmpty()) { this.postre = postre; return true; }
        return false;
    }

    // POLIMORFISMO: Sobrescritura para mostrar el detalle del menú
    @Override
    public String toString() {
        return super.toString() +
                "\n   [DETALLE DEL MENÚ] -> Entrada: '" + entrada + '\'' +
                " | Sopa: '" + sopa + '\'' +
                " | Segundo: '" + segundo + '\'' +
                " | Bebida: '" + bebida + '\'' +
                " | Postre: '" + postre + '\'';
    }
}