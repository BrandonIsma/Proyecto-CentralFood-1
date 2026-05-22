package ec.edu.uce.proyectocentralfood.dominio;

import ec.edu.uce.proyectocentralfood.util.Validador;

public class Favorito {

    // Los 4 atributos originales estrictos
    private int idFavorito;
    private int idUsuario;
    private int idLocal;
    private int fechaAgregado;

    // CONSTRUCTOR VACÍO
    public Favorito() {
    }

    // CONSTRUCTOR CON PARÁMETROS
    public Favorito(int idFavorito, int idUsuario, int idLocal, int fechaAgregado) {
        setIdFavorito(idFavorito);
        setIdUsuario(idUsuario);
        setIdLocal(idLocal);
        setFechaAgregado(fechaAgregado);
    }

    // GETTERS Y SETTERS CON VALIDACIÓN

    public int getIdFavorito() {
        return idFavorito;
    }

    public boolean setIdFavorito(int idFavorito) {
        // Usa el validador de la sección FAVORITO
        if (Validador.esIdFavoritoValido(idFavorito)) {
            this.idFavorito = idFavorito;
            return true;
        }
        return false;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public boolean setIdUsuario(int idUsuario) {
        // Usa el validador de la sección USUARIO FINAL
        if (Validador.esIdUsuarioValido(idUsuario)) {
            this.idUsuario = idUsuario;
            return true;
        }
        return false;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public boolean setIdLocal(int idLocal) {
        // Usa el validador de la sección LOCAL COMIDA
        if (Validador.esIdLocalValido(idLocal)) {
            this.idLocal = idLocal;
            return true;
        }
        return false;
    }

    public int getFechaAgregado() {
        return fechaAgregado;
    }

    public boolean setFechaAgregado(int fechaAgregado) {
        // Usa el validador de la sección FAVORITO (valida las 8 cifras numéricas)
        if (Validador.esFechaAgregadoValida(fechaAgregado)) {
            this.fechaAgregado = fechaAgregado;
            return true;
        }
        return false;
    }

    // METODO TOSTRING
    @Override
    public String toString() {
        return "Favorito [" +
                "ID Favorito: " + idFavorito +
                " | ID Usuario: " + idUsuario +
                " | ID Local: " + idLocal +
                " | Fecha Agregado: " + fechaAgregado +
                ']';
    }
}