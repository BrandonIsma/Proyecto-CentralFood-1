package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalExternoTest {

    @Test
    void getCallePrincipal() {
        LocalExterno local = new LocalExterno();
        // Verifica que el constructor vacío asigne el valor por defecto
        assertEquals("Sin asignar", local.getCallePrincipal());
    }

    @Test
    void setCallePrincipal() {
        LocalExterno local = new LocalExterno();

        // Escenario positivo: asignación correcta
        assertTrue(local.setCallePrincipal("Av. América"));
        assertEquals("Av. América", local.getCallePrincipal());

        // Escenarios negativos: cadenas vacías, espacios o nulos
        assertFalse(local.setCallePrincipal(""));
        assertFalse(local.setCallePrincipal("   "));
        assertFalse(local.setCallePrincipal(null));

        // Verifica que el valor no se haya sobrescrito con datos inválidos
        assertEquals("Av. América", local.getCallePrincipal());
    }

    @Test
    void isEsHuecaTradicional() {
        LocalExterno local = new LocalExterno();
        // Verifica el valor por defecto establecido en el constructor
        assertFalse(local.isEsHuecaTradicional());
    }

    @Test
    void setEsHuecaTradicional() {
        LocalExterno local = new LocalExterno();

        local.setEsHuecaTradicional(true);
        assertTrue(local.isEsHuecaTradicional());

        local.setEsHuecaTradicional(false);
        assertFalse(local.isEsHuecaTradicional());
    }

    @Test
    void promocionarLocal() {
        LocalExterno local = new LocalExterno();

        // Caso 1: Es una hueca tradicional
        local.setEsHuecaTradicional(true);
        assertEquals("⭐ ¡Hueca Tradicional Recomendada por la comunidad!", local.promocionarLocal());

        // Caso 2: No es una hueca tradicional
        local.setEsHuecaTradicional(false);
        assertEquals("Local ubicado en los alrededores de la UCE.", local.promocionarLocal());
    }

    @Test
    void testToString() {
        LocalExterno local = new LocalExterno();
        local.setCallePrincipal("Bolivia y Universitaria");
        local.setEsHuecaTradicional(true);

        String resultado = local.toString();

        // Verificamos que contenga los fragmentos de texto exactos
        assertNotNull(resultado);
        assertTrue(resultado.contains("[INFO EXTERNA]"));
        assertTrue(resultado.contains("Calle: 'Bolivia y Universitaria'"));
        assertTrue(resultado.contains("⭐ ¡Hueca Tradicional Recomendada por la comunidad!"));
    }
}