package ec.edu.uce.proyectocentralfood.dominio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class favorito {
    // 1. Atributos según el diagrama de clases
    private String id_favorito;
    private String id_usuario;
    private String id_local;
    private String fecha_agregado;
    private String fecha_actualizacion;

    // 2. Constructores
    public favorito() {}

    public favorito(String id_favorito, String id_usuario, String id_local, String fecha_agregado, String fecha_actualizacion) {
        this.id_favorito = id_favorito;
        this.id_usuario = id_usuario;
        this.id_local = id_local;
        this.fecha_agregado = fecha_agregado;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    // 3. Getters y Setters con validación
    public String get_id_favorito() { return id_favorito; }
    public void set_id_favorito(String id_favorito) { this.id_favorito = id_favorito; }

    public String get_id_usuario() { return id_usuario; }
    public void set_id_usuario(String id_usuario) {
        // Validación de formato de usuario (USR-###)
        String regla = "^USR-\\d+$";
        Pattern pattern = Pattern.compile(regla);
        Matcher matcher = pattern.matcher(id_usuario);
        if (matcher.matches()) {
            this.id_usuario = id_usuario;
        } else {
            System.out.println("[ERROR] El ID de usuario debe ser USR-###");
        }
    }

    public String get_id_local() { return id_local; }
    public void set_id_local(String id_local) { this.id_local = id_local; }

    public String get_fecha_agregado() { return fecha_agregado; }
    public void set_fecha_agregado(String fecha_agregado) { this.fecha_agregado = fecha_agregado; }

    public String get_fecha_actualizacion() { return fecha_actualizacion; }
    public void set_fecha_actualizacion(String fecha_actualizacion) { this.fecha_actualizacion = fecha_actualizacion; }

    // --- 4. MÉTODOS DEL DIAGRAMA DE CLASES ---

    public void agregarFavorito() {
        System.out.println("[SISTEMA] Local '" + this.id_local + "' añadido a favoritos.");
        System.out.println("Registro creado el: " + this.fecha_agregado);
    }

    public void consultarFavorito() {
        System.out.println("\n--- CONSULTA DE FAVORITO ---");
        System.out.println("ID Registro: " + this.id_favorito);
        System.out.println("Usuario: " + this.id_usuario);
        System.out.println("Local: " + this.id_local);
        System.out.println("Agregado el: " + this.fecha_agregado);
        System.out.println("Última actualización: " + this.fecha_actualizacion);
    }

    public void eliminarFavorito() {
        System.out.println("[SISTEMA] El registro de favorito " + this.id_favorito + " ha sido eliminado.");
    }

    // Método que justifica el atributo fecha_actualizacion
    public void actualizarFavorito(String nuevoLocal, String nuevaFecha) {
        this.id_local = nuevoLocal;
        this.fecha_actualizacion = nuevaFecha;
        System.out.println("[SISTEMA] Favorito actualizado. Nuevo local: " + nuevoLocal + " (Fecha: " + nuevaFecha + ")");
    }

}




