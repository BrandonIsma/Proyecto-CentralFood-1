package ec.edu.uce.proyectocentralfood.interfaz;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

class MenuConsolaTest {

    @Test
    void testIniciarMenuOpcionSalir() {

        String entradaSimulada = "0\n";

        InputStream inOriginal = System.in;

        try {

            System.setIn(new ByteArrayInputStream(entradaSimulada.getBytes()));


            MenuConsola menu = new MenuConsola();


            assertDoesNotThrow(() -> menu.iniciar(),
                    "El menú debería iniciar y cerrarse correctamente con la opción 0 sin lanzar excepciones.");

        } finally {

            System.setIn(inOriginal);
        }
    }
}