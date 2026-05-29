package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CentroComidaTest {

    private CentroComida centro;

    @BeforeEach
    void setUp() {
        centro = new CentroComida(
                "Juan Pérez",
                new Cuenta[]{new Cuenta()},
                new LocalComida[]{new LocalComida()},
                new CategoriaGastronomica[]{new CategoriaGastronomica()},
                new Facultad[]{}
        );
    }

    @Test
    void getNombre() {
        assertEquals("Juan Pérez", centro.getNombre());
    }

    @Test
    void setNombreValido() {
        assertTrue(centro.setNombre("María López"));
        assertEquals("María López", centro.getNombre());
    }

    @Test
    void setNombreInvalido() {
        assertFalse(centro.setNombre(null));
        assertFalse(centro.setNombre(""));
        assertFalse(centro.setNombre("J123")); // contiene números
        assertEquals("Juan Pérez", centro.getNombre());
    }

    @Test
    void setCuentasValido() {
        Cuenta[] cuentas = {new Cuenta(), new Cuenta()};
        assertTrue(centro.setCuentas(cuentas));
        assertEquals(2, centro.getCuentas().length);
    }

    @Test
    void setCuentasNullNoModifica() {
        assertFalse(centro.setCuentas(null));
        assertNotNull(centro.getCuentas());
    }

    @Test
    void setLocalesValido() {
        LocalComida[] locales = {new LocalComida(), new LocalComida()};
        assertTrue(centro.setLocales(locales));
        assertEquals(2, centro.getLocales().length);
    }

    @Test
    void setLocalesNullNoModifica() {
        assertFalse(centro.setLocales(null));
        assertNotNull(centro.getLocales());
    }

    @Test
    void setCategoriasValido() {
        CategoriaGastronomica[] cats = {new CategoriaGastronomica()};
        assertTrue(centro.setCategorias(cats));
        assertEquals(1, centro.getCategorias().length);
    }

    @Test
    void setCategoriasNullNoModifica() {
        assertFalse(centro.setCategorias(null));
        assertNotNull(centro.getCategorias());
    }

    @Test
    void setFacultadesValido() {
        Facultad[] facultades = {new Facultad("Ingeniería", "Descripción válida larga.", null)};
        assertTrue(centro.setFacultades(facultades));
        assertEquals(1, centro.getFacultades().length);
    }

    @Test
    void setFacultadesNullNoModifica() {
        assertFalse(centro.setFacultades(null));
        assertNotNull(centro.getFacultades());
    }

    @Test
    void metodosVoidNoDanError() {
        assertDoesNotThrow(() -> centro.crearCategoria());
        assertDoesNotThrow(() -> centro.actualizarCategoria());
        assertDoesNotThrow(() -> centro.eliminarCategoria());
        assertDoesNotThrow(() -> centro.crearFacultad());
        assertDoesNotThrow(() -> centro.actualizarFacultad());
        assertDoesNotThrow(() -> centro.eliminarFacultad());
        assertDoesNotThrow(() -> centro.crearLocal());
        assertDoesNotThrow(() -> centro.actualizarLocal());
        assertDoesNotThrow(() -> centro.eliminarLocal());
        assertDoesNotThrow(() -> centro.crearPlato());
        assertDoesNotThrow(() -> centro.actualizarPlato());
        assertDoesNotThrow(() -> centro.eliminarPlato());
        assertDoesNotThrow(() -> centro.moderarResena());
        assertDoesNotThrow(() -> centro.gestionarUsuario());
    }

    @Test
    void constructorVacioNoDaError() {
        CentroComida vacio = new CentroComida();
        assertNull(vacio.getNombre());
        assertNull(vacio.getCuentas());
    }

    @Test
    void testToString() {
        String resultado = centro.toString();
        assertTrue(resultado.contains("Juan Pérez"));
        assertTrue(resultado.contains("Cuentas: 1"));
        assertTrue(resultado.contains("Locales: 1"));
    }
}