package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UbicacionTest {

    private Ubicacion ubicacion;

    @BeforeEach
    void setUp() {
        ubicacion = new Ubicacion("Av. América y Universitaria", -0.2105, -78.5009, "Frente al parque central");
    }

    @Test
    void getDireccion() {
        assertEquals("Av. América y Universitaria", ubicacion.getDireccion());
    }

    @Test
    void setDireccionValida() {
        assertTrue(ubicacion.setDireccion("Calle Universitaria N23-45"));
        assertEquals("Calle Universitaria N23-45", ubicacion.getDireccion());
    }

    @Test
    void setDireccionInvalidaFondo() {
        assertFalse(ubicacion.setDireccion(null));
        assertFalse(ubicacion.setDireccion("   "));
        assertEquals("Av. América y Universitaria", ubicacion.getDireccion());
    }

    @Test
    void getLatitud() {
        assertEquals(-0.2105, ubicacion.getLatitud());
    }

    @Test
    void setLatitudValida() {
        assertTrue(ubicacion.setLatitud(0));
        assertTrue(ubicacion.setLatitud(90));
        assertTrue(ubicacion.setLatitud(-90));
    }

    @Test
    void setLatitudInvalida() {
        assertFalse(ubicacion.setLatitud(91));
        assertFalse(ubicacion.setLatitud(-91));
        assertEquals(-0.2105, ubicacion.getLatitud());
    }

    @Test
    void getLongitud() {
        assertEquals(-78.5009, ubicacion.getLongitud());
    }

    @Test
    void setLongitudValida() {
        assertTrue(ubicacion.setLongitud(0));
        assertTrue(ubicacion.setLongitud(180));
        assertTrue(ubicacion.setLongitud(-180));
    }

    @Test
    void setLongitudInvalida() {
        assertFalse(ubicacion.setLongitud(181));
        assertFalse(ubicacion.setLongitud(-181));
        assertEquals(-78.5009, ubicacion.getLongitud());
    }

    @Test
    void getReferenciaTextual() {
        assertEquals("Frente al parque central", ubicacion.getReferenciaTextual());
    }

    @Test
    void setReferenciaTextualValida() {
        assertTrue(ubicacion.setReferenciaTextual("Junto a la biblioteca principal de la UCE"));
        assertEquals("Junto a la biblioteca principal de la UCE", ubicacion.getReferenciaTextual());
    }

    @Test
    void setReferenciaTextualInvalidaFondo() {
        assertFalse(ubicacion.setReferenciaTextual(null));
        assertFalse(ubicacion.setReferenciaTextual(""));
        assertEquals("Frente al parque central", ubicacion.getReferenciaTextual());
    }

    @Test
    void getSetFacultad() {
        Facultad facultad = new Facultad("Ingeniería", "Descripción válida larga aquí.");
        ubicacion.setFacultad(facultad);
        assertEquals(facultad, ubicacion.getFacultad());
    }

    @Test
    void getSetLocalComida() {
        LocalComida local = new LocalComida();
        ubicacion.setLocalComida(local);
        assertEquals(local, ubicacion.getLocalComida());
    }

    @Test
    void constructorVacioNoDaError() {
        Ubicacion vacia = new Ubicacion();
        assertEquals("Sin dirección", vacia.getDireccion());
        assertEquals(0.0, vacia.getLatitud());
    }

    @Test
    void testToString() {
        String resultado = ubicacion.toString();
        assertTrue(resultado.contains("Av. América y Universitaria"));
        assertTrue(resultado.contains("-0.2105"));
    }
}