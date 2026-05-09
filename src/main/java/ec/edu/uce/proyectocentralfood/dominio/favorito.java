package ec.edu.uce.proyectocentralfood.dominio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class favorito {
    // 1. Atributos privados
    private String id_favorito;
    private String id_usuario;
    private String id_local;
    private String fecha_agregado;

    // 2. Constructores
    public favorito() {}

    public favorito(String id_favorito, String id_usuario, String id_local, String fecha_agregado) {
        this.id_favorito = id_favorito;
        this.id_usuario = id_usuario;
        this.id_local = id_local;
        this.fecha_agregado = fecha_agregado;
    }

    // 3. Getters y Setters
    public String get_id_favorito() { return id_favorito; }
    public void set_id_favorito(String id_favorito) { this.id_favorito = id_favorito; }

    public String get_id_usuario() { return id_usuario; }

    public void set_id_usuario(String id_usuario) {
        // Validación: Debe empezar con USR- seguido de números
        String regla = "^USR-\\d+$";
        Pattern pattern = Pattern.compile(regla);
        Matcher matcher = pattern.matcher(id_usuario);

        if (matcher.matches()) {
            this.id_usuario = id_usuario;
        } else {
            System.out.println("[ERROR] Formato de ID de Usuario inválido (Use USR-###).");
        }
    }

    public String get_id_local() { return id_local; }
    public void set_id_local(String id_local) { this.id_local = id_local; }

    public String get_fecha_agregado() { return fecha_agregado; }
    public void set_fecha_agregado(String fecha_agregado) { this.fecha_agregado = fecha_agregado; }

    // --- 4. MÉTODOS DEL DIAGRAMA DE CASOS DE USO ---

    public void agregarFavorito() {
        System.out.println("[CASO DE USO: Agregar Favorito] El local " + this.id_local + " ha sido guardado para el usuario " + this.id_usuario);
    }

    public void consultarFavorito() {
        System.out.println("[CASO DE USO: Consultar Favorito]");
        System.out.println("Detalles del Favorito -> ID: " + this.id_favorito + " | Usuario: " + this.id_usuario + " | Local: " + this.id_local + " | Fecha: " + this.fecha_agregado);
    }

    public void eliminarFavorito() {
        System.out.println("[CASO DE USO: Eliminar Favorito] Removiendo local de la lista de favoritos...");
    }
}




