package ec.edu.uce.proyectocentralfood.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlatoTest {

    @Test
    void getIdPlato() {
        Plato plato = new Plato();
        plato.setIdPlato(15);

        assertEquals(15, plato.getIdPlato(),
                "El getter no retorna el ID de plato correcto");
    }

    @Test
    void setIdPlato() {
        Plato plato = new Plato();
        plato.setIdPlato(20);

        assertEquals(20, plato.getIdPlato(),
                "El ID de plato no se actualizó correctamente");
    }

    @Test
    void setIdPlatoInvalido() {
        Plato plato = new Plato();
        plato.setIdPlato(10);

        // Intento de asignación inválida
        plato.setIdPlato(-5);

        assertEquals(10, plato.getIdPlato(),
                "No se debe permitir actualizar el ID de plato con números negativos");
    }

    @Test
    void getNombre() {
        Plato plato = new Plato();
        plato.setNombre("Encebollado");

        assertEquals("Encebollado", plato.getNombre(),
                "El getter no retorna el nombre correcto");
    }

    @Test
    void setNombre() {
        Plato plato = new Plato();
        plato.setNombre("Ceviche");

        assertEquals("Ceviche", plato.getNombre(),
                "El nombre no se actualizó correctamente");
    }

    @Test
    void setNombreInvalido() {
        Plato plato = new Plato();
        plato.setNombre("Locro");

        // Intento de texto vacío o muy corto según tu validador
        plato.setNombre("");

        assertEquals("Locro", plato.getNombre(),
                "No se debe permitir asignar un nombre vacío o inválido");
    }

    @Test
    void getCategoria() {
        Plato plato = new Plato();
        plato.setCategoria("Sopas");

        assertEquals("Sopas", plato.getCategoria(),
                "El getter no retorna la categoría correcta");
    }

    @Test
    void setCategoria() {
        Plato plato = new Plato();
        plato.setCategoria("Mariscos");

        assertEquals("Mariscos", plato.getCategoria(),
                "La categoría no se actualizó correctamente");
    }

    @Test
    void getDescripcion() {
        Plato plato = new Plato();
        plato.setDescripcion("Plato tradicional con pescado y yuca");

        assertEquals("Plato tradicional con pescado y yuca", plato.getDescripcion(),
                "El getter no retorna la descripción correcta");
    }

    @Test
    void setDescripcion() {
        Plato plato = new Plato();
        plato.setDescripcion("Deliciosa sopa de papas con queso");

        assertEquals("Deliciosa sopa de papas con queso", plato.getDescripcion(),
                "La descripción no se actualizó correctamente");
    }

    @Test
    void getPrecio() {
        Plato plato = new Plato();
        plato.setPrecio(5.50);

        assertEquals(5.50, plato.getPrecio(),
                "El getter no retorna el precio correcto");
    }

    @Test
    void setPrecio() {
        Plato plato = new Plato();
        plato.setPrecio(3.25);

        assertEquals(3.25, plato.getPrecio(),
                "El precio no se actualizó correctamente");
    }

    @Test
    void setPrecioInvalido() {
        Plato plato = new Plato();
        plato.setPrecio(4.00);

        // Intento de poner un precio negativo o cero
        plato.setPrecio(-1.50);

        assertEquals(4.00, plato.getPrecio(),
                "No se debe permitir actualizar el precio con valores negativos o cero");
    }

    @Test
    void getFechaActualizacion() {
        Plato plato = new Plato();
        plato.setFechaActualizacion(20260521); // Formato int YYYYMMDD

        assertEquals(20260521, plato.getFechaActualizacion(),
                "El getter no retorna la fecha de actualización correcta");
    }

    @Test
    void setFechaActualizacion() {
        Plato plato = new Plato();
        plato.setFechaActualizacion(20251215);

        assertEquals(20251215, plato.getFechaActualizacion(),
                "La fecha de actualización no se actualizó correctamente");
    }

    @Test
    void getLocalComida() {
        Plato plato = new Plato();
        LocalComida local = new LocalComida();
        local.setNombre("Los Agachaditos");
        plato.setLocalComida(local);

        assertNotNull(plato.getLocalComida(), "El getter del local no debe ser nulo");
        assertEquals("Los Agachaditos", plato.getLocalComida().getNombre(),
                "El getter no retorna el objeto LocalComida correcto");
    }

    @Test
    void setLocalComida() {
        Plato plato = new Plato();
        LocalComida local = new LocalComida();
        plato.setLocalComida(local);

        assertEquals(local, plato.getLocalComida(),
                "El objeto LocalComida no se asignó correctamente");
    }

    @Test
    void getCategoriaGastro() {
        Plato plato = new Plato();
        CategoriaGastronomica categoriaObj = new CategoriaGastronomica();
        categoriaObj.setNombreCategoria("Plato Fuerte");
        plato.setCategoriaGastro(categoriaObj);

        assertNotNull(plato.getCategoriaGastro(), "El getter de CategoriaGastronomica no debe ser nulo");
        assertEquals("Plato Fuerte", plato.getCategoriaGastro().getNombreCategoria(),
                "El getter no retorna el objeto CategoriaGastronomica correcto");
    }

    @Test
    void setCategoriaGastro() {
        Plato plato = new Plato();
        CategoriaGastronomica categoriaObj = new CategoriaGastronomica();
        plato.setCategoriaGastro(categoriaObj);

        assertEquals(categoriaObj, plato.getCategoriaGastro(),
                "El objeto CategoriaGastronomica no se asignó correctamente");
    }

    @Test
    void isEsFavorito() {
        Plato plato = new Plato();
        plato.setEsFavorito(true);

        assertTrue(plato.isEsFavorito(), "El getter isEsFavorito debe retornar true");
    }

    @Test
    void setEsFavorito() {
        Plato plato = new Plato();
        plato.setEsFavorito(false);

        assertFalse(plato.isEsFavorito(), "El estado favorito no se actualizó correctamente a false");
    }

    // --- PRUEBAS DE CONSTRUCTOR Y TOSTRING ---

    @Test
    void constructorConParametros() {
        Plato plato = new Plato(1, "Bolon", "Desayuno", "Bolon de chicharron", 2.50, 20260521);

        assertEquals(1, plato.getIdPlato(), "El constructor no asignó correctamente idPlato");
        assertEquals("Bolon", plato.getNombre(), "El constructor no asignó correctamente el nombre");
        assertEquals("Desayuno", plato.getCategoria(), "El constructor no asignó correctamente la categoría");
        assertEquals("Bolon de chicharron", plato.getDescripcion(), "El constructor no asignó correctamente la descripción");
        assertEquals(2.50, plato.getPrecio(), "El constructor no asignó correctamente el precio");
        assertEquals(20260521, plato.getFechaActualizacion(), "El constructor no asignó correctamente la fecha");
    }

    @Test
    void testToString() {
        Plato plato = new Plato(5, "Fritada", "Plato Fuerte", "Fritada tipica", 6.00, 20260521);

        String resultadoToString = plato.toString();

        assertNotNull(resultadoToString, "El método toString no debe retornar un valor nulo");
        assertTrue(resultadoToString.contains("5"), "El toString debe incluir el idPlato");
        assertTrue(resultadoToString.contains("Fritada"), "El toString debe incluir el nombre del plato");
        assertTrue(resultadoToString.contains("6.0"), "El toString debe incluir el precio");
    }
}