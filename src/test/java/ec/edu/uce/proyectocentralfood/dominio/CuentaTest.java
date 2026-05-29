package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    private Cuenta cuenta;
    private Date fechaValida;

    @BeforeEach
    void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.MAY, 15);
        fechaValida = cal.getTime();
        cuenta = new Cuenta("Juan Pérez", "juan.perez@uce.edu.ec", fechaValida);
    }

    @Test
    void setNombreInvalidoFondo() {
        // La validación de fondo rechaza null o vacío
        assertFalse(cuenta.setNombre(null));
        assertFalse(cuenta.setNombre(""));
        assertEquals("Juan Pérez", cuenta.getNombre());
    }

    @Test
    void setCorreoInvalidoFondo() {
        // La validación del formato @uce se movió a la interfaz.
        // El dominio solo rechaza nulos o vacíos.
        assertFalse(cuenta.setCorreo(""));
        assertFalse(cuenta.setCorreo(null));
        assertEquals("juan.perez@uce.edu.ec", cuenta.getCorreo());
    }

    @Test
    void setFechaNacimientoFuturaRechazada() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        Date fechaFutura = cal.getTime();

        assertFalse(cuenta.setFechaNacimiento(fechaFutura));
        assertEquals(fechaValida, cuenta.getFechaNacimiento());
    }

    @Test
    void constructorVacioInicializaConValoresPorDefecto() {
        Cuenta cuentaVacia = new Cuenta();
        assertEquals("Sin nombre", cuentaVacia.getNombre());
        assertEquals("sin@uce.edu.ec", cuentaVacia.getCorreo());
        assertNotNull(cuentaVacia.getFechaNacimiento());
    }
}