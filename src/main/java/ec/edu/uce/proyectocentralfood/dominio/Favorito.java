package ec.edu.uce.proyectocentralfood.dominio;

public class Favorito {
    // 1. Atributos privados
    private int idFavorito;
    private int idUsuario;
    private int idLocal;
    private int fechaAgregado;

    // 2. Constructor por defecto
    public Favorito() {}

    // 3. Constructor con parámetros
    public Favorito(int idFavorito, int idUsuario, int idLocal, int fechaAgregado) {
        this.idFavorito = idFavorito;
        this.idUsuario = idUsuario;
        this.idLocal = idLocal;
        this.fechaAgregado = fechaAgregado;
    }

    // 4. Métodos Accesores (Getters) y Modificadores (Setters)
    // Para los IDs, validamos que sean números positivos
    public int getIdFavorito() { return idFavorito; }
    public void setIdFavorito(int idFavorito) {
        if (idFavorito > 0) this.idFavorito = idFavorito;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) {
        if (idUsuario > 0) this.idUsuario = idUsuario;
    }

    public int getIdLocal() { return idLocal; }
    public void setIdLocal(int idLocal) {
        if (idLocal > 0) this.idLocal = idLocal;
    }

    public int getFechaAgregado() { return fechaAgregado; }
    public void setFechaAgregado(int fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    // 5. toString() para representar el objeto
    @Override
    public String toString() {
        return "Favorito [" +
                "ID Fav: " + idFavorito +
                " | ID Usuario: " + idUsuario +
                " | ID Local: " + idLocal +
                " | Agregado el: " + fechaAgregado +
                ']';
    }

}




