package ec.edu.uce.proyectocentralfood.consola;

import ec.edu.uce.proyectocentralfood.dominio.*;
import ec.edu.uce.proyectocentralfood.util.Validador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuConsola {

    private final Scanner scanner;
    private final SimpleDateFormat formatoFecha;

    public MenuConsola() {
        this.scanner = new Scanner(System.in);
        this.formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        this.formatoFecha.setLenient(false);
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenuPrincipal();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuUsuario();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema CentralFood...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n======================================");
        System.out.println("          SISTEMA CENTRALFOOD");
        System.out.println("======================================");
        System.out.println("1. Ingresar como Administrador");
        System.out.println("2. Ingresar como Usuario");
        System.out.println("0. Salir");
        System.out.println("======================================");
    }

    // =====================================================
    // NIVEL 0 - ADMINISTRADOR
    // =====================================================

    private void menuAdministrador() {
        int opcion;

        do {
            System.out.println("\n========== MENÚ ADMINISTRADOR ==========");
            System.out.println("1. Gestionar categoría gastronómica");
            System.out.println("2. Gestionar punto de referencia universitario");
            System.out.println("3. Gestionar locales");
            System.out.println("4. Gestionar platos");
            System.out.println("5. Gestionar reseñas");
            System.out.println("6. Gestionar usuario");
            System.out.println("7. Registrar cuenta administrador");
            System.out.println("0. Volver");
            System.out.println("========================================");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    gestionarCategoriaGastronomica();
                    break;
                case 2:
                    gestionarPuntoReferenciaUniversitario();
                    break;
                case 3:
                    gestionarLocalComida();
                    break;
                case 4:
                    gestionarPlato();
                    break;
                case 5:
                    gestionarResena();
                    break;
                case 6:
                    gestionarUsuario();
                    break;
                case 7:
                    registrarCuentaAdministrador();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    // =====================================================
    // NIVEL 0 - USUARIO
    // =====================================================

    private void menuUsuario() {
        int opcion;

        do {
            System.out.println("\n============= MENÚ USUARIO =============");
            System.out.println("1. Consultar categorías gastronómicas");
            System.out.println("2. Consultar puntos de referencia universitarios");
            System.out.println("3. Consultar locales");
            System.out.println("4. Consultar platos");
            System.out.println("5. Gestionar favoritos");
            System.out.println("6. Gestionar reseñas");
            System.out.println("7. Gestionar usuario");
            System.out.println("0. Volver");
            System.out.println("========================================");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    consultarCategoriaGastronomica();
                    break;
                case 2:
                    consultarPuntoReferenciaUniversitario();
                    break;
                case 3:
                    consultarLocal();
                    break;
                case 4:
                    consultarPlato();
                    break;
                case 5:
                    gestionarFavorito();
                    break;
                case 6:
                    gestionarResena();
                    break;
                case 7:
                    gestionarUsuario();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    // =====================================================
    // NIVEL 1 - ADMINISTRADOR
    // =====================================================

    private void gestionarCategoriaGastronomica() {
        System.out.println("\n--- GESTIONAR CATEGORÍA GASTRONÓMICA ---");

        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría: ");

        String nombreCategoria = leerTextoValidado(
                "Ingrese nombre de categoría: ",
                "Nombre inválido.",
                Validador::esNombreCategoriaValido
        );

        String descripcion = leerTextoValidado(
                "Ingrese descripción: ",
                "Descripción inválida.",
                Validador::esDescripcionCategoriaValida
        );

        CategoriaGastronomica categoria = new CategoriaGastronomica(
                idCategoria,
                nombreCategoria,
                descripcion
        );

        System.out.println("Categoría gastronómica registrada correctamente:");
        System.out.println(categoria);
    }

    private void gestionarPuntoReferenciaUniversitario() {
        System.out.println("\n--- GESTIONAR PUNTO DE REFERENCIA UNIVERSITARIO ---");

        String nombre = leerTextoValidado(
                "Ingrese nombre del punto de referencia: ",
                "Nombre inválido.",
                Validador::esNombrePuntoReferenciaValido
        );

        String descripcion = leerTextoValidado(
                "Ingrese descripción: ",
                "Descripción inválida.",
                Validador::esDescripcionPuntoReferenciaValida
        );

        PuntoReferenciaUniversitario punto = new PuntoReferenciaUniversitario(
                nombre,
                descripcion
        );

        System.out.println("Punto de referencia universitario registrado correctamente:");
        System.out.println(punto);
    }

    private void gestionarLocalComida() {
        System.out.println("\n--- GESTIONAR LOCAL DE COMIDA ---");

        int idLocal = leerEnteroPositivo("Ingrese ID del local: ");

        String nombre = leerTextoValidado(
                "Ingrese nombre del local: ",
                "Nombre inválido.",
                Validador::esNombreLocalValido
        );

        String descripcion = leerTextoValidado(
                "Ingrese descripción del local: ",
                "Descripción inválida.",
                Validador::esDescripcionLocalValida
        );

        String telefono = leerTextoValidado(
                "Ingrese teléfono del local: ",
                "Teléfono inválido. Formato esperado: 09XXXXXXXX.",
                Validador::esTelefonoValido
        );

        String horarioAtencion = leerTextoValidado(
                "Ingrese horario de atención (08:00-17:00): ",
                "Horario inválido.",
                Validador::esHorarioAtencionValido
        );

        String estadoLocal = leerTextoValidado(
                "Ingrese estado del local (ABIERTO/CERRADO/ACTIVO/INACTIVO): ",
                "Estado inválido.",
                Validador::esEstadoLocalValido
        );

        String rangoPrecio = leerTextoValidado(
                "Ingrese rango de precio (BAJO/MEDIO/ALTO): ",
                "Rango de precio inválido.",
                Validador::esRangoPrecioValido
        );

        LocalComida local = new LocalComida(
                idLocal,
                nombre,
                descripcion,
                telefono,
                horarioAtencion,
                estadoLocal,
                rangoPrecio
        );

        System.out.println("Local de comida registrado correctamente:");
        System.out.println(local);
    }

    private void gestionarPlato() {
        System.out.println("\n--- GESTIONAR PLATO ---");

        int idPlato = leerEnteroPositivo("Ingrese ID del plato: ");

        String nombre = leerTextoValidado(
                "Ingrese nombre del plato: ",
                "Nombre inválido.",
                Validador::esNombrePlatoValido
        );

        String categoria = leerTextoValidado(
                "Ingrese categoría del plato: ",
                "Categoría inválida.",
                Validador::esCategoriaPlatoValida
        );

        String descripcion = leerTextoValidado(
                "Ingrese descripción del plato: ",
                "Descripción inválida.",
                Validador::esDescripcionPlatoValida
        );

        double precio = leerDoublePositivo("Ingrese precio del plato: ");

        int fechaActualizacion = leerFechaNumerica("Ingrese fecha de actualización (AAAAMMDD): ");

        Plato plato = new Plato(
                idPlato,
                nombre,
                categoria,
                descripcion,
                precio,
                fechaActualizacion
        );

        System.out.println("Plato registrado correctamente:");
        System.out.println(plato);
    }

    private void registrarCuentaAdministrador() {
        System.out.println("\n--- REGISTRAR CUENTA ADMINISTRADOR ---");

        String codigoAdministrador = leerTextoValidado(
                "Ingrese código de administrador (ADM-001): ",
                "Código inválido.",
                Validador::esCodigoAdministradorValido
        );

        CuentaAdministrador administrador = new CuentaAdministrador(codigoAdministrador);

        System.out.println("Cuenta administrador registrada correctamente:");
        System.out.println(administrador);
    }

    // =====================================================
    // NIVEL 1 - USUARIO
    // =====================================================

    private void consultarCategoriaGastronomica() {
        System.out.println("\n--- CONSULTAR CATEGORÍA GASTRONÓMICA ---");

        String nombreCategoria = leerTextoValidado(
                "Ingrese nombre de categoría a consultar: ",
                "Nombre inválido.",
                Validador::esNombreCategoriaValido
        );

        System.out.println("Consulta simulada de categoría gastronómica: " + nombreCategoria);
    }

    private void consultarPuntoReferenciaUniversitario() {
        System.out.println("\n--- CONSULTAR PUNTO DE REFERENCIA UNIVERSITARIO ---");

        String nombre = leerTextoValidado(
                "Ingrese nombre del punto de referencia a consultar: ",
                "Nombre inválido.",
                Validador::esNombrePuntoReferenciaValido
        );

        System.out.println("Consulta simulada de punto de referencia: " + nombre);
    }

    private void consultarLocal() {
        System.out.println("\n--- CONSULTAR LOCAL ---");

        String nombre = leerTextoValidado(
                "Ingrese nombre del local a consultar: ",
                "Nombre inválido.",
                Validador::esNombreLocalValido
        );

        System.out.println("Consulta simulada del local: " + nombre);
    }

    private void consultarPlato() {
        System.out.println("\n--- CONSULTAR PLATO ---");

        String nombre = leerTextoValidado(
                "Ingrese nombre del plato a consultar: ",
                "Nombre inválido.",
                Validador::esNombrePlatoValido
        );

        System.out.println("Consulta simulada del plato: " + nombre);
    }

    private void gestionarFavorito() {
        System.out.println("\n--- GESTIONAR FAVORITO ---");

        int idFavorito = leerEnteroPositivo("Ingrese ID de favorito: ");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario: ");
        int idLocal = leerEnteroPositivo("Ingrese ID de local: ");
        int fechaAgregado = leerFechaNumerica("Ingrese fecha de agregado (AAAAMMDD): ");

        Favorito favorito = new Favorito(
                idFavorito,
                idUsuario,
                idLocal,
                fechaAgregado
        );

        System.out.println("Favorito registrado correctamente:");
        System.out.println(favorito);
    }

    private void gestionarResena() {
        System.out.println("\n--- GESTIONAR RESEÑA ---");

        int idResena = leerEnteroPositivo("Ingrese ID de reseña: ");

        int calificacion;
        do {
            calificacion = leerEntero("Ingrese calificación (1 a 5): ");

            if (!Validador.esCalificacionValida(calificacion)) {
                System.out.println("Calificación inválida. Debe estar entre 1 y 5.");
            }

        } while (!Validador.esCalificacionValida(calificacion));

        String comentario = leerTextoValidado(
                "Ingrese comentario: ",
                "Comentario inválido.",
                Validador::esComentarioResenaValido
        );

        Date fechaCreacion = new Date();

        Resena resena = new Resena(
                idResena,
                calificacion,
                comentario,
                fechaCreacion
        );

        System.out.println("Reseña registrada correctamente:");
        System.out.println(resena);
    }

    private void gestionarUsuario() {
        System.out.println("\n--- GESTIONAR USUARIO ---");

        int idPersona = leerEnteroPositivo("Ingrese ID de persona: ");

        String nombre = leerTextoValidado(
                "Ingrese nombre: ",
                "Nombre inválido.",
                Validador::esNombreValido
        );

        String correo = leerTextoValidado(
                "Ingrese correo institucional UCE: ",
                "Correo inválido. Debe terminar en @uce.edu.ec.",
                Validador::esCorreoUCEValido
        );

        Date fechaNacimiento = leerFecha("Ingrese fecha de nacimiento (DD/MM/AAAA): ");

        Cuenta cuenta = new Cuenta(
                idPersona,
                nombre,
                correo,
                fechaNacimiento
        );

        System.out.println("Cuenta de usuario registrada correctamente:");
        System.out.println(cuenta);

        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario final: ");

        UsuarioFinal usuarioFinal = new UsuarioFinal(
                idUsuario,
                nombre
        );

        System.out.println("Usuario final registrado correctamente:");
        System.out.println(usuarioFinal);
    }

    // =====================================================
    // UBICACIÓN
    // =====================================================

    private void gestionarUbicacion() {
        System.out.println("\n--- REGISTRAR UBICACIÓN ---");

        String direccion = leerTextoValidado(
                "Ingrese dirección: ",
                "Dirección inválida.",
                Validador::esDireccionValida
        );

        double latitud;

        do {
            latitud = leerDouble("Ingrese latitud (-90 a 90): ");

            if (!Validador.esLatitudValida(latitud)) {
                System.out.println("Latitud inválida.");
            }

        } while (!Validador.esLatitudValida(latitud));

        double longitud;

        do {
            longitud = leerDouble("Ingrese longitud (-180 a 180): ");

            if (!Validador.esLongitudValida(longitud)) {
                System.out.println("Longitud inválida.");
            }

        } while (!Validador.esLongitudValida(longitud));

        String referenciaTextual = leerTextoValidado(
                "Ingrese referencia textual: ",
                "Referencia inválida.",
                Validador::esReferenciaTextualValida
        );

        Ubicacion ubicacion = new Ubicacion(
                direccion,
                latitud,
                longitud,
                referenciaTextual
        );

        System.out.println("Ubicación registrada correctamente:");
        System.out.println(ubicacion);
    }

    // =====================================================
    // MÉTODOS AUXILIARES
    // =====================================================

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }
    }

    private int leerEnteroPositivo(String mensaje) {
        int numero;

        do {
            numero = leerEntero(mensaje);

            if (numero <= 0) {
                System.out.println("El número debe ser mayor que cero.");
            }

        } while (numero <= 0);

        return numero;
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número decimal válido.");
            }
        }
    }

    private double leerDoublePositivo(String mensaje) {
        double numero;

        do {
            numero = leerDouble(mensaje);

            if (numero <= 0) {
                System.out.println("El número debe ser mayor que cero.");
            }

        } while (numero <= 0);

        return numero;
    }

    private Date leerFecha(String mensaje) {
        String fechaTexto;

        while (true) {
            System.out.print(mensaje);
            fechaTexto = scanner.nextLine();

            try {
                return formatoFecha.parse(fechaTexto);
            } catch (ParseException e) {
                System.out.println("Fecha inválida. Use formato DD/MM/AAAA.");
            }
        }
    }

    private int leerFechaNumerica(String mensaje) {
        int fecha;

        do {
            fecha = leerEntero(mensaje);

            if (String.valueOf(fecha).length() != 8) {
                System.out.println("Fecha inválida. Use formato AAAAMMDD.");
            }

        } while (String.valueOf(fecha).length() != 8);

        return fecha;
    }

    private String leerTextoValidado(String mensaje, String mensajeError, ValidadorTexto validador) {
        String texto;

        do {
            System.out.print(mensaje);
            texto = scanner.nextLine();

            if (!validador.validar(texto)) {
                System.out.println(mensajeError);
            }

        } while (!validador.validar(texto));

        return texto;
    }

    @FunctionalInterface
    private interface ValidadorTexto {
        boolean validar(String texto);
    }
}