package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioFinal extends Cuenta {

    private int idPersona;

    // ATRIBUTOS DE RELACIÓN
    private List<Favorito> favoritos;    // Guarda sus favoritos
    private List<Resena> resenas;        // Realiza reseñas

    // CONSTRUCTOR VACÍO
    public UsuarioFinal() {
        super();
        this.favoritos = new ArrayList<>();
        this.resenas = new ArrayList<>();
    }

    // CONSTRUCTOR CON PARÁMETROS
    public UsuarioFinal(int idPersona, String nombre, String correo, Date fechaNacimiento) {
        // Inicializa los atributos de la clase padre (Cuenta)
        super(nombre, correo, fechaNacimiento);

        // Inicializa las colecciones y el atributo propio
        this.favoritos = new ArrayList<>();
        this.resenas = new ArrayList<>();
        setIdPersona(idPersona);
    }

    public UsuarioFinal(int idUsuario, String nombre) {
    }

    // GETTERS Y SETTERS CON VALIDACIÓN

    public int getIdPersona() {
        return idPersona;
    }

    public boolean setIdPersona(int idPersona) {
        if (Validador.esIdPersonaValido(idPersona)) {
            this.idPersona = idPersona;
            return true;
        }
        return false;
    }

    // GETTERS Y SETTERS DE LAS RELACIONES

    public List<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Favorito> favoritos) {
        if (favoritos != null) {
            this.favoritos = favoritos;
        }
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        if (resenas != null) {
            this.resenas = resenas;
        }
    }

    // MÉTODOS DE COMPORTAMIENTO

    public void agregarAFavoritos(Favorito favorito) {
        if (favorito != null) {
            this.favoritos.add(favorito);
        }
    }

    public void registrarResena(Resena resena) {
        if (resena != null) {
            this.resenas.add(resena);
            resena.setUsuario(this); // Setea de forma bidireccional el autor de la reseña
        }
    }

    // MÉTODO DE COMPORTAMIENTO: Filtrar por Categoría Gastronómica
    public List<Plato> filtrarPorCategoria(List<Plato> todosLosPlatos, String categoriaObjetivo) {
        List<Plato> platosFiltrados = new ArrayList<>();

        if (todosLosPlatos == null || categoriaObjetivo == null) {
            return platosFiltrados;
        }

        for (Plato plato : todosLosPlatos) {
            if (plato.getCategoria() != null && plato.getCategoria().equalsIgnoreCase(categoriaObjetivo)) {
                platosFiltrados.add(plato);
            }
        }
        return platosFiltrados;
    }

    // TOSTRING ACTUALIZADO
    @Override
    public String toString() {
        return "UsuarioFinal [" +
                "ID Persona: " + idPersona +
                " | Nombre (Heredado): " + getNombre() +
                " | Correo (Heredado): " + getCorreo() +
                " | Favoritos guardados: " + favoritos.size() +
                " | Reseñas hechas: " + resenas.size() +
                ']';
    }
}