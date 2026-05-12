package ec.edu.uce.proyectocentralfood.dominio;


public class usuarioFinal {

    private int telefono;
    private int idUsuario;

    public usuarioFinal( int telefono, int idUsuario) {

        this.telefono = telefono;
        this.idUsuario = idUsuario;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void crearResena(){
        System.out.println("Ingrese su reseña: "+idUsuario);
        System.out.println("Reseña creada correctamente.");
    }
    public void actualizarResena(){
        System.out.println("Actualizando reseña del usuario con ID " + idUsuario);
        System.out.println("Reseña actualizada correctamente.");
    }
    public void eliminarResena(){
        System.out.println("Reseña del usuario con ID " + idUsuario + " ha sido eliminada.");
        System.out.println("Reseña eliminada correctamente.");
    }
    public void agregarFavorito(){
        System.out.println("Agregando favorito para el usuario con ID " + idUsuario);
        System.out.println("Favorito agregado correctamente.");
    }
    public void consultarFavorito(){
        System.out.println("Consultar favorito para el usuario con ID " + idUsuario);
        System.out.println("Favorito consultado correctamente.");
    }
    public void eliminarFavorito(){
        System.out.println("Eliminando favorito para el usuario con ID " + idUsuario);
        System.out.println("Favorito eliminado correctamente.");
    }
    @Override
    public String toString(){
        return "Usuario final: " + idUsuario;
    }

}
