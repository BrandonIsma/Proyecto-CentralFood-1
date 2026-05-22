package ec.edu.uce.proyectocentralfood.interfaz;

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
            System.out.println("\n======================================");
            System.out.println("          SISTEMA CENTRALFOOD");
            System.out.println("======================================");
            System.out.println("1. Gestión de Locales");
            System.out.println("2. Gestión de Categorías Gastronómicas");
            System.out.println("3. Gestión de Facultades");
            System.out.println("4. Gestión de Usuarios ");
            System.out.println("0. Salir");
            System.out.println("======================================");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: menuGestionarLocales(); break;
                case 2: menuGestionarCategoria(); break;
                case 3: menuGestionarFacultad(); break;
                case 4: menuGestionarUsuario(); break;
                case 0: System.out.println("Saliendo del sistema CentralFood..."); break;
                default: System.out.println("Opción inválida. Intente nuevamente."); break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    // =====================================================
    // 1. GESTIÓN DE LOCALES (H3)
    // =====================================================

    private void menuGestionarLocales() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE LOCALES =====");
            System.out.println("1. Crear nuevo local");
            System.out.println("2. Actualizar local");
            System.out.println("3. Eliminar local");
            System.out.println("4. Consultar locales ");
            System.out.println("5. INGRESAR A UN LOCAL ESPECÍFICO (Platos, Reseñas, Ubicación)");
            System.out.println("0. Volver al Menú Principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearLocal(); break;
                case 2: actualizarLocal(); break;
                case 3: eliminarLocal(); break;
                case 4: menuConsultarLocalesFiltros(); break;
                case 5:
                    int idLocal = leerEnteroPositivo("Ingrese el ID del local al que desea ingresar: ");
                    menuDetalleLocal(idLocal);
                    break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    private void menuDetalleLocal(int idLocal) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN INTERNA DEL LOCAL [" + idLocal + "] ---");
            System.out.println("1. Gestionar Platos (H4)");
            System.out.println("2. Gestionar Reseñas (H6)");
            System.out.println("3. Ver/Registrar Ubicación");
            System.out.println("0. Volver a Gestión de Locales");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: menuGestionarPlatos(idLocal); break;
                case 2: menuGestionarResenas(idLocal); break;
                case 3: crearUbicacion(); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    private void menuGestionarPlatos(int idLocal) {
        int opcion;
        do {
            System.out.println("\n===== PLATOS (Local " + idLocal + ") =====");
            System.out.println("1. Crear plato");
            System.out.println("2. Actualizar plato");
            System.out.println("3. Eliminar plato");
            System.out.println("4. Consultar platos ");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearPlato(); break;
                case 2: actualizarPlato(); break;
                case 3: eliminarPlato(); break;
                case 4: menuConsultarPlatosFiltros(); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    private void menuGestionarResenas(int idLocal) {
        int opcion;
        do {
            System.out.println("\n===== RESEÑAS (Local " + idLocal + ") =====");
            System.out.println("1. Crear reseña");
            System.out.println("2. Actualizar reseña");
            System.out.println("3. Eliminar reseña");
            System.out.println("4. Consultar reseñas ");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearResena(); break;
                case 2: actualizarResena(); break;
                case 3: eliminarResena(); break;
                case 4: menuConsultarResenasFiltros(); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 2. GESTIÓN DE CATEGORÍAS GASTRONÓMICAS (H1)
    // =====================================================

    private void menuGestionarCategoria() {
        int opcion;
        do {
            System.out.println("\n===== CATEGORÍAS GASTRONÓMICAS =====");
            System.out.println("1. Crear categoría");
            System.out.println("2. Actualizar categoría");
            System.out.println("3. Eliminar categoría");
            System.out.println("4. Consultar categoría ");
            System.out.println("0. Volver al Menú Principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearCategoria(); break;
                case 2: actualizarCategoria(); break;
                case 3: eliminarCategoria(); break;
                case 4: menuConsultarCategoriaFiltros(); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 3. GESTIÓN DE FACULTADES (H2)
    // =====================================================

    private void menuGestionarFacultad() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE FACULTADES =====");
            System.out.println("1. Crear facultad");
            System.out.println("2. Actualizar facultad");
            System.out.println("3. Eliminar facultad");
            System.out.println("4. Consultar facultad ");
            System.out.println("0. Volver al Menú Principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearFacultad(); break;
                case 2: actualizarFacultad(); break;
                case 3: eliminarFacultad(); break;
                case 4: menuConsultarFacultadFiltros(); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 4. MI PERFIL Y USUARIOS (H7 y H5)
    // =====================================================

    private void menuGestionarUsuario() {
        int opcion;
        do {
            System.out.println("\n===== MI PERFIL / USUARIOS =====");
            System.out.println("1. Crear cuenta base");
            System.out.println("2. Crear usuario final");
            System.out.println("3. Crear Centro de Comida");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Consultar usuario ");
            System.out.println("7. -> GESTIONAR MIS FAVORITOS ");
            System.out.println("0. Volver al Menú Principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearCuenta(); break;
                case 2: crearUsuarioFinal(); break;
                case 3: crearCuentaAdministrador(); break;
                case 4: actualizarUsuario(); break;
                case 5: eliminarUsuario(); break;
                case 6: menuConsultarUsuarioFiltros(); break;
                case 7: menuGestionarFavoritos(); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    private void menuGestionarFavoritos() {
        int opcion;
        do {
            System.out.println("\n===== MIS FAVORITOS =====");
            System.out.println("1. Crear favorito");
            System.out.println("2. Actualizar favorito");
            System.out.println("3. Eliminar favorito");
            System.out.println("4. Consultar favoritos ");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearFavorito(); break;
                case 2: actualizarFavorito(); break;
                case 3: eliminarFavorito(); break;
                case 4: menuConsultarFavoritosFiltros(); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN REALES
    // =====================================================

    // --- LOCALES ---
    private void crearLocal() {
        System.out.println("\n--- CREAR LOCAL DE COMIDA ---");
        int idLocal = leerEnteroPositivo("Ingrese ID del local: ");
        String nombre = leerTextoValidado("Ingrese nombre del local: ", "Nombre inválido.", Validador::esNombreLocalValido);
        String descripcion = leerTextoValidado("Ingrese descripción del local: ", "Descripción inválida.", Validador::esDescripcionLocalValida);
        String telefono = leerTextoValidado("Ingrese teléfono del local: ", "Teléfono inválido. Debe tener formato 09XXXXXXXX.", Validador::esTelefonoValido);
        String horarioAtencion = leerTextoValidado("Ingrese horario de atención (08:00-17:00): ", "Horario inválido.", Validador::esHorarioAtencionValido);
        String estadoLocal = leerTextoValidado("Ingrese estado del local (ABIERTO/CERRADO/ACTIVO/INACTIVO): ", "Estado inválido.", Validador::esEstadoLocalValido);
        String rangoPrecio = leerTextoValidado("Ingrese rango de precio (BAJO/MEDIO/ALTO): ", "Rango de precio inválido.", Validador::esRangoPrecioValido);

        LocalComida local = new LocalComida(idLocal, nombre, descripcion, telefono, horarioAtencion, estadoLocal, rangoPrecio);
        System.out.println("Local creado correctamente:\n" + local);
    }

    private void actualizarLocal() {
        System.out.println("\n--- ACTUALIZAR LOCAL ---");
        int idLocal = leerEnteroPositivo("Ingrese ID del local a actualizar: ");
        System.out.println("Proceda a ingresar los nuevos datos:");
        crearLocal();
    }

    private void eliminarLocal() {
        System.out.println("\n--- ELIMINAR LOCAL ---");
        int idLocal = leerEnteroPositivo("Ingrese ID del local a eliminar: ");
        System.out.println("Local eliminado correctamente. ID: " + idLocal);
    }

    // --- PLATOS ---
    private void crearPlato() {
        System.out.println("\n--- CREAR PLATO ---");
        int idPlato = leerEnteroPositivo("Ingrese ID del plato: ");
        String nombre = leerTextoValidado("Ingrese nombre del plato: ", "Nombre inválido.", Validador::esNombrePlatoValido);
        String categoria = leerTextoValidado("Ingrese categoría del plato: ", "Categoría inválida.", Validador::esCategoriaPlatoValida);
        String descripcion = leerTextoValidado("Ingrese descripción del plato: ", "Descripción inválida.", Validador::esDescripcionPlatoValida);
        double precio = leerDoublePositivo("Ingrese precio del plato: ");
        int fechaActualizacion = leerFechaNumerica("Ingrese fecha de actualización (AAAAMMDD): ");

        Plato plato = new Plato(idPlato, nombre, categoria, descripcion, precio, fechaActualizacion);
        System.out.println("Plato creado correctamente:\n" + plato);
    }

    private void actualizarPlato() {
        System.out.println("\n--- ACTUALIZAR PLATO ---");
        int idPlato = leerEnteroPositivo("Ingrese ID del plato a actualizar: ");
        System.out.println("Proceda a ingresar los nuevos datos:");
        crearPlato();
    }

    private void eliminarPlato() {
        System.out.println("\n--- ELIMINAR PLATO ---");
        int idPlato = leerEnteroPositivo("Ingrese ID del plato a eliminar: ");
        System.out.println("Plato eliminado correctamente. ID: " + idPlato);
    }

    // --- RESEÑAS ---
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
        String comentario = leerTextoValidado("Ingrese comentario: ", "Comentario inválido.", Validador::esComentarioResenaValido);
        Date fechaCreacion = new Date();

        Resena resena = new Resena(idResena, calificacion, comentario, fechaCreacion);
        System.out.println("Reseña creada correctamente:\n" + resena);
    }

    private void actualizarResena() {
        System.out.println("\n--- ACTUALIZAR RESEÑA ---");
        int idResena = leerEnteroPositivo("Ingrese ID de reseña a actualizar: ");
        System.out.println("Proceda a ingresar los nuevos datos:");
        crearResena();
    }

    private void eliminarResena() {
        System.out.println("\n--- ELIMINAR RESEÑA ---");
        int idResena = leerEnteroPositivo("Ingrese ID de reseña a eliminar: ");
        System.out.println("Reseña eliminada correctamente. ID: " + idResena);
    }

    // --- CATEGORÍAS ---
    private void crearCategoria() {
        System.out.println("\n--- CREAR CATEGORÍA GASTRONÓMICA ---");
        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría: ");
        String nombreCategoria = leerTextoValidado("Ingrese nombre de categoría: ", "Nombre inválido.", Validador::esNombreCategoriaValido);
        String descripcion = leerTextoValidado("Ingrese descripción: ", "Descripción inválida. Debe tener entre 5 y 200 caracteres.", Validador::esDescripcionCategoriaValida);

        CategoriaGastronomica categoria = new CategoriaGastronomica(idCategoria, nombreCategoria, descripcion);
        System.out.println("Categoría creada correctamente:\n" + categoria);
    }

    private void actualizarCategoria() {
        System.out.println("\n--- ACTUALIZAR CATEGORÍA ---");
        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría a actualizar: ");
        String nuevoNombre = leerTextoValidado("Ingrese nuevo nombre de categoría: ", "Nombre inválido.", Validador::esNombreCategoriaValido);
        String nuevaDescripcion = leerTextoValidado("Ingrese nueva descripción: ", "Descripción inválida.", Validador::esDescripcionCategoriaValida);

        CategoriaGastronomica categoria = new CategoriaGastronomica(idCategoria, nuevoNombre, nuevaDescripcion);
        System.out.println("Categoría actualizada correctamente:\n" + categoria);
    }

    private void eliminarCategoria() {
        System.out.println("\n--- ELIMINAR CATEGORÍA ---");
        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría a eliminar: ");
        System.out.println("Categoría eliminada correctamente. ID: " + idCategoria);
    }

    // --- FACULTADES ---
    private void crearFacultad() {
        System.out.println("\n--- CREAR FACULTAD ---");
        String nombre = leerTextoValidado("Ingrese nombre de la facultad: ", "Nombre inválido.", Validador::esNombreFacultadValido);
        String descripcion = leerTextoValidado("Ingrese descripción: ", "Descripción inválida.", Validador::esDescripcionFacultadValida);

        Facultad facultad = new Facultad();
        System.out.println("Facultad creada correctamente:\n" + facultad);
    }

    private void actualizarFacultad() {
        System.out.println("\n--- ACTUALIZAR FACULTAD ---");
        String nombre = leerTextoValidado("Ingrese nuevo nombre de la facultad: ", "Nombre inválido.", Validador::esNombreFacultadValido);
        String descripcion = leerTextoValidado("Ingrese nueva descripción: ", "Descripción inválida.", Validador::esDescripcionFacultadValida);

        Facultad facultad = new Facultad();
        System.out.println("Facultad actualizada correctamente:\n" + facultad);
    }

    private void eliminarFacultad() {
        System.out.println("\n--- ELIMINAR FACULTAD ---");
        String nombre = leerTextoValidado("Ingrese nombre de la facultad a eliminar: ", "Nombre inválido.", Validador::esNombreFacultadValido);
        System.out.println("Facultad eliminada correctamente: " + nombre);
    }

    // --- USUARIOS Y CUENTAS ---
    private void crearCuenta() {
        System.out.println("\n--- CREAR CUENTA ---");
        int idPersona = leerEnteroPositivo("Ingrese ID de persona: ");
        String nombre = leerTextoValidado("Ingrese nombre: ", "Nombre inválido. Debe contener solo letras y mínimo 2 caracteres.", Validador::esNombreValido);
        String correo = leerTextoValidado("Ingrese correo institucional UCE: ", "Correo inválido. Debe terminar en @uce.edu.ec.", Validador::esCorreoUCEValido);
        Date fechaNacimiento = leerFecha("Ingrese fecha de nacimiento (DD/MM/AAAA): ");

        Cuenta cuenta = new Cuenta(idPersona, nombre, correo, fechaNacimiento);
        System.out.println("Cuenta creada correctamente:\n" + cuenta);
    }

    private void crearUsuarioFinal() {
        System.out.println("\n--- CREAR USUARIO FINAL ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario: ");
        String nombre = leerTextoValidado("Ingrese nombre de usuario: ", "Nombre inválido.", Validador::esNombreUsuarioValido);

        UsuarioFinal usuarioFinal = new UsuarioFinal(idUsuario, nombre);
        System.out.println("Usuario final creado correctamente:\n" + usuarioFinal);
    }

    private void crearCuentaAdministrador() {
        System.out.println("\n--- CREAR CUENTA ADMINISTRADOR ---");
        String codigoAdministrador = leerTextoValidado("Ingrese código de administrador (ADM-001): ", "Código inválido. Debe tener formato ADM-001.", Validador::esCodigoAdministradorValido);

        CentroComida administrador = new CentroComida(codigoAdministrador);
        System.out.println("Cuenta administrador creada correctamente:\n" + administrador);
    }

    private void actualizarUsuario() {
        System.out.println("\n--- ACTUALIZAR USUARIO ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario a actualizar: ");
        String nuevoNombre = leerTextoValidado("Ingrese nuevo nombre: ", "Nombre inválido.", Validador::esNombreUsuarioValido);
        System.out.println("Usuario actualizado correctamente. ID: " + idUsuario + "\nNuevo nombre: " + nuevoNombre);
    }

    private void eliminarUsuario() {
        System.out.println("\n--- ELIMINAR USUARIO ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario a eliminar: ");
        System.out.println("Usuario eliminado correctamente. ID: " + idUsuario);
    }

    // --- FAVORITOS ---
    private void crearFavorito() {
        System.out.println("\n--- CREAR FAVORITO ---");
        int idFavorito = leerEnteroPositivo("Ingrese ID de favorito: ");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario: ");
        int idLocal = leerEnteroPositivo("Ingrese ID de local: ");
        int fechaAgregado = leerFechaNumerica("Ingrese fecha de agregado (AAAAMMDD): ");

        Favorito favorito = new Favorito(idFavorito, idUsuario, idLocal, fechaAgregado);
        System.out.println("Favorito creado correctamente:\n" + favorito);
    }

    private void actualizarFavorito() {
        System.out.println("\n--- ACTUALIZAR FAVORITO ---");
        int idFavorito = leerEnteroPositivo("Ingrese ID de favorito a actualizar: ");
        System.out.println("Proceda a ingresar los nuevos datos:");
        crearFavorito();
    }

    private void eliminarFavorito() {
        System.out.println("\n--- ELIMINAR FAVORITO ---");
        int idFavorito = leerEnteroPositivo("Ingrese ID de favorito a eliminar: ");
        System.out.println("Favorito eliminado correctamente. ID: " + idFavorito);
    }

    // --- UBICACIÓN ---
    private void crearUbicacion() {
        System.out.println("\n--- CREAR UBICACIÓN ---");
        String direccion = leerTextoValidado("Ingrese dirección: ", "Dirección inválida.", Validador::esDireccionValida);
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
        String referenciaTextual = leerTextoValidado("Ingrese referencia textual: ", "Referencia inválida.", Validador::esReferenciaTextualValida);

        Ubicacion ubicacion = new Ubicacion(direccion, latitud, longitud, referenciaTextual);
        System.out.println("Ubicación creada correctamente:\n" + ubicacion);
    }

    // =====================================================
    // MENÚS DE EXTENSIONES (FILTROS DE BÚSQUEDA)
    // =====================================================

    private void menuConsultarLocalesFiltros() {
        System.out.println("\n--- FILTROS DE BÚSQUEDA DE LOCALES ---");
        System.out.println("1. Buscar por nombre");
        System.out.println("2. Buscar por facultad");
        System.out.println("3. Buscar por categoría gastronómica");
        System.out.println("4. Buscar por horario de atención");
        System.out.println("5. Buscar por estado de apertura");
        int op = leerEntero("Seleccione filtro: ");
        System.out.println("Opciones de filtrado cargadas. (Requiere implementación de listas/BD para buscar)");
    }

    private void menuConsultarPlatosFiltros() {
        System.out.println("\n--- FILTROS DE PLATOS ---");
        System.out.println("1. Consultar por categoría");
        System.out.println("2. Consultar por nombre");
        System.out.println("3. Consultar por precio");
        int op = leerEntero("Seleccione filtro: ");
        System.out.println("Opciones de filtrado cargadas. (Requiere implementación de listas/BD para buscar)");
    }

    private void menuConsultarResenasFiltros() {
        System.out.println("\n--- FILTROS DE RESEÑAS ---");
        System.out.println("1. Consultar por estrellas");
        System.out.println("2. Consultar por más recientes");
        System.out.println("3. Consultar por más antiguas");
        int op = leerEntero("Seleccione filtro: ");
        System.out.println("Opciones de filtrado cargadas. (Requiere implementación de listas/BD para buscar)");
    }

    private void menuConsultarCategoriaFiltros() {
        System.out.println("\n--- FILTROS DE CATEGORÍA ---");
        System.out.println("1. Consultar por almuerzos");
        System.out.println("2. Consultar por desayunos");
        System.out.println("3. Consultar por comida rápida");
        int op = leerEntero("Seleccione filtro: ");
        System.out.println("Opciones de filtrado cargadas. (Requiere implementación de listas/BD para buscar)");
    }

    private void menuConsultarFacultadFiltros() {
        System.out.println("\n--- FILTROS DE FACULTADES ---");
        System.out.println("1. Consultar por nombre de Facultad");
        System.out.println("2. Consultar por espacio Universitario");
        System.out.println("3. Consultar por lugar de ingreso");
        int op = leerEntero("Seleccione filtro: ");
        System.out.println("Opciones de filtrado cargadas. (Requiere implementación de listas/BD para buscar)");
    }

    private void menuConsultarUsuarioFiltros() {
        System.out.println("\n--- FILTROS DE USUARIO ---");
        System.out.println("1. Consultar usuario por ID");
        System.out.println("2. Consultar usuario por nombre");
        int op = leerEntero("Seleccione filtro: ");
        System.out.println("Opciones de filtrado cargadas. (Requiere implementación de listas/BD para buscar)");
    }

    private void menuConsultarFavoritosFiltros() {
        System.out.println("\n--- FILTROS DE FAVORITOS ---");
        System.out.println("1. Consultar locales favoritos");
        System.out.println("2. Consultar platos favoritos");
        int op = leerEntero("Seleccione filtro: ");
        System.out.println("Opciones de filtrado cargadas. (Requiere implementación de listas/BD para buscar)");
    }

    // =====================================================
    // MÉTODOS AUXILIARES DE ENTRADA Y VALIDACIÓN
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
    public interface ValidadorTexto {
        boolean validar(String texto);
    }
}