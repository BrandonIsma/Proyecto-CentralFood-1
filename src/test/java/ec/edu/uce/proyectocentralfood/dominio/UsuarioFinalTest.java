package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioFinalTest {

    private UsuarioFinal usuario;
    private Date fechaValida;

    @BeforeEach
    void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.MAY, 15);
        fechaValida = cal.getTime();
        usuario = new UsuarioFinal(1, "Carlos Torres", "carlos.torres@uce.edu.ec", fechaValida);
    }

    @Test
    void setIdPersonaInvalido() {
        assertFalse(usuario.setIdPersona(0));
        assertFalse(usuario.setIdPersona(-1));
        assertEquals(1, usuario.getIdPersona());
    }

    @Test
    void arreglosInicialmenteVaciosNoNulos() {
        assertNotNull(usuario.getFavoritos());
        assertNotNull(usuario.getResenas());
        assertEquals(0, usuario.getFavoritos().length);
        assertEquals(0, usuario.getResenas().length);
    }

    @Test
    void agregarYEliminarFavoritosArregloDinamico() {
        Favorito f1 = new Favorito();
        f1.setIdFavorito(10);

        usuario.agregarAFavoritos(f1);
        assertEquals(1, usuario.getFavoritos().length);

        assertTrue(usuario.eliminarFavorito(10));
        assertEquals(0, usuario.getFavoritos().length);
    }

    @Test
    void registrarResenaAsociacionBidireccional() {
        Resena resena = new Resena();
        usuario.registrarResena(resena);

        assertEquals(1, usuario.getResenas().length);
        assertEquals(usuario, resena.getUsuario()); // Verifica la bidireccionalidad
    }

    @Test
    void registrarResenaNullNoAgrega() {
        usuario.registrarResena(null);
        assertEquals(0, usuario.getResenas().length);
    }

    @Test
    void testToString() {
        String resultado = usuario.toString();
        assertTrue(resultado.contains("Carlos Torres"));
        assertTrue(resultado.contains("1"));
        assertTrue(resultado.contains("Favoritos: 0"));
    }
}