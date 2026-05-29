package ec.edu.uce.proyectocentralfood.dominio;

import java.util.Date;

public class UsuarioFinal extends Cuenta {

    private int idPersona;

    // RELACIONES COMO ARREGLOS ESTÁTICOS
    private Favorito[] favoritos;
    private Resena[] resenas;

    // CONSTRUCTOR VACÍO INICIALIZADO
    public UsuarioFinal() {
        super();
        this.idPersona = 0;
        this.favoritos = new Favorito[0];
        this.resenas = new Resena[0];
    }

    // CONSTRUCTORES PARAMETRIZADOS CORREGIDOS (Evitan objetos fantasmas)
    public UsuarioFinal(int idPersona, String nombre) {
        super();
        setNombre(nombre);
        setIdPersona(idPersona);
        this.favoritos = new Favorito[0];
        this.resenas = new Resena[0];
    }

    public UsuarioFinal(int idPersona, String nombre, String correo, Date fechaNacimiento) {
        super(nombre, correo, fechaNacimiento);
        setIdPersona(idPersona);
        this.favoritos = new Favorito[0];
        this.resenas = new Resena[0];
    }

    public int getIdPersona() {
        return idPersona;
    }

    public boolean setIdPersona(int idPersona) {
        if (idPersona > 0) {
            this.idPersona = idPersona;
            return true;
        }
        return false;
    }

    public Favorito[] getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Favorito[] favoritos) {
        if (favoritos != null) {
            this.favoritos = favoritos;
        }
    }

    public Resena[] getResenas() {
        return resenas;
    }

    public void setResenas(Resena[] resenas) {
        if (resenas != null) {
            this.resenas = resenas;
        }
    }

    // GESTIÓN DINÁMICA DE ARREGLOS (Reemplazo de List.add y List.removeIf)
    public void agregarAFavoritos(Favorito favorito) {
        if (favorito != null) {
            Favorito[] nuevoArreglo = new Favorito[this.favoritos.length + 1];
            System.arraycopy(this.favoritos, 0, nuevoArreglo, 0, this.favoritos.length);
            nuevoArreglo[this.favoritos.length] = favorito;
            this.favoritos = nuevoArreglo;
        }
    }

    public boolean eliminarFavorito(int idFavorito) {
        int indice = -1;
        for (int i = 0; i < favoritos.length; i++) {
            if (favoritos[i].getIdFavorito() == idFavorito) {
                indice = i;
                break;
            }
        }
        if (indice == -1) return false;

        Favorito[] nuevoArreglo = new Favorito[this.favoritos.length - 1];
        System.arraycopy(this.favoritos, 0, nuevoArreglo, 0, indice);
        System.arraycopy(this.favoritos, indice + 1, nuevoArreglo, indice, this.favoritos.length - indice - 1);
        this.favoritos = nuevoArreglo;
        return true;
    }

    public void registrarResena(Resena resena) {
        if (resena != null) {
            Resena[] nuevoArreglo = new Resena[this.resenas.length + 1];
            System.arraycopy(this.resenas, 0, nuevoArreglo, 0, this.resenas.length);
            nuevoArreglo[this.resenas.length] = resena;
            this.resenas = nuevoArreglo;
            resena.setUsuario(this);
        }
    }

    @Override
    public String toString() {
        return "UsuarioFinal [ID Persona: " + idPersona + " | Nombre: " + getNombre() + " | Favoritos: " + favoritos.length + " | Reseñas: " + resenas.length + "]";
    }
}