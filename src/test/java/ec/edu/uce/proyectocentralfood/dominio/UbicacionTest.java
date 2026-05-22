package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UbicacionTest {

    Ubicacion ubicacion = new Ubicacion(
            "Av. Universitaria",
            -0.210,
            -78.490,
            "Frente a la facultad"
    );

    @Test
    void getDireccion() {
        assertEquals("Av. Universitaria", ubicacion.getDireccion());
    }

    @Test
    void setDireccion() {
        ubicacion.setDireccion("Calle Principal");
        assertEquals("Calle Principal", ubicacion.getDireccion());
    }

    @Test
    void getLatitud() {
        assertEquals(-0.210, ubicacion.getLatitud());
    }

    @Test
    void setLatitud() {
        ubicacion.setLatitud(-0.300);
        assertEquals(-0.300, ubicacion.getLatitud());
    }

    @Test
    void getLongitud() {
        assertEquals(-78.490, ubicacion.getLongitud());
    }

    @Test
    void setLongitud() {
        ubicacion.setLongitud(-78.500);
        assertEquals(-78.500, ubicacion.getLongitud());
    }

    @Test
    void getReferenciaTextual() {
        assertEquals("Frente a la facultad", ubicacion.getReferenciaTextual());
    }

    @Test
    void setReferenciaTextual() {
        ubicacion.setReferenciaTextual("Junto al parque");
        assertEquals("Junto al parque", ubicacion.getReferenciaTextual());
    }

    @Test
    void getFacultad() {
        assertNull(ubicacion.getFacultad());
    }

    @Test
    void setFacultad() {

        Facultad facultad = new Facultad();

        ubicacion.setFacultad(facultad);

        assertEquals(facultad, ubicacion.getFacultad());
    }

    @Test
    void getLocalComida() {
        assertNull(ubicacion.getLocalComida());
    }

    @Test
    void setLocalComida() {

        LocalComida local = new LocalComida(
                1,
                "Comedor Central",
                "Comida universitaria",
                "0999999999",
                "08:00-17:00",
                "ABIERTO",
                "BAJO"
        );

        ubicacion.setLocalComida(local);

        assertEquals(local, ubicacion.getLocalComida());
    }

    @Test
    void testToString() {
        assertTrue(ubicacion.toString().contains("Av. Universitaria"));
    }
}