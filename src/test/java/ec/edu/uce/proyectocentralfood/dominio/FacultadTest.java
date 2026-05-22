package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacultadTest {

    Ubicacion ubicacion = new Ubicacion(
            "Av. Universitaria",
            -0.210,
            -78.490,
            "Frente a la facultad"
    );

    Facultad facultad = new Facultad(
            "Facultad de Ingeniería",
            "Facultad principal",
            ubicacion
    );

    @Test
    void getNombre() {
        assertEquals("Facultad de Ingeniería", facultad.getNombre());
    }

    @Test
    void setNombre() {
        facultad.setNombre("Facultad de Medicina");
        assertEquals("Facultad de Medicina", facultad.getNombre());
    }

    @Test
    void getDescripcion() {
        assertEquals("Facultad principal", facultad.getDescripcion());
    }

    @Test
    void setDescripcion() {
        facultad.setDescripcion("Nueva descripción");
        assertEquals("Nueva descripción", facultad.getDescripcion());
    }

    @Test
    void getUbicacion() {
        assertEquals(ubicacion, facultad.getUbicacion());
    }

    @Test
    void setUbicacion() {

        Ubicacion nuevaUbicacion = new Ubicacion(
                "Calle Principal",
                -0.300,
                -78.500,
                "Junto al parque"
        );

        facultad.setUbicacion(nuevaUbicacion);

        assertEquals(nuevaUbicacion, facultad.getUbicacion());
    }

    @Test
    void testToString() {
        assertTrue(facultad.toString().contains("Facultad de Ingeniería"));
    }
}