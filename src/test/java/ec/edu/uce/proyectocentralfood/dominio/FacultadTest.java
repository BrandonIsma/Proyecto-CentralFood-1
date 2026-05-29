package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FacultadTest {

    private Facultad facultad;
    private Ubicacion ubicacion;

    @BeforeEach
    void setUp() {
        ubicacion = new Ubicacion("Av. América y Universitaria", -0.2105, -78.5009, "Frente al parque central");
        facultad = new Facultad("Facultad de Ingeniería", "Facultad dedicada a ingeniería y tecnología", ubicacion);
    }

    @Test
    void getNombre() {
        assertEquals("Facultad de Ingeniería", facultad.getNombre());
    }

    @Test
    void setNombreValido() {
        assertTrue(facultad.setNombre("Facultad de Ciencias"));
        assertEquals("Facultad de Ciencias", facultad.getNombre());
    }

    @Test
    void setNombreInvalido() {
        assertFalse(facultad.setNombre(null));
        assertFalse(facultad.setNombre(""));
        assertEquals("Facultad de Ingeniería", facultad.getNombre());
    }

    @Test
    void getDescripcion() {
        assertEquals("Facultad dedicada a ingeniería y tecnología", facultad.getDescripcion());
    }

    @Test
    void setDescripcionValida() {
        assertTrue(facultad.setDescripcion("Facultad con enfoque en ciencias exactas y aplicadas."));
        assertEquals("Facultad con enfoque en ciencias exactas y aplicadas.", facultad.getDescripcion());
    }

    @Test
    void setDescripcionInvalida() {
        assertFalse(facultad.setDescripcion(null));
        assertFalse(facultad.setDescripcion(""));
        assertEquals("Facultad dedicada a ingeniería y tecnología", facultad.getDescripcion());
    }

    @Test
    void getUbicacion() {
        assertEquals(ubicacion, facultad.getUbicacion());
    }

    @Test
    void setUbicacionValida() {
        Ubicacion nueva = new Ubicacion("Calle Universitaria N23-45", -0.2200, -78.5100, "Cerca de la biblioteca");
        assertTrue(facultad.setUbicacion(nueva));
        assertEquals(nueva, facultad.getUbicacion());
    }

    @Test
    void setUbicacionNullNoModifica() {
        assertFalse(facultad.setUbicacion(null));
        assertEquals(ubicacion, facultad.getUbicacion());
    }

    @Test
    void testToStringConUbicacion() {
        String resultado = facultad.toString();
        assertTrue(resultado.contains("Facultad de Ingeniería"));
        assertTrue(resultado.contains("Av. América y Universitaria"));
    }

    @Test
    void testToStringSinUbicacion() {
        Facultad sinUbicacion = new Facultad("Facultad de Ciencias", "Descripción válida larga", null);
        assertTrue(sinUbicacion.toString().contains("No asignada"));
    }
}