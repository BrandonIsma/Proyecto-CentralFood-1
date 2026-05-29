package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class ResenaTest {

    private Resena resena;
    private Date fechaValida;

    @BeforeEach
    void setUp() {
        fechaValida = new Date();
        resena = new Resena(1, 5, "Excelente comida y buen servicio.", fechaValida);
    }

    @Test
    void getIdResena() {
        assertEquals(1, resena.getIdResena());
    }

    @Test
    void setIdResenaValido() {
        assertTrue(resena.setIdResena(10));
        assertEquals(10, resena.getIdResena());
    }

    @Test
    void setIdResenaInvalido() {
        assertFalse(resena.setIdResena(0));
        assertFalse(resena.setIdResena(-5));
        assertEquals(1, resena.getIdResena());
    }

    @Test
    void getCalificacion() {
        assertEquals(5, resena.getCalificacion());
    }

    @Test
    void setCalificacionValida() {
        assertTrue(resena.setCalificacion(3));
        assertEquals(3, resena.getCalificacion());
    }

    @Test
    void setCalificacionInvalida() {
        assertFalse(resena.setCalificacion(0));
        assertFalse(resena.setCalificacion(6)); // Rango de 1 a 5
        assertEquals(5, resena.getCalificacion());
    }

    @Test
    void getComentario() {
        assertEquals("Excelente comida y buen servicio.", resena.getComentario());
    }

    @Test
    void setComentarioValido() {
        assertTrue(resena.setComentario("Muy buena atención y precios accesibles."));
        assertEquals("Muy buena atención y precios accesibles.", resena.getComentario());
    }

    @Test
    void setComentarioInvalidoFondo() {
        assertFalse(resena.setComentario(null));
        assertFalse(resena.setComentario("   "));
        assertEquals("Excelente comida y buen servicio.", resena.getComentario());
    }

    @Test
    void getFechaCreacion() {
        assertEquals(fechaValida, resena.getFechaCreacion());
    }

    @Test
    void setFechaCreacionValida() {
        Date nuevaFecha = new Date();
        assertTrue(resena.setFechaCreacion(nuevaFecha));
        assertEquals(nuevaFecha, resena.getFechaCreacion());
    }

    @Test
    void setFechaCreacionNullInvalida() {
        assertFalse(resena.setFechaCreacion(null));
        assertEquals(fechaValida, resena.getFechaCreacion());
    }

    @Test
    void getSetUsuario() {
        UsuarioFinal usuario = new UsuarioFinal();
        resena.setUsuario(usuario);
        assertEquals(usuario, resena.getUsuario());
    }

    @Test
    void getSetLocalComida() {
        LocalComida local = new LocalComida();
        resena.setLocalComida(local);
        assertEquals(local, resena.getLocalComida());
    }

    @Test
    void constructorVacioNoDaError() {
        Resena resenaVacia = new Resena();
        assertEquals(0, resenaVacia.getIdResena());
        assertEquals("Sin comentario", resenaVacia.getComentario());
        assertNotNull(resenaVacia.getFechaCreacion());
    }

    @Test
    void testToString() {
        String resultado = resena.toString();
        assertNotNull(resultado);
        assertTrue(resultado.contains("5★"));
        assertTrue(resultado.contains("Excelente comida y buen servicio."));
        assertTrue(resultado.contains("Anónimo"));
    }
}