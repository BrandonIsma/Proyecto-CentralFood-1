package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FavoritoTest {

    @Test
    void getIdFavorito() {
        Favorito favorito = new Favorito();
        favorito.setIdFavorito(10);

        assertEquals(10, favorito.getIdFavorito(),
                "El getter no retorna el ID de favorito correcto");
    }

    @Test
    void setIdFavorito() {
        Favorito favorito = new Favorito();
        favorito.setIdFavorito(5);

        assertEquals(5, favorito.getIdFavorito(),
                "El ID de favorito no se actualizó correctamente");
    }

    @Test
    void setIdFavoritoInvalido() {
        Favorito favorito = new Favorito();
        favorito.setIdFavorito(100);

        // Intento de asignación inválida
        favorito.setIdFavorito(-5);

        assertEquals(100, favorito.getIdFavorito(),
                "No se debe permitir actualizar el ID de favorito con números negativos");
    }

    @Test
    void getIdUsuario() {
        Favorito favorito = new Favorito();
        favorito.setIdUsuario(20);

        assertEquals(20, favorito.getIdUsuario(),
                "El getter no retorna el ID de usuario correcto");
    }

    @Test
    void setIdUsuario() {
        Favorito favorito = new Favorito();
        favorito.setIdUsuario(15);

        assertEquals(15, favorito.getIdUsuario(),
                "El ID de usuario no se actualizó correctamente");
    }

    @Test
    void setIdUsuarioInvalido() {
        Favorito favorito = new Favorito();
        favorito.setIdUsuario(50);

        favorito.setIdUsuario(-1);

        assertEquals(50, favorito.getIdUsuario(),
                "No se debe permitir actualizar el ID de usuario con un valor negativo");
    }

    @Test
    void getIdLocal() {
        Favorito favorito = new Favorito();
        favorito.setIdLocal(30);

        assertEquals(30, favorito.getIdLocal(),
                "El getter no retorna el ID de local correcto");
    }

    @Test
    void setIdLocal() {
        Favorito favorito = new Favorito();
        favorito.setIdLocal(25);

        assertEquals(25, favorito.getIdLocal(),
                "El ID de local no se actualizó correctamente");
    }

    @Test
    void setIdLocalInvalido() {
        Favorito favorito = new Favorito();
        favorito.setIdLocal(40);

        favorito.setIdLocal(-10);

        assertEquals(40, favorito.getIdLocal(),
                "No se debe permitir actualizar el ID de local con valores negativos");
    }

    @Test
    void getFechaAgregado() {
        Favorito favorito = new Favorito();
        favorito.setFechaAgregado(20260521); // Usando un int simulando una fecha YYYYMMDD

        assertEquals(20260521, favorito.getFechaAgregado(),
                "El getter no retorna la fecha de agregado correcta");
    }

    @Test
    void setFechaAgregado() {
        Favorito favorito = new Favorito();
        favorito.setFechaAgregado(20251231);

        assertEquals(20251231, favorito.getFechaAgregado(),
                "La fecha de agregado no se actualizó correctamente");
    }

    @Test
    void setFechaAgregadoInvalida() {
        Favorito favorito = new Favorito();
        favorito.setFechaAgregado(20260101);

        // Intento de setear una fecha en formato int negativo o inválido
        favorito.setFechaAgregado(-1);

        assertEquals(20260101, favorito.getFechaAgregado(),
                "No se debe permitir actualizar la fecha con un valor negativo");
    }

    // --- PRUEBAS ADICIONALES DE CONTROL ---

    @Test
    void constructorVacio() {
        Favorito favorito = new Favorito();

        assertEquals(0, favorito.getIdFavorito(), "El idFavorito inicial debe ser 0");
        assertEquals(0, favorito.getIdUsuario(), "El idUsuario inicial debe ser 0");
        assertEquals(0, favorito.getIdLocal(), "El idLocal inicial debe ser 0");
        assertEquals(0, favorito.getFechaAgregado(), "La fecha de agregado inicial debe ser 0 por defecto");
    }

    @Test
    void constructorConParametros() {
        // Se envían 4 enteros para hacer match con el constructor de Favorito(int, int, int, int)
        Favorito favorito = new Favorito(1, 10, 100, 20260521);

        assertEquals(1, favorito.getIdFavorito(), "El constructor no asignó correctamente idFavorito");
        assertEquals(10, favorito.getIdUsuario(), "El constructor no asignó correctamente idUsuario");
        assertEquals(100, favorito.getIdLocal(), "El constructor no asignó correctamente idLocal");
        assertEquals(20260521, favorito.getFechaAgregado(), "El constructor no asignó correctamente la fecha int");
    }

    @Test
    void testToString() {
        Favorito favorito = new Favorito(1, 10, 100, 20260521);

        String resultadoToString = favorito.toString();

        assertNotNull(resultadoToString, "El método toString no debe retornar un valor nulo");
        assertTrue(resultadoToString.contains("1"), "El toString debe incluir el idFavorito");
        assertTrue(resultadoToString.contains("10"), "El toString debe incluir el idUsuario");
        assertTrue(resultadoToString.contains("100"), "El toString debe incluir el idLocal");
        assertTrue(resultadoToString.contains("20260521"), "El toString debe incluir la fecha de agregado");
    }
}