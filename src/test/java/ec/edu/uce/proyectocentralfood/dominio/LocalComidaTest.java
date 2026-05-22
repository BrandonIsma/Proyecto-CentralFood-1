package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LocalComidaTest {

    private LocalComida local;

    @BeforeEach
    void setUp() {
        local = new LocalComida(1, "Central Burgers", "Hamburguesas universitarias de calidad.", "0987654321", "08:00-16:00", "ABIERTO", "MEDIO");
    }

    @Test
    void getIdLocal() {
        assertEquals(1, local.getIdLocal());
    }

    @Test
    void setIdLocalValido() {
        assertTrue(local.setIdLocal(5));
        assertEquals(5, local.getIdLocal());
    }

    @Test
    void setIdLocalInvalido() {
        assertFalse(local.setIdLocal(0));
        assertFalse(local.setIdLocal(-1));
        assertEquals(1, local.getIdLocal());
    }

    @Test
    void getNombre() {
        assertEquals("Central Burgers", local.getNombre());
    }

    @Test
    void setNombreValido() {
        assertTrue(local.setNombre("Café Universitario"));
        assertEquals("Café Universitario", local.getNombre());
    }

    @Test
    void setNombreInvalido() {
        assertFalse(local.setNombre(null));
        assertFalse(local.setNombre(""));
        assertEquals("Central Burgers", local.getNombre());
    }

    @Test
    void getDescripcion() {
        assertEquals("Hamburguesas universitarias de calidad.", local.getDescripcion());
    }

    @Test
    void setDescripcionValida() {
        assertTrue(local.setDescripcion("Comida rápida con ingredientes frescos y naturales."));
        assertEquals("Comida rápida con ingredientes frescos y naturales.", local.getDescripcion());
    }

    @Test
    void setDescripcionInvalida() {
        assertFalse(local.setDescripcion(null));
        assertFalse(local.setDescripcion("Mal")); // menos de 5 chars
        assertEquals("Hamburguesas universitarias de calidad.", local.getDescripcion());
    }

    @Test
    void getTelefono() {
        assertEquals("0987654321", local.getTelefono());
    }

    @Test
    void setTelefonoValido() {
        assertTrue(local.setTelefono("0912345678"));
        assertEquals("0912345678", local.getTelefono());
    }

    @Test
    void setTelefonoInvalido() {
        assertFalse(local.setTelefono("123456789"));
        assertFalse(local.setTelefono(null));
        assertEquals("0987654321", local.getTelefono());
    }

    @Test
    void getHorarioAtencion() {
        assertEquals("08:00-16:00", local.getHorarioAtencion());
    }

    @Test
    void setHorarioAtencionValido() {
        assertTrue(local.setHorarioAtencion("07:00-15:00"));
        assertEquals("07:00-15:00", local.getHorarioAtencion());
    }

    @Test
    void setHorarioAtencionInvalido() {
        assertFalse(local.setHorarioAtencion("8:00-16:00")); // formato incorrecto
        assertFalse(local.setHorarioAtencion(null));
        assertEquals("08:00-16:00", local.getHorarioAtencion());
    }

    @Test
    void getEstadoLocal() {
        assertEquals("ABIERTO", local.getEstadoLocal());
    }

    @Test
    void setEstadoLocalValido() {
        assertTrue(local.setEstadoLocal("CERRADO"));
        assertEquals("CERRADO", local.getEstadoLocal());
    }

    @Test
    void setEstadoLocalInvalido() {
        assertFalse(local.setEstadoLocal("PENDIENTE"));
        assertFalse(local.setEstadoLocal(null));
        assertEquals("ABIERTO", local.getEstadoLocal());
    }

    @Test
    void getRangoPrecio() {
        assertEquals("MEDIO", local.getRangoPrecio());
    }

    @Test
    void setRangoPrecioValido() {
        assertTrue(local.setRangoPrecio("ALTO"));
        assertEquals("ALTO", local.getRangoPrecio());
    }

    @Test
    void setRangoPrecioInvalido() {
        assertFalse(local.setRangoPrecio("GRATIS"));
        assertFalse(local.setRangoPrecio(null));
        assertEquals("MEDIO", local.getRangoPrecio());
    }

    @Test
    void getSetUbicacion() {
        Ubicacion ub = new Ubicacion("Av. América y Universitaria", -0.2105, -78.5009, "Frente al parque central");
        local.setUbicacion(ub);
        assertEquals(ub, local.getUbicacion());
    }

    @Test
    void getPlatosInicialmenteVacio() {
        assertNotNull(local.getPlatos());
        assertTrue(local.getPlatos().isEmpty());
    }

    @Test
    void setPlatosValido() {
        List<Plato> lista = new ArrayList<>();
        lista.add(new Plato());
        local.setPlatos(lista);
        assertEquals(1, local.getPlatos().size());
    }

    @Test
    void setPlatosNullNoModifica() {
        local.setPlatos(null);
        assertNotNull(local.getPlatos());
    }

    @Test
    void agregarPlato() {
        local.agregarPlato(new Plato());
        assertEquals(1, local.getPlatos().size());
    }

    @Test
    void agregarPlatoNullNoAgrega() {
        local.agregarPlato(null);
        assertTrue(local.getPlatos().isEmpty());
    }

    @Test
    void getResenasInicialmenteVacio() {
        assertNotNull(local.getResenas());
        assertTrue(local.getResenas().isEmpty());
    }

    @Test
    void recibirResena() {
        local.recibirResena(new Resena());
        assertEquals(1, local.getResenas().size());
    }

    @Test
    void recibirResenaNullNoAgrega() {
        local.recibirResena(null);
        assertTrue(local.getResenas().isEmpty());
    }

    @Test
    void constructorVacioNoDaError() {
        LocalComida vacio = new LocalComida();
        assertNotNull(vacio.getPlatos());
        assertNotNull(vacio.getResenas());
    }

    @Test
    void testToStringSinUbicacion() {
        String resultado = local.toString();
        assertTrue(resultado.contains("Central Burgers"));
        assertTrue(resultado.contains("ABIERTO"));
        assertTrue(resultado.contains("No asignada"));
    }

    @Test
    void testToStringConUbicacion() {
        local.setUbicacion(new Ubicacion("Av. América y Universitaria", -0.2105, -78.5009, "Frente al parque central"));
        assertTrue(local.toString().contains("Av. América y Universitaria"));
    }
}