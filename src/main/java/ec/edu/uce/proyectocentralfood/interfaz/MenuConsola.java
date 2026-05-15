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
    // MENÚ ADMINISTRADOR
    // =====================================================

    private void menuAdministrador() {
        int opcion;

        do {
            System.out.println("\n===== MENÚ ADMINISTRADOR =====");
            System.out.println("1. Gestionar categoría gastronómica");
            System.out.println("2. Gestionar punto de referencia universitario");
            System.out.println("3. Gestionar locales");
            System.out.println("4. Gestionar platos");
            System.out.println("5. Gestionar reseñas");
            System.out.println("6. Gestionar usuario");
            System.out.println("7. Crear cuenta administrador");
            System.out.println("0. Volver");
            System.out.println("==============================");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    menuGestionarCategoria();
                    break;
                case 2:
                    menuGestionarPuntoReferencia();
                    break;
                case 3:
                    menuGestionarLocales();
                    break;
                case 4:
                    menuGestionarPlatos();
                    break;
                case 5:
                    menuGestionarResenas();
                    break;
                case 6:
                    menuGestionarUsuario();
                    break;
                case 7:
                    crearCuentaAdministrador();
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
    // MENÚ USUARIO
    // =====================================================

    private void menuUsuario() {
        int opcion;

        do {
            System.out.println("\n===== MENÚ USUARIO =====");
            System.out.println("1. Consultar categoría gastronómica");
            System.out.println("2. Consultar punto de referencia universitario");
            System.out.println("3. Consultar locales");
            System.out.println("4. Consultar platos");
            System.out.println("5. Gestionar favoritos");
            System.out.println("6. Gestionar reseñas");
            System.out.println("7. Gestionar usuario");
            System.out.println("0. Volver");
            System.out.println("========================");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    consultarCategoria();
                    break;
                case 2:
                    consultarPuntoReferencia();
                    break;
                case 3:
                    consultarLocal();
                    break;
                case 4:
                    consultarPlato();
                    break;
                case 5:
                    menuGestionarFavoritos();
                    break;
                case 6:
                    menuGestionarResenas();
                    break;
                case 7:
                    menuGestionarUsuario();
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
    // H1. GESTIONAR CATEGORÍA GASTRONÓMICA
    // =====================================================

    private void menuGestionarCategoria() {
        int opcion;

        do {
            System.out.println("\n===== GESTIONAR CATEGORÍA GASTRONÓMICA =====");
            System.out.println("1. Crear categoría");
            System.out.println("2. Actualizar categoría");
            System.out.println("3. Consultar categoría");
            System.out.println("4. Eliminar categoría");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearCategoria();
                    break;
                case 2:
                    actualizarCategoria();
                    break;
                case 3:
                    consultarCategoria();
                    break;
                case 4:
                    eliminarCategoria();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    // =====================================================
    // H2. GESTIONAR PUNTO DE REFERENCIA UNIVERSITARIO
    // =====================================================

    private void menuGestionarPuntoReferencia() {
        int opcion;

        do {
            System.out.println("\n===== GESTIONAR PUNTO DE REFERENCIA UNIVERSITARIO =====");
            System.out.println("1. Crear punto de referencia");
            System.out.println("2. Actualizar punto de referencia");
            System.out.println("3. Consultar punto de referencia");
            System.out.println("4. Eliminar punto de referencia");
            System.out.println("5. Registrar ubicación");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearPuntoReferencia();
                    break;
                case 2:
                    actualizarPuntoReferencia();
                    break;
                case 3:
                    consultarPuntoReferencia();
                    break;
                case 4:
                    eliminarPuntoReferencia();
                    break;
                case 5:
                    crearUbicacion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    // =====================================================
    // H3. GESTIONAR LOCALES
    // =====================================================

    private void menuGestionarLocales() {
        int opcion;

        do {
            System.out.println("\n===== GESTIONAR LOCALES =====");
            System.out.println("1. Crear local");
            System.out.println("2. Actualizar local");
            System.out.println("3. Consultar local");
            System.out.println("4. Eliminar local");
            System.out.println("5. Registrar ubicación de local");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearLocal();
                    break;
                case 2:
                    actualizarLocal();
                    break;
                case 3:
                    consultarLocal();
                    break;
                case 4:
                    eliminarLocal();
                    break;
                case 5:
                    crearUbicacion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    // =====================================================
    // H4. GESTIONAR PLATOS
    // =====================================================

    private void menuGestionarPlatos() {
        int opcion;

        do {
            System.out.println("\n===== GESTIONAR PLATOS =====");
            System.out.println("1. Crear plato");
            System.out.println("2. Actualizar plato");
            System.out.println("3. Consultar plato");
            System.out.println("4. Eliminar plato");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearPlato();
                    break;
                case 2:
                    actualizarPlato();
                    break;
                case 3:
                    consultarPlato();
                    break;
                case 4:
                    eliminarPlato();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    // =====================================================
    // H5. GESTIONAR FAVORITOS
    // =====================================================

    private void menuGestionarFavoritos() {
        int opcion;

        do {
            System.out.println("\n===== GESTIONAR FAVORITOS =====");
            System.out.println("1. Crear favorito");
            System.out.println("2. Actualizar favorito");
            System.out.println("3. Consultar favorito");
            System.out.println("4. Eliminar favorito");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearFavorito();
                    break;
                case 2:
                    actualizarFavorito();
                    break;
                case 3:
                    consultarFavorito();
                    break;
                case 4:
                    eliminarFavorito();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    // =====================================================
    // H6. GESTIONAR RESEÑAS
    // =====================================================

    private void menuGestionarResenas() {
        int opcion;

        do {
            System.out.println("\n===== GESTIONAR RESEÑAS =====");
            System.out.println("1. Crear reseña");
            System.out.println("2. Actualizar reseña");
            System.out.println("3. Consultar reseña");
            System.out.println("4. Eliminar reseña");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearResena();
                    break;
                case 2:
                    actualizarResena();
                    break;
                case 3:
                    consultarResena();
                    break;
                case 4:
                    eliminarResena();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    // =====================================================
    // H7. GESTIONAR USUARIO
    // =====================================================

    private void menuGestionarUsuario() {
        int opcion;

        do {
            System.out.println("\n===== GESTIONAR USUARIO =====");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Crear usuario final");
            System.out.println("3. Consultar usuario");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    crearUsuarioFinal();
                    break;
                case 3:
                    consultarUsuario();
                    break;
                case 4:
                    actualizarUsuario();
                    break;
                case 5:
                    eliminarUsuario();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }

    // =====================================================
    // ACCIONES: CUENTA
    // =====================================================

    private void crearCuenta() {
        System.out.println("\n--- CREAR CUENTA ---");

        int idPersona = leerEnteroPositivo("Ingrese ID de persona: ");

        String nombre = leerTextoValidado(
                "Ingrese nombre: ",
                "Nombre inválido. Debe contener solo letras y mínimo 2 caracteres.",
                Validador::esNombreValido
        );

        String correo = leerTextoValidado(
                "Ingrese correo institucional UCE: ",
                "Correo inválido. Debe terminar en @uce.edu.ec.",
                Validador::esCorreoUCEValido
        );

        Date fechaNacimiento = leerFecha("Ingrese fecha de nacimiento (DD/MM/AAAA): ");

        Cuenta cuenta = new Cuenta(idPersona, nombre, correo, fechaNacimiento);

        System.out.println("Cuenta creada correctamente:");
        System.out.println(cuenta);
    }

    private void crearUsuarioFinal() {
        System.out.println("\n--- CREAR USUARIO FINAL ---");

        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario: ");

        String nombre = leerTextoValidado(
                "Ingrese nombre de usuario: ",
                "Nombre inválido.",
                Validador::esNombreUsuarioValido
        );

        UsuarioFinal usuarioFinal = new UsuarioFinal(idUsuario, nombre);

        System.out.println("Usuario final creado correctamente:");
        System.out.println(usuarioFinal);
    }

    private void crearCuentaAdministrador() {
        System.out.println("\n--- CREAR CUENTA ADMINISTRADOR ---");

        String codigoAdministrador = leerTextoValidado(
                "Ingrese código de administrador (ADM-001): ",
                "Código inválido. Debe tener formato ADM-001.",
                Validador::esCodigoAdministradorValido
        );

        CuentaAdministrador administrador = new CuentaAdministrador(codigoAdministrador);

        System.out.println("Cuenta administrador creada correctamente:");
        System.out.println(administrador);
    }

    private void consultarUsuario() {
        System.out.println("\n--- CONSULTAR USUARIO ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario a consultar: ");
        System.out.println("Consulta simulada del usuario con ID: " + idUsuario);
    }

    private void actualizarUsuario() {
        System.out.println("\n--- ACTUALIZAR USUARIO ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario a actualizar: ");

        String nuevoNombre = leerTextoValidado(
                "Ingrese nuevo nombre: ",
                "Nombre inválido.",
                Validador::esNombreUsuarioValido
        );

        System.out.println("Usuario actualizado correctamente:");
        System.out.println("ID usuario: " + idUsuario);
        System.out.println("Nuevo nombre: " + nuevoNombre);
    }

    private void eliminarUsuario() {
        System.out.println("\n--- ELIMINAR USUARIO ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario a eliminar: ");
        System.out.println("Usuario eliminado correctamente. ID: " + idUsuario);
    }

    // =====================================================
    // ACCIONES: CATEGORÍA GASTRONÓMICA
    // =====================================================

    private void crearCategoria() {
        System.out.println("\n--- CREAR CATEGORÍA GASTRONÓMICA ---");

        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría: ");

        String nombreCategoria = leerTextoValidado(
                "Ingrese nombre de categoría: ",
                "Nombre inválido.",
                Validador::esNombreCategoriaValido
        );

        String descripcion = leerTextoValidado(
                "Ingrese descripción: ",
                "Descripción inválida. Debe tener entre 5 y 200 caracteres.",
                Validador::esDescripcionCategoriaValida
        );

        CategoriaGastronomica categoria = new CategoriaGastronomica(
                idCategoria,
                nombreCategoria,
                descripcion
        );

        System.out.println("Categoría creada correctamente:");
        System.out.println(categoria);
    }

    private void actualizarCategoria() {
        System.out.println("\n--- ACTUALIZAR CATEGORÍA ---");

        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría a actualizar: ");

        String nuevoNombre = leerTextoValidado(
                "Ingrese nuevo nombre de categoría: ",
                "Nombre inválido.",
                Validador::esNombreCategoriaValido
        );

        String nuevaDescripcion = leerTextoValidado(
                "Ingrese nueva descripción: ",
                "Descripción inválida.",
                Validador::esDescripcionCategoriaValida
        );

        CategoriaGastronomica categoria = new CategoriaGastronomica(
                idCategoria,
                nuevoNombre,
                nuevaDescripcion
        );

        System.out.println("Categoría actualizada correctamente:");
        System.out.println(categoria);
    }

    private void consultarCategoria() {
        System.out.println("\n--- CONSULTAR CATEGORÍA ---");
        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría a consultar: ");
        System.out.println("Consulta simulada de categoría con ID: " + idCategoria);
    }

    private void eliminarCategoria() {
        System.out.println("\n--- ELIMINAR CATEGORÍA ---");
        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría a eliminar: ");
        System.out.println("Categoría eliminada correctamente. ID: " + idCategoria);
    }

    // =====================================================
    // ACCIONES: PUNTO REFERENCIA
    // =====================================================

    private void crearPuntoReferencia() {
        System.out.println("\n--- CREAR PUNTO DE REFERENCIA UNIVERSITARIO ---");

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

        PuntoReferenciaUniversitario punto = new PuntoReferenciaUniversitario(nombre, descripcion);

        System.out.println("Punto de referencia creado correctamente:");
        System.out.println(punto);
    }

    private void actualizarPuntoReferencia() {
        System.out.println("\n--- ACTUALIZAR PUNTO DE REFERENCIA ---");

        String nombre = leerTextoValidado(
                "Ingrese nuevo nombre: ",
                "Nombre inválido.",
                Validador::esNombrePuntoReferenciaValido
        );

        String descripcion = leerTextoValidado(
                "Ingrese nueva descripción: ",
                "Descripción inválida.",
                Validador::esDescripcionPuntoReferenciaValida
        );

        PuntoReferenciaUniversitario punto = new PuntoReferenciaUniversitario(nombre, descripcion);

        System.out.println("Punto de referencia actualizado correctamente:");
        System.out.println(punto);
    }

    private void consultarPuntoReferencia() {
        System.out.println("\n--- CONSULTAR PUNTO DE REFERENCIA ---");
        String nombre = leerTextoValidado(
                "Ingrese nombre del punto de referencia: ",
                "Nombre inválido.",
                Validador::esNombrePuntoReferenciaValido
        );

        System.out.println("Consulta simulada del punto de referencia: " + nombre);
    }

    private void eliminarPuntoReferencia() {
        System.out.println("\n--- ELIMINAR PUNTO DE REFERENCIA ---");
        String nombre = leerTextoValidado(
                "Ingrese nombre del punto de referencia a eliminar: ",
                "Nombre inválido.",
                Validador::esNombrePuntoReferenciaValido
        );

        System.out.println("Punto de referencia eliminado correctamente: " + nombre);
    }

    // =====================================================
    // ACCIONES: LOCAL COMIDA
    // =====================================================

    private void crearLocal() {
        System.out.println("\n--- CREAR LOCAL DE COMIDA ---");

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
                "Teléfono inválido. Debe tener formato 09XXXXXXXX.",
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

        System.out.println("Local creado correctamente:");
        System.out.println(local);
    }

    private void actualizarLocal() {
        System.out.println("\n--- ACTUALIZAR LOCAL ---");
        crearLocal();
    }

    private void consultarLocal() {
        System.out.println("\n--- CONSULTAR LOCAL ---");
        int idLocal = leerEnteroPositivo("Ingrese ID del local a consultar: ");
        System.out.println("Consulta simulada del local con ID: " + idLocal);
    }

    private void eliminarLocal() {
        System.out.println("\n--- ELIMINAR LOCAL ---");
        int idLocal = leerEnteroPositivo("Ingrese ID del local a eliminar: ");
        System.out.println("Local eliminado correctamente. ID: " + idLocal);
    }

    // =====================================================
    // ACCIONES: PLATO
    // =====================================================

    private void crearPlato() {
        System.out.println("\n--- CREAR PLATO ---");

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

        System.out.println("Plato creado correctamente:");
        System.out.println(plato);
    }

    private void actualizarPlato() {
        System.out.println("\n--- ACTUALIZAR PLATO ---");
        crearPlato();
    }

    private void consultarPlato() {
        System.out.println("\n--- CONSULTAR PLATO ---");
        int idPlato = leerEnteroPositivo("Ingrese ID del plato a consultar: ");
        System.out.println("Consulta simulada del plato con ID: " + idPlato);
    }

    private void eliminarPlato() {
        System.out.println("\n--- ELIMINAR PLATO ---");
        int idPlato = leerEnteroPositivo("Ingrese ID del plato a eliminar: ");
        System.out.println("Plato eliminado correctamente. ID: " + idPlato);
    }

    // =====================================================
    // ACCIONES: FAVORITO
    // =====================================================

    private void crearFavorito() {
        System.out.println("\n--- CREAR FAVORITO ---");

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

        System.out.println("Favorito creado correctamente:");
        System.out.println(favorito);
    }

    private void actualizarFavorito() {
        System.out.println("\n--- ACTUALIZAR FAVORITO ---");
        crearFavorito();
    }

    private void consultarFavorito() {
        System.out.println("\n--- CONSULTAR FAVORITO ---");
        int idFavorito = leerEnteroPositivo("Ingrese ID de favorito a consultar: ");
        System.out.println("Consulta simulada del favorito con ID: " + idFavorito);
    }

    private void eliminarFavorito() {
        System.out.println("\n--- ELIMINAR FAVORITO ---");
        int idFavorito = leerEnteroPositivo("Ingrese ID de favorito a eliminar: ");
        System.out.println("Favorito eliminado correctamente. ID: " + idFavorito);
    }

    // =====================================================
    // ACCIONES: RESEÑA
    // =====================================================

    private void crearResena() {
        System.out.println("\n--- CREAR RESEÑA ---");

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

        System.out.println("Reseña creada correctamente:");
        System.out.println(resena);
    }

    private void actualizarResena() {
        System.out.println("\n--- ACTUALIZAR RESEÑA ---");
        crearResena();
    }

    private void consultarResena() {
        System.out.println("\n--- CONSULTAR RESEÑA ---");
        int idResena = leerEnteroPositivo("Ingrese ID de reseña a consultar: ");
        System.out.println("Consulta simulada de reseña con ID: " + idResena);
    }

    private void eliminarResena() {
        System.out.println("\n--- ELIMINAR RESEÑA ---");
        int idResena = leerEnteroPositivo("Ingrese ID de reseña a eliminar: ");
        System.out.println("Reseña eliminada correctamente. ID: " + idResena);
    }

    // =====================================================
    // ACCIONES: UBICACIÓN
    // =====================================================

    private void crearUbicacion() {
        System.out.println("\n--- CREAR UBICACIÓN ---");

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

        System.out.println("Ubicación creada correctamente:");
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