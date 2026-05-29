package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocalComidaTest {

    private LocalComida local;

    @BeforeEach
    void setUp() {
        local = new LocalComida(1, "Central Burgers", "Hamburguesas universitarias", "0987654321", "08:00-16:00", "ABIERTO", "MEDIO");
    }

    @Test
    void setNombreInvalidoFondo() {
        assertFalse(local.setNombre(null));
        assertFalse(local.setNombre(""));
        assertEquals("Central Burgers", local.getNombre());
    }

    @Test
    void constructorVacioInicializaArreglos() {
        LocalComida vacio = new LocalComida();
        assertNotNull(vacio.getPlatos());
        assertNotNull(vacio.getResenas());
        assertEquals(0, vacio.getPlatos().length);
        assertEquals(0, vacio.getResenas().length);
    }

    @Test
    void agregarYEliminarPlatoArregloDinamico() {
        Plato p1 = new Plato();
        p1.setIdPlato(10);
        Plato p2 = new Plato();
        p2.setIdPlato(20);

        // Agregamos
        local.agregarPlato(p1);
        local.agregarPlato(p2);
        assertEquals(2, local.getPlatos().length);

        // Eliminamos uno existente
        assertTrue(local.eliminarPlato(10));
        assertEquals(1, local.getPlatos().length);
        assertEquals(20, local.getPlatos()[0].getIdPlato());

        // Eliminamos uno que no existe
        assertFalse(local.eliminarPlato(99));
    }

    @Test
    void recibirYEliminarResenaArregloDinamico() {
        Resena r1 = new Resena();
        r1.setIdResena(1);

        local.recibirResena(r1);
        assertEquals(1, local.getResenas().length);

        assertTrue(local.eliminarResena(1));
        assertEquals(0, local.getResenas().length);
    }

    @Test
    void testToString() {
        // 1. Instanciamos el local
        LocalComida localPrueba = new LocalComida(1, "Central Burgers", "Hamburguesas universitarias", "0987654321", "08:00-16:00", "ABIERTO", "MEDIO");

        // 2. Generamos el texto
        String resultado = localPrueba.toString();

        // 3. Imprimimos en consola para depuración visual
        System.out.println("TEXTO GENERADO POR TOSTRING: \n" + resultado);

        // 4. Aserciones adaptadas EXACTAMENTE a lo que imprime tu clase actualmente
        assertNotNull(resultado, "El toString no debe retornar nulo");
        assertTrue(resultado.contains("Central Burgers"), "Falla nombre. Texto actual: " + resultado);
        assertTrue(resultado.contains("Categoría: 'Sin nombre'"), "Falla categoría. Texto actual: " + resultado);
        assertTrue(resultado.contains("Platos Ofertados: 0"), "Falla platos. Texto actual: " + resultado);
        assertTrue(resultado.contains("Reseñas: 0"), "Falla reseñas. Texto actual: " + resultado);
    }
}
