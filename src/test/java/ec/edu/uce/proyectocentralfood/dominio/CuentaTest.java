package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    private Cuenta cuenta;
    private Date fechaValida;

    // ─────────────────────────────────────────────
    //  Fecha auxiliar: 15 de mayo del 2000
    // ─────────────────────────────────────────────
    @BeforeEach
    void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.MAY, 15);
        fechaValida = cal.getTime();

        cuenta = new Cuenta("Juan Pérez", "juan.perez@uce.edu.ec", fechaValida);
    }


    @Test
    void getNombre() {
        assertEquals("Juan Pérez", cuenta.getNombre());
    }


    @Test
    void setNombreValido() {
        assertTrue(cuenta.setNombre("María López"));
        assertEquals("María López", cuenta.getNombre());
    }

    @Test
    void setNombreInvalidoNullOVacio() {
        // Validador.esNombreValido rechaza null o vacío → retorna false y no modifica
        assertFalse(cuenta.setNombre(null));
        assertFalse(cuenta.setNombre(""));
        assertEquals("Juan Pérez", cuenta.getNombre()); // nombre no cambia
    }


    @Test
    void getCorreo() {
        assertEquals("juan.perez@uce.edu.ec", cuenta.getCorreo());
    }


    @Test
    void setCorreoUCEValido() {
        assertTrue(cuenta.setCorreo("maria.lopez@uce.edu.ec"));
        assertEquals("maria.lopez@uce.edu.ec", cuenta.getCorreo());
    }

    @Test
    void setCorreoNoUCERechazado() {
        // Validador.esCorreoUCEValido exige dominio @uce.edu.ec
        assertFalse(cuenta.setCorreo("usuario@gmail.com"));
        assertFalse(cuenta.setCorreo(""));
        assertFalse(cuenta.setCorreo(null));
        assertEquals("juan.perez@uce.edu.ec", cuenta.getCorreo()); // correo no cambia
    }


    @Test
    void getFechaNacimiento() {
        assertEquals(fechaValida, cuenta.getFechaNacimiento());
    }

    @Test
    void setFechaNacimientoValida() {
        Calendar cal = Calendar.getInstance();
        cal.set(1995, Calendar.MARCH, 20);
        Date nuevaFecha = cal.getTime();

        assertTrue(cuenta.setFechaNacimiento(nuevaFecha));
        assertEquals(nuevaFecha, cuenta.getFechaNacimiento());
    }

    @Test
    void setFechaNacimientoFuturaRechazada() {
        // Una fecha futura no es una fecha de nacimiento válida
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        Date fechaFutura = cal.getTime();

        assertFalse(cuenta.setFechaNacimiento(fechaFutura));
        assertEquals(fechaValida, cuenta.getFechaNacimiento()); // fecha no cambia
    }

    @Test
    void setFechaNacimientoNullRechazada() {
        assertFalse(cuenta.setFechaNacimiento(null));
        assertEquals(fechaValida, cuenta.getFechaNacimiento());
    }

    @Test
    void iniciarSesion() {
        // Verifica que no lanza excepción (lógica pendiente de implementar)
        assertDoesNotThrow(() -> cuenta.iniciarSesion());
    }

    @Test
    void cerrarSesion() {
        assertDoesNotThrow(() -> cuenta.cerrarSesion());
    }

    @Test
    void actualizarCredenciales() {
        assertDoesNotThrow(() -> cuenta.actualizarCredenciales());
    }

    @Test
    void consultarPerfil() {
        assertDoesNotThrow(() -> cuenta.consultarPerfil());
    }
    @Test
    void testToString() {
        String resultado = cuenta.toString();

        assertNotNull(resultado);
        assertTrue(resultado.contains("Juan Pérez"));
        assertTrue(resultado.contains("juan.perez@uce.edu.ec"));
        assertTrue(resultado.contains("Cuenta ["));
    }

    @Test
    void constructorVacioNoDaError() {
        Cuenta cuentaVacia = new Cuenta();
        assertNull(cuentaVacia.getNombre());
        assertNull(cuentaVacia.getCorreo());
        assertNull(cuentaVacia.getFechaNacimiento());
    }
}