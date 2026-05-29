package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CentroComidaTest {

    private CentroComida centro;

    @BeforeEach
    void setUp() {
        centro = new CentroComida(
                "Principal UCE",
                new Cuenta[]{new Cuenta()},
                new LocalComida[]{new LocalComida()},
                new CategoriaGastronomica[]{new CategoriaGastronomica()},
                new Facultad[]{}
        );
    }

    @Test
    void getNombre() {
        assertEquals("Principal UCE", centro.getNombre());
    }

    @Test
    void setNombreValido() {
        assertTrue(centro.setNombre("Gestión Universitaria"));
        assertEquals("Gestión Universitaria", centro.getNombre());
    }

    @Test
    void setNombreInvalidoFondo() {
        assertFalse(centro.setNombre(null));
        assertFalse(centro.setNombre(""));
        assertEquals("Principal UCE", centro.getNombre());
    }

    @Test
    void setCuentasValido() {
        Cuenta[] cuentas = {new Cuenta(), new Cuenta()};
        centro.setCuentas(cuentas);
        assertEquals(2, centro.getCuentas().length);
    }

    @Test
    void setCuentasNullNoModifica() {
        centro.setCuentas(null);
        assertNotNull(centro.getCuentas());
    }

    @Test
    void setLocalesValido() {
        LocalComida[] locales = {new LocalComida(), new LocalComida()};
        centro.setLocales(locales);
        assertEquals(2, centro.getLocales().length);
    }

    @Test
    void setLocalesNullNoModifica() {
        centro.setLocales(null);
        assertNotNull(centro.getLocales());
    }

    @Test
    void setCategoriasValido() {
        CategoriaGastronomica[] cats = {new CategoriaGastronomica()};
        centro.setCategorias(cats);
        assertEquals(1, centro.getCategorias().length);
    }

    @Test
    void setCategoriasNullNoModifica() {
        centro.setCategorias(null);
        assertNotNull(centro.getCategorias());
    }

    @Test
    void setFacultadesValido() {
        Facultad[] facultades = {new Facultad("Ingeniería", "Descripción general.")};
        centro.setFacultades(facultades);
        assertEquals(1, centro.getFacultades().length);
    }

    @Test
    void setFacultadesNullNoModifica() {
        centro.setFacultades(null);
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
        assertEquals("Centro Principal", vacio.getNombre());
        assertNotNull(vacio.getCuentas());
        assertEquals(0, vacio.getCuentas().length);
    }

    @Test
    void testToString() {
        String resultado = centro.toString();
        assertTrue(resultado.contains("Cuentas: 1"));
        assertTrue(resultado.contains("Locales: 1"));
    }
}