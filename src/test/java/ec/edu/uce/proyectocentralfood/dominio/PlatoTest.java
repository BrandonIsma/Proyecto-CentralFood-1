package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlatoTest {

    @Test
    void getIdPlato() {
        Plato plato = new Plato();
        plato.setIdPlato(15);
        assertEquals(15, plato.getIdPlato());
    }

    @Test
    void setIdPlatoInvalido() {
        Plato plato = new Plato();
        plato.setIdPlato(10);
        assertFalse(plato.setIdPlato(-5));
        assertEquals(10, plato.getIdPlato());
    }

    @Test
    void setNombreInvalidoFondo() {
        Plato plato = new Plato();
        plato.setNombre("Locro");
        assertFalse(plato.setNombre(""));
        assertFalse(plato.setNombre(null));
        assertEquals("Locro", plato.getNombre());
    }

    @Test
    void setPrecioInvalido() {
        Plato plato = new Plato();
        plato.setPrecio(4.00);
        assertFalse(plato.setPrecio(-1.50));
        assertEquals(4.00, plato.getPrecio());
    }

    @Test
    void getCategoriaGastro() {
        Plato plato = new Plato();
        CategoriaGastronomica categoriaObj = new CategoriaGastronomica(1, "Plato Fuerte", "Desc");
        plato.setCategoriaGastro(categoriaObj);

        assertNotNull(plato.getCategoriaGastro());
        assertEquals("Plato Fuerte", plato.getCategoriaGastro().getNombreCategoria());
    }

    @Test
    void constructorConParametros() {
        CategoriaGastronomica cat = new CategoriaGastronomica(1, "Desayuno", "Desc");
        Plato plato = new Plato(1, "Bolon", "Bolon de chicharron", 2.50, 20260521, cat);

        assertEquals(1, plato.getIdPlato());
        assertEquals("Bolon", plato.getNombre());
        assertEquals(2.50, plato.getPrecio());
        assertEquals(20260521, plato.getFechaActualizacion());
        assertEquals(cat, plato.getCategoriaGastro());
    }

    @Test
    void testToString() {
        CategoriaGastronomica cat = new CategoriaGastronomica(1, "Plato Fuerte", "Desc");
        Plato plato = new Plato(5, "Fritada", "Fritada tipica", 6.00, 20260521, cat);

        String resultado = plato.toString();
        assertTrue(resultado.contains("5"));
        assertTrue(resultado.contains("Fritada"));
        assertTrue(resultado.contains("6.0"));
        assertTrue(resultado.contains("Plato Fuerte"));
    }
}