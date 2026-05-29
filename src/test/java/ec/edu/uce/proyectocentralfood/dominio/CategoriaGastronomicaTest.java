package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CategoriaGastronomicaTest {

    private CategoriaGastronomica categoria;

    @BeforeEach
    void setUp() {
        categoria = new CategoriaGastronomica(1, "Italiana", "Comida tradicional italiana con pastas y pizzas.");
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
        assertEquals(1, categoria.getIdCategoria()); // No debe cambiar
    }

    @Test
    void setNombreCategoriaValido() {
        assertTrue(categoria.setNombreCategoria("Mexicana"));
        assertEquals("Mexicana", categoria.getNombreCategoria());
    }

    @Test
    void setNombreCategoriaInvalidoFondo() {
        // Solo rechaza nulos o vacíos según la nueva regla
        assertFalse(categoria.setNombreCategoria(null));
        assertFalse(categoria.setNombreCategoria(""));
        assertEquals("Italiana", categoria.getNombreCategoria());
    }

    @Test
    void setDescripcionValida() {
        assertTrue(categoria.setDescripcion("Cocina mexicana"));
        assertEquals("Cocina mexicana", categoria.getDescripcion());
    }

    @Test
    void setDescripcionInvalidaFondo() {
        assertFalse(categoria.setDescripcion(null));
        assertFalse(categoria.setDescripcion("   "));
        assertEquals("Comida tradicional italiana con pastas y pizzas.", categoria.getDescripcion());
    }

    @Test
    void constructorVacioNoDaError() {
        CategoriaGastronomica vacia = new CategoriaGastronomica();
        assertEquals(0, vacia.getIdCategoria());
        assertEquals("Sin nombre", vacia.getNombreCategoria());
    }

    @Test
    void testToString() {
        String resultado = categoria.toString();
        assertTrue(resultado.contains("Italiana"));
        assertTrue(resultado.contains("ID: 1"));
    }
}