package ec.edu.uce.proyectocentralfood.util;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorTest {

    // ─── esIdPersonaValido ───
    @Test
    void idPersonaValido() { assertTrue(Validador.esIdPersonaValido(1)); }

    @Test
    void idPersonaInvalido() {
        assertFalse(Validador.esIdPersonaValido(0));
        assertFalse(Validador.esIdPersonaValido(-1));
    }

    // ─── esNombreValido ───
    @Test
    void nombreValido() { assertTrue(Validador.esNombreValido("Juan Pérez")); }

    @Test
    void nombreInvalido() {
        assertFalse(Validador.esNombreValido(null));
        assertFalse(Validador.esNombreValido(""));
        assertFalse(Validador.esNombreValido("J"));        // menos de 2 chars
        assertFalse(Validador.esNombreValido("Juan123"));  // contiene números
    }

    // ─── esCorreoUCEValido ───
    @Test
    void correoUCEValido() { assertTrue(Validador.esCorreoUCEValido("juan.perez@uce.edu.ec")); }

    @Test
    void correoUCEInvalido() {
        assertFalse(Validador.esCorreoUCEValido("juan@gmail.com"));
        assertFalse(Validador.esCorreoUCEValido(null));
        assertFalse(Validador.esCorreoUCEValido(""));
    }

    // ─── esFechaNacimientoValida ───
    @Test
    void fechaNacimientoValida() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.JANUARY, 1);
        assertTrue(Validador.esFechaNacimientoValida(cal.getTime())); // fecha pasada real
    }

    @Test
    void fechaNacimientoNullInvalida() {
        assertFalse(Validador.esFechaNacimientoValida(null));
    }

    // ─── esCodigoAdministradorValido ───
    @Test
    void codigoAdminValido() { assertTrue(Validador.esCodigoAdministradorValido("ADM-001")); }

    @Test
    void codigoAdminInvalido() {
        assertFalse(Validador.esCodigoAdministradorValido("ADM001"));
        assertFalse(Validador.esCodigoAdministradorValido("adm-001"));
        assertFalse(Validador.esCodigoAdministradorValido(null));
    }

    // ─── esCalificacionValida ───
    @Test
    void calificacionValida() {
        assertTrue(Validador.esCalificacionValida(1));
        assertTrue(Validador.esCalificacionValida(5));
    }

    @Test
    void calificacionInvalida() {
        assertFalse(Validador.esCalificacionValida(0));
        assertFalse(Validador.esCalificacionValida(6));
    }

    // ─── esComentarioResenaValido ───
    @Test
    void comentarioValido() { assertTrue(Validador.esComentarioResenaValido("Muy buena atención y comida.")); }

    @Test
    void comentarioInvalido() {
        assertFalse(Validador.esComentarioResenaValido(null));
        assertFalse(Validador.esComentarioResenaValido(""));
        assertFalse(Validador.esComentarioResenaValido("Mal")); // menos de 5 chars
    }

    // ─── esTelefonoValido ───
    @Test
    void telefonoValido() { assertTrue(Validador.esTelefonoValido("0987654321")); }

    @Test
    void telefonoInvalido() {
        assertFalse(Validador.esTelefonoValido("123456789"));
        assertFalse(Validador.esTelefonoValido(null));
    }

    // ─── esHorarioAtencionValido ───
    @Test
    void horarioValido() { assertTrue(Validador.esHorarioAtencionValido("08:00-16:00")); }

    @Test
    void horarioInvalido() {
        assertFalse(Validador.esHorarioAtencionValido("8:00-16:00"));
        assertFalse(Validador.esHorarioAtencionValido(null));
    }

    // ─── esEstadoLocalValido ───
    @Test
    void estadoLocalValido() {
        assertTrue(Validador.esEstadoLocalValido("ABIERTO"));
        assertTrue(Validador.esEstadoLocalValido("abierto")); // acepta minúsculas
    }

    @Test
    void estadoLocalInvalido() {
        assertFalse(Validador.esEstadoLocalValido("PENDIENTE"));
        assertFalse(Validador.esEstadoLocalValido(null));
    }

    // ─── esRangoPrecioValido ───
    @Test
    void rangoPrecioValido() {
        assertTrue(Validador.esRangoPrecioValido("BAJO"));
        assertTrue(Validador.esRangoPrecioValido("bajo")); // acepta minúsculas
    }

    @Test
    void rangoPrecioInvalido() {
        assertFalse(Validador.esRangoPrecioValido("GRATIS"));
        assertFalse(Validador.esRangoPrecioValido(null));
    }

    // ─── esPrecioPlatoValido ───
    @Test
    void precioValido() { assertTrue(Validador.esPrecioPlatoValido(2.50)); }

    @Test
    void precioInvalido() {
        assertFalse(Validador.esPrecioPlatoValido(0));
        assertFalse(Validador.esPrecioPlatoValido(-1));
    }

    // ─── esLatitudValida / esLongitudValida ───
    @Test
    void latitudValida() {
        assertTrue(Validador.esLatitudValida(0));
        assertTrue(Validador.esLatitudValida(-90));
        assertTrue(Validador.esLatitudValida(90));
    }

    @Test
    void latitudInvalida() {
        assertFalse(Validador.esLatitudValida(91));
        assertFalse(Validador.esLatitudValida(-91));
    }

    @Test
    void longitudValida() {
        assertTrue(Validador.esLongitudValida(0));
        assertTrue(Validador.esLongitudValida(180));
        assertTrue(Validador.esLongitudValida(-180));
    }

    @Test
    void longitudInvalida() {
        assertFalse(Validador.esLongitudValida(181));
        assertFalse(Validador.esLongitudValida(-181));
    }

    // ─── esDireccionValida ───
    @Test
    void direccionValida() { assertTrue(Validador.esDireccionValida("Av. América y Av. Universitaria")); }

    @Test
    void direccionInvalida() {
        assertFalse(Validador.esDireccionValida(null));
        assertFalse(Validador.esDireccionValida("Av")); // menos de 5 chars
    }
}