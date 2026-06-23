package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalInternoTest {

    @Test
    void getBloque() {
        LocalInterno local = new LocalInterno();
        // Verifica que el constructor vacío inicialice correctamente
        assertEquals("Sin asignar", local.getBloque());
    }

    @Test
    void setBloque() {
        LocalInterno local = new LocalInterno();

        // Escenario positivo: asignación correcta
        assertTrue(local.setBloque("Facultad de Ingeniería - Bloque 1"));
        assertEquals("Facultad de Ingeniería - Bloque 1", local.getBloque());

        // Escenarios negativos: cadenas vacías, espacios en blanco o nulos
        assertFalse(local.setBloque(""));
        assertFalse(local.setBloque("   "));
        assertFalse(local.setBloque(null));

        // Verifica que el valor no cambió tras los intentos fallidos
        assertEquals("Facultad de Ingeniería - Bloque 1", local.getBloque());
    }

    @Test
    void isTieneMicroondas() {
        LocalInterno local = new LocalInterno();
        // Verifica valor por defecto
        assertFalse(local.isTieneMicroondas());
    }

    @Test
    void setTieneMicroondas() {
        LocalInterno local = new LocalInterno();

        local.setTieneMicroondas(true);
        assertTrue(local.isTieneMicroondas());

        local.setTieneMicroondas(false);
        assertFalse(local.isTieneMicroondas());
    }

    @Test
    void isTieneComedor() {
        LocalInterno local = new LocalInterno();
        // Verifica valor por defecto
        assertFalse(local.isTieneComedor());
    }

    @Test
    void setTieneComedor() {
        LocalInterno local = new LocalInterno();

        local.setTieneComedor(true);
        assertTrue(local.isTieneComedor());

        local.setTieneComedor(false);
        assertFalse(local.isTieneComedor());
    }

    @Test
    void consultarFacilidades() {
        LocalInterno local = new LocalInterno();

        // Caso 1: Tiene comedor y microondas
        local.setTieneComedor(true);
        local.setTieneMicroondas(true);
        assertEquals("Cuenta con mesas y microondas disponible.", local.consultarFacilidades());

        // Caso 2: Tiene comedor pero no microondas
        local.setTieneComedor(true);
        local.setTieneMicroondas(false);
        assertEquals("Cuenta con área de mesas para comer.", local.consultarFacilidades());

        // Caso 3: No tiene comedor pero sí microondas
        local.setTieneComedor(false);
        local.setTieneMicroondas(true);
        assertEquals("Solo cuenta con microondas para calentar.", local.consultarFacilidades());

        // Caso 4: No tiene ninguno
        local.setTieneComedor(false);
        local.setTieneMicroondas(false);
        assertEquals("No cuenta con área de comedor ni microondas.", local.consultarFacilidades());
    }

    @Test
    void testToString() {
        LocalInterno local = new LocalInterno();
        local.setBloque("Ciencias Básicas");
        local.setTieneComedor(true);
        local.setTieneMicroondas(false);

        String resultado = local.toString();

        // Verifica que el toString no sea nulo y contenga la información específica concatenada
        assertNotNull(resultado);
        assertTrue(resultado.contains("[INFO INTERNA]"));
        assertTrue(resultado.contains("Bloque: 'Ciencias Básicas'"));
        assertTrue(resultado.contains("Facilidades: Cuenta con área de mesas para comer."));
    }
}