package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioFinalTest {

    UsuarioFinal usuario = new UsuarioFinal(
            1,
            "Jennyfer"
    );

    @Test
    void getIdUsuario() {
        assertEquals(1, usuario.getIdUsuario());
    }

    @Test
    void setIdUsuario() {
        usuario.setIdUsuario(2);
        assertEquals(2, usuario.getIdUsuario());
    }

    @Test
    void getNombre() {
        assertEquals("Jennyfer", usuario.getNombre());
    }

    @Test
    void setNombre() {
        usuario.setNombre("Dayana");
        assertEquals("Dayana", usuario.getNombre());
    }

    @Test
    void testToString() {
        assertTrue(usuario.toString().contains("Jennyfer"));
    }
}