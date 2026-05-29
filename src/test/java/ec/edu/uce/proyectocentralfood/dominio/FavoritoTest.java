package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FavoritoTest {

    @Test
    void setIdFavoritoInvalido() {
        Favorito favorito = new Favorito();
        favorito.setIdFavorito(100);
        assertFalse(favorito.setIdFavorito(-5));
        assertEquals(100, favorito.getIdFavorito());
    }

    @Test
    void setFechaAgregadoInvalida() {
        Favorito favorito = new Favorito();
        favorito.setFechaAgregado(20260101);
        assertFalse(favorito.setFechaAgregado(-1));
        assertEquals(20260101, favorito.getFechaAgregado());
    }

    @Test
    void getSetLocal() {
        Favorito favorito = new Favorito();
        LocalComida local = new LocalComida();
        local.setNombre("Burger UCE");

        favorito.setLocal(local);
        assertNotNull(favorito.getLocal());
        assertEquals("Burger UCE", favorito.getLocal().getNombre());
    }

    @Test
    void constructorVacio() {
        Favorito favorito = new Favorito();
        assertEquals(0, favorito.getIdFavorito());
        assertEquals(0, favorito.getFechaAgregado());
        assertNotNull(favorito.getLocal()); // Se inicializa para evitar nulos
    }

    @Test
    void constructorConParametros() {
        LocalComida local = new LocalComida();
        local.setIdLocal(100);
        Favorito favorito = new Favorito(1, 20260521, local);

        assertEquals(1, favorito.getIdFavorito());
        assertEquals(20260521, favorito.getFechaAgregado());
        assertEquals(local, favorito.getLocal());
    }

    @Test
    void testToString() {
        LocalComida local = new LocalComida();
        local.setNombre("Central Food UCE");
        Favorito favorito = new Favorito(1, 20260521, local);

        String resultado = favorito.toString();
        assertTrue(resultado.contains("1"));
        assertTrue(resultado.contains("20260521"));
        assertTrue(resultado.contains("Central Food UCE"));
    }
}