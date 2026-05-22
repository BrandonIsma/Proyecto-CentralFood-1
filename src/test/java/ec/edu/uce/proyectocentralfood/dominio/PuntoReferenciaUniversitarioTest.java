package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuntoReferenciaUniversitarioTest {

    @Test
    void getNombre() {

        PuntoReferenciaUniversitario punto =
                new PuntoReferenciaUniversitario(
                        "Biblioteca Central",
                        "Ubicada junto a la facultad"
                );

        assertEquals("Biblioteca Central", punto.getNombre());
    }

    @Test
    void setNombre() {

        PuntoReferenciaUniversitario punto =
                new PuntoReferenciaUniversitario(
                        "Biblioteca Central",
                        "Ubicada junto a la facultad"
                );

        punto.setNombre("Parque Universitario");

        assertEquals("Parque Universitario", punto.getNombre());
    }

    @Test
    void getDescripcion() {

        PuntoReferenciaUniversitario punto =
                new PuntoReferenciaUniversitario(
                        "Biblioteca Central",
                        "Ubicada junto a la facultad"
                );

        assertEquals("Ubicada junto a la facultad", punto.getDescripcion());
    }

    @Test
    void setDescripcion() {

        PuntoReferenciaUniversitario punto =
                new PuntoReferenciaUniversitario(
                        "Biblioteca Central",
                        "Ubicada junto a la facultad"
                );

        punto.setDescripcion("Frente al edificio principal");

        assertEquals("Frente al edificio principal", punto.getDescripcion());
    }

    @Test
    void testToString() {

        PuntoReferenciaUniversitario punto =
                new PuntoReferenciaUniversitario(
                        "Biblioteca Central",
                        "Ubicada junto a la facultad"
                );

        String esperado = "PuntoReferenciaUniversitario{" +
                "nombre='Biblioteca Central'" +
                ", descripcion='Ubicada junto a la facultad'" +
                '}';

        assertEquals(esperado, punto.toString());
    }
}