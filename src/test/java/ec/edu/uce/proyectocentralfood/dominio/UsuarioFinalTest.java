package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    void getIdPersona() {
        assertEquals(1, usuario.getIdPersona());
    }

    @Test
    void setIdPersonaValido() {
        assertTrue(usuario.setIdPersona(5));
        assertEquals(5, usuario.getIdPersona());
    }

    @Test
    void setIdPersonaInvalido() {
        assertFalse(usuario.setIdPersona(0));
        assertFalse(usuario.setIdPersona(-1));
        assertEquals(1, usuario.getIdPersona());
    }

    @Test
    void getFavoritosInicialmenteVacio() {
        assertNotNull(usuario.getFavoritos());
        assertTrue(usuario.getFavoritos().isEmpty());
    }

    @Test
    void setFavoritosValido() {
        List<Favorito> lista = new ArrayList<>();
        lista.add(new Favorito());
        usuario.setFavoritos(lista);
        assertEquals(1, usuario.getFavoritos().size());
    }

    @Test
    void setFavoritosNullNoModifica() {
        usuario.setFavoritos(null);
        assertNotNull(usuario.getFavoritos());
    }

    @Test
    void getResenasInicialmenteVacio() {
        assertNotNull(usuario.getResenas());
        assertTrue(usuario.getResenas().isEmpty());
    }

    @Test
    void agregarAFavoritos() {
        Favorito favorito = new Favorito();
        usuario.agregarAFavoritos(favorito);
        assertEquals(1, usuario.getFavoritos().size());
    }

    @Test
    void agregarAFavoritosNullNoAgrega() {
        usuario.agregarAFavoritos(null);
        assertTrue(usuario.getFavoritos().isEmpty());
    }

    @Test
    void registrarResena() {
        Resena resena = new Resena();
        usuario.registrarResena(resena);
        assertEquals(1, usuario.getResenas().size());
        assertEquals(usuario, resena.getUsuario());
    }

    @Test
    void registrarResenaNullNoAgrega() {
        usuario.registrarResena(null);
        assertTrue(usuario.getResenas().isEmpty());
    }

    @Test
    void filtrarPorCategoria() {
        Plato p1 = new Plato();
        p1.setCategoria("Italiana");
        Plato p2 = new Plato();
        p2.setCategoria("Mexicana");

        List<Plato> todos = List.of(p1, p2);
        List<Plato> resultado = usuario.filtrarPorCategoria(todos, "italiana");

        assertEquals(1, resultado.size());
        assertEquals("Italiana", resultado.get(0).getCategoria());
    }

    @Test
    void filtrarPorCategoriaListaNullRetornaVacio() {
        assertTrue(usuario.filtrarPorCategoria(null, "Italiana").isEmpty());
    }

    @Test
    void filtrarPorCategoriaCategoriaNull() {
        assertTrue(usuario.filtrarPorCategoria(new ArrayList<>(), null).isEmpty());
    }

    @Test
    void constructorVacioNoDaError() {
        UsuarioFinal vacio = new UsuarioFinal();
        assertNotNull(vacio.getFavoritos());
        assertNotNull(vacio.getResenas());
    }

    @Test
    void testToString() {
        String resultado = usuario.toString();
        assertTrue(resultado.contains("Carlos Torres"));
        assertTrue(resultado.contains("1"));
    }
}
