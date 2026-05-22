package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CategoriaGastronomicaTest {

    private CategoriaGastronomica categoria;

    @BeforeEach
    void setUp() {
        categoria = new CategoriaGastronomica(1, "Italiana", "Comida tradicional italiana con pastas y pizzas.", new Plato[0], new LocalComida[0]);
    }

    @Test
    void getIdCategoria() {
        assertEquals(1, categoria.getIdCategoria());
    }

    @Test
    void setIdCategoriaValido() {
        assertTrue(categoria.setIdCategoria(3));
        assertEquals(3, categoria.getIdCategoria());
    }

    @Test
    void setIdCategoriaInvalido() {
        assertFalse(categoria.setIdCategoria(0));
        assertFalse(categoria.setIdCategoria(-1));
        assertEquals(1, categoria.getIdCategoria());
    }

    @Test
    void getNombreCategoria() {
        assertEquals("Italiana", categoria.getNombreCategoria());
    }

    @Test
    void setNombreCategoriaValido() {
        assertTrue(categoria.setNombreCategoria("Mexicana"));
        assertEquals("Mexicana", categoria.getNombreCategoria());
    }

    @Test
    void setNombreCategoriaInvalido() {
        assertFalse(categoria.setNombreCategoria(null));
        assertFalse(categoria.setNombreCategoria(""));
        assertFalse(categoria.setNombreCategoria("A")); // menos de 2 chars
        assertEquals("Italiana", categoria.getNombreCategoria());
    }

    @Test
    void getDescripcion() {
        assertEquals("Comida tradicional italiana con pastas y pizzas.", categoria.getDescripcion());
    }

    @Test
    void setDescripcionValida() {
        assertTrue(categoria.setDescripcion("Cocina mexicana con sabores picantes y coloridos."));
        assertEquals("Cocina mexicana con sabores picantes y coloridos.", categoria.getDescripcion());
    }

    @Test
    void setDescripcionInvalida() {
        assertFalse(categoria.setDescripcion(null));
        assertFalse(categoria.setDescripcion("Mal")); // menos de 5 chars
        assertEquals("Comida tradicional italiana con pastas y pizzas.", categoria.getDescripcion());
    }

    @Test
    void setPlatosValido() {
        Plato[] platos = {new Plato(), new Plato()};
        assertTrue(categoria.setPlatos(platos));
        assertEquals(2, categoria.getPlatos().length);
    }

    @Test
    void setPlatosNullNoModifica() {
        Plato[] originales = new Plato[0];
        categoria.setPlatos(originales);
        assertFalse(categoria.setPlatos(null));
        assertNotNull(categoria.getPlatos());
    }

    @Test
    void setLocalesValido() {
        LocalComida[] locales = {new LocalComida(), new LocalComida()};
        assertTrue(categoria.setLocales(locales));
        assertEquals(2, categoria.getLocales().length);
    }

    @Test
    void setLocalesNullNoModifica() {
        assertFalse(categoria.setLocales(null));
    }

    @Test
    void constructorVacioNoDaError() {
        CategoriaGastronomica vacia = new CategoriaGastronomica();
        assertEquals(0, vacia.getIdCategoria());
        assertNull(vacia.getNombreCategoria());
    }

    @Test
    void testToString() {
        String resultado = categoria.toString();
        assertTrue(resultado.contains("Italiana"));
        assertTrue(resultado.contains("Cantidad de Platos: 0"));
        assertTrue(resultado.contains("Cantidad de Locales: 0"));
    }

    @Test
    void testToStringConRelaciones() {
        categoria.setPlatos(new Plato[]{new Plato(), new Plato()});
        categoria.setLocales(new LocalComida[]{new LocalComida()});
        assertTrue(categoria.toString().contains("Cantidad de Platos: 2"));
        assertTrue(categoria.toString().contains("Cantidad de Locales: 1"));
    }
}