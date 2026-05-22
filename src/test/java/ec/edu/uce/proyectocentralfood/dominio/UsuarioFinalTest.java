package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioFinalTest {

    UsuarioFinal usuario = new UsuarioFinal(
            1,
            "Jennyfer",
            "jennyfer@gmail.com",
            new Date()
    );

    @Test
    void getIdPersona() {
        assertEquals(1, usuario.getIdPersona());
    }

    @Test
    void setIdPersona() {
        usuario.setIdPersona(2);
        assertEquals(2, usuario.getIdPersona());
    }

    @Test
    void getFavoritos() {
        assertNotNull(usuario.getFavoritos());
    }

    @Test
    void setFavoritos() {
        usuario.setFavoritos(null);
        assertNotNull(usuario.getFavoritos());
    }

    @Test
    void getResenas() {
        assertNotNull(usuario.getResenas());
    }

    @Test
    void setResenas() {
        usuario.setResenas(null);
        assertNotNull(usuario.getResenas());
    }

    @Test
    void agregarAFavoritos() {

        Favorito favorito = new Favorito();

        usuario.agregarAFavoritos(favorito);

        assertEquals(1, usuario.getFavoritos().size());
    }

    @Test
    void registrarResena() {

        Resena resena = new Resena();

        usuario.registrarResena(resena);

        assertEquals(1, usuario.getResenas().size());
    }

    @Test
    void filtrarPorCategoria() {
        assertNotNull(usuario);
    }

    @Test
    void testToString() {
        assertTrue(usuario.toString().contains("Jennyfer"));
    }
}