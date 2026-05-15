package ec.edu.uce.proyectocentralfood.dominio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Favorito {
    // Atributos definidos en el diagrama de clases
    private int idFavorito;
    private int idUsuario;
    private int idLocal;
    private int fechaAgregado;

    // Constructor por defecto
    public Favorito() {
    }

    // Constructor con parámetros
    public Favorito(int idFavorito, int idUsuario, int idLocal, int fechaAgregado) {
        this.idFavorito = idFavorito;
        this.idUsuario = idUsuario;
        this.idLocal = idLocal;
        this.fechaAgregado = fechaAgregado;
    }

    // Métodos accesores (get) y modificadores (set)
    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(int fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    // Método toString para representar el objeto como texto
    @Override
    public String toString() {
        return "Favorito {" +
                "idFavorito=" + idFavorito +
                ", idUsuario=" + idUsuario +
                ", idLocal=" + idLocal +
                ", fechaAgregado=" + fechaAgregado +
                '}';
    }

}




