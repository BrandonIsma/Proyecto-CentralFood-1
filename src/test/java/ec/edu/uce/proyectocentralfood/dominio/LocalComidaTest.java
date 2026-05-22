package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalComidaTest {

    LocalComida local = new LocalComida(
            1,
            "Comedor Central",
            "Comida universitaria",
            "0999999999",
            "08:00-17:00",
            "ABIERTO",
            "BAJO"
    );

    @Test
    void getIdLocal() {
        assertEquals(1, local.getIdLocal());
    }

    @Test
    void getNombre() {
        assertEquals("Comedor Central", local.getNombre());
    }

    @Test
    void setNombre() {
        local.setNombre("Cafetería UCE");
        assertEquals("Cafetería UCE", local.getNombre());
    }

    @Test
    void getTelefono() {
        assertEquals("0999999999", local.getTelefono());
    }

    @Test
    void setEstadoLocal() {
        local.setEstadoLocal("CERRADO");
        assertEquals("CERRADO", local.getEstadoLocal());
    }

    @Test
    void testToString() {
        assertTrue(local.toString().contains("Comedor Central"));
    }
}