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

    // =====================================================
    // MENÚ PRINCIPAL (Nivel 0)
    // =====================================================

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n======================================");
            System.out.println("          SISTEMA CENTRALFOOD");
            System.out.println("======================================");
            System.out.println("1. Gestión de Locales");
            System.out.println("2. Gestión de Categorías Gastronómicas");
            System.out.println("3. Gestión de Facultades / Puntos de Referencia");
            System.out.println("4. Gestión de Usuarios");
            System.out.println("0. Salir");
            System.out.println("======================================");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: menuGestionarLocales(); break;
                case 2: menuGestionarCategorias(); break;
                case 3: menuGestionarFacultades(); break;
                case 4: menuGestionarUsuarios(); break;
                case 0: System.out.println("Saliendo del sistema CentralFood..."); break;
                default: System.out.println("Opción inválida. Intente nuevamente."); break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    // =====================================================
    // 1. GESTIÓN DE LOCALES (Nivel 1)
    // =====================================================

    private void menuGestionarLocales() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE LOCALES =====");
            System.out.println("1. Crear nuevo local");
            System.out.println("2. Actualizar local");
            System.out.println("3. Eliminar local");
            System.out.println("4. Consultar locales");
            System.out.println("5. Ingresar a un local específico");
            System.out.println("0. Volver al Menú Principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearLocal(); break;
                case 2: actualizarLocal(); break;
                case 3: eliminarLocal(); break;
                case 4: menuConsultarLocalesFiltros(); break;
                case 5:
                    int idLocal = leerEnteroPositivo("Ingrese el ID del local: ");
                    menuDetalleLocal(idLocal);
                    break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 1.5  DETALLE DE UN LOCAL ESPECÍFICO (Nivel 2)
    //       → Platos, Reseñas, Ubicación, Favorito
    // =====================================================

    private void menuDetalleLocal(int idLocal) {
        int opcion;
        do {
            System.out.println("\n--- LOCAL [" + idLocal + "] ---");
            System.out.println("1. Gestionar Platos del local");
            System.out.println("2. Gestionar Reseñas del local");
            System.out.println("3. Ver / Registrar Ubicación del local");
            System.out.println("4. Agregar este local a Mis Favoritos");
            System.out.println("0. Volver a Gestión de Locales");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: menuGestionarPlatos(idLocal); break;
                case 2: menuGestionarResenas(idLocal); break;
                case 3: menuGestionarUbicacion(idLocal); break;
                case 4: agregarLocalAFavoritos(idLocal); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 1.5.1  PLATOS (dentro de un local — Nivel 3)
    //         → Reseñas de un plato, Favorito de un plato
    // =====================================================

    private void menuGestionarPlatos(int idLocal) {
        int opcion;
        do {
            System.out.println("\n===== PLATOS (Local " + idLocal + ") =====");
            System.out.println("1. Crear plato");
            System.out.println("2. Actualizar plato");
            System.out.println("3. Eliminar plato");
            System.out.println("4. Consultar platos");
            System.out.println("5. Ingresar a un plato específico");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearPlato(idLocal); break;
                case 2: actualizarPlato(idLocal); break;
                case 3: eliminarPlato(); break;
                case 4: menuConsultarPlatosFiltros(); break;
                case 5:
                    int idPlato = leerEnteroPositivo("Ingrese el ID del plato: ");
                    menuDetallePlato(idLocal, idPlato);
                    break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 1.5.1.X  DETALLE DE UN PLATO ESPECÍFICO (Nivel 4)
    //           → Reseñas propias del plato
    // =====================================================

    private void menuDetallePlato(int idLocal, int idPlato) {
        int opcion;
        do {
            System.out.println("\n--- PLATO [" + idPlato + "] - Local [" + idLocal + "] ---");
            System.out.println("1. Gestionar Reseñas de este plato");
            System.out.println("0. Volver a Platos");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: menuGestionarResenas(idPlato); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 1.5.2  RESEÑAS (dentro de un local o plato — Nivel 3/4)
    // =====================================================

    private void menuGestionarResenas(int idContexto) {
        int opcion;
        do {
            System.out.println("\n===== RESEÑAS [Contexto ID: " + idContexto + "] =====");
            System.out.println("1. Crear reseña");
            System.out.println("2. Actualizar reseña");
            System.out.println("3. Eliminar reseña");
            System.out.println("4. Consultar reseñas");
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
    // 1.5.3  UBICACIÓN (dentro de un local — Nivel 3)
    // =====================================================

    private void menuGestionarUbicacion(int idLocal) {
        int opcion;
        do {
            System.out.println("\n===== UBICACIÓN (Local " + idLocal + ") =====");
            System.out.println("1. Registrar / Actualizar ubicación");
            System.out.println("2. Consultar ubicación");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearUbicacion(idLocal); break;
                case 2: consultarUbicacion(idLocal); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 2. GESTIÓN DE CATEGORÍAS GASTRONÓMICAS (Nivel 1)
    // =====================================================

    private void menuGestionarCategorias() {
        int opcion;
        do {
            System.out.println("\n===== CATEGORÍAS GASTRONÓMICAS =====");
            System.out.println("1. Crear categoría");
            System.out.println("2. Actualizar categoría");
            System.out.println("3. Eliminar categoría");
            System.out.println("4. Consultar categorías");
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
    // 3. GESTIÓN DE FACULTADES / PUNTOS DE REFERENCIA (Nivel 1)
    // =====================================================

    private void menuGestionarFacultades() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE FACULTADES =====");
            System.out.println("1. Crear facultad");
            System.out.println("2. Actualizar facultad");
            System.out.println("3. Eliminar facultad");
            System.out.println("4. Consultar facultades");
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
    // 4. GESTIÓN DE USUARIOS (Nivel 1)
    //    → Favoritos vive AQUÍ, pertenece al usuario
    // =====================================================

    private void menuGestionarUsuarios() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE USUARIOS =====");
            System.out.println("1. Crear cuenta base");
            System.out.println("2. Registrar usuario final");
            System.out.println("3. Registrar administrador (Centro de Comida)");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Consultar usuarios");
            System.out.println("7. Gestionar Mis Favoritos");
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

    // =====================================================
    // 4.7  FAVORITOS (dentro de Usuario — Nivel 2)
    //       Favorito referencia un idLocal, no un idPlato,
    //       según la clase Favorito actual.
    // =====================================================

    private void menuGestionarFavoritos() {
        int opcion;
        do {
            System.out.println("\n===== MIS FAVORITOS =====");
            System.out.println("1. Agregar local a favoritos");
            System.out.println("2. Eliminar local de favoritos");
            System.out.println("3. Consultar mis favoritos");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearFavorito(); break;
                case 2: eliminarFavorito(); break;
                case 3: menuConsultarFavoritosFiltros(); break;
                case 0: break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN / CRUD — LOCALES
    // =====================================================

    private void crearLocal() {
        System.out.println("\n--- CREAR LOCAL DE COMIDA ---");
        int idLocal = leerEnteroPositivo("Ingrese ID del local: ");
        String nombre = leerTextoValidado("Ingrese nombre del local: ", "Nombre inválido.", Validador::esNombreLocalValido);
        String descripcion = leerTextoValidado("Ingrese descripción del local: ", "Descripción inválida.", Validador::esDescripcionLocalValida);
        String telefono = leerTextoValidado("Ingrese teléfono (09XXXXXXXX): ", "Teléfono inválido.", Validador::esTelefonoValido);
        String horarioAtencion = leerTextoValidado("Ingrese horario (08:00-17:00): ", "Horario inválido.", Validador::esHorarioAtencionValido);
        String estadoLocal = leerTextoValidado("Estado del local (ABIERTO/CERRADO/ACTIVO/INACTIVO): ", "Estado inválido.", Validador::esEstadoLocalValido);
        String rangoPrecio = leerTextoValidado("Rango de precio (BAJO/MEDIO/ALTO): ", "Rango inválido.", Validador::esRangoPrecioValido);

        LocalComida local = new LocalComida(idLocal, nombre, descripcion, telefono, horarioAtencion, estadoLocal, rangoPrecio);
        System.out.println("Local creado correctamente:\n" + local);
    }

    private void actualizarLocal() {
        System.out.println("\n--- ACTUALIZAR LOCAL ---");
        int idLocal = leerEnteroPositivo("Ingrese ID del local a actualizar: ");
        System.out.println("Ingrese los nuevos datos:");
        crearLocal();
    }

    private void eliminarLocal() {
        System.out.println("\n--- ELIMINAR LOCAL ---");
        int idLocal = leerEnteroPositivo("Ingrese ID del local a eliminar: ");
        System.out.println("Local eliminado correctamente. ID: " + idLocal);
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN / CRUD — PLATOS
    // =====================================================

    private void crearPlato(int idLocal) {
        System.out.println("\n--- CREAR PLATO (Local " + idLocal + ") ---");
        int idPlato = leerEnteroPositivo("Ingrese ID del plato: ");
        String nombre = leerTextoValidado("Ingrese nombre del plato: ", "Nombre inválido.", Validador::esNombrePlatoValido);
        String categoria = leerTextoValidado("Ingrese categoría del plato: ", "Categoría inválida.", Validador::esCategoriaPlatoValida);
        String descripcion = leerTextoValidado("Ingrese descripción del plato: ", "Descripción inválida.", Validador::esDescripcionPlatoValida);
        double precio = leerDoublePositivo("Ingrese precio del plato: ");
        int fechaActualizacion = leerFechaNumerica("Ingrese fecha de actualización (AAAAMMDD): ");

        Plato plato = new Plato(idPlato, nombre, categoria, descripcion, precio, fechaActualizacion);
        System.out.println("Plato creado correctamente:\n" + plato);
    }

    private void actualizarPlato(int idLocal) {
        System.out.println("\n--- ACTUALIZAR PLATO ---");
        int idPlato = leerEnteroPositivo("Ingrese ID del plato a actualizar: ");
        System.out.println("Ingrese los nuevos datos:");
        crearPlato(idLocal);
    }

    private void eliminarPlato() {
        System.out.println("\n--- ELIMINAR PLATO ---");
        int idPlato = leerEnteroPositivo("Ingrese ID del plato a eliminar: ");
        System.out.println("Plato eliminado correctamente. ID: " + idPlato);
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN / CRUD — RESEÑAS
    // =====================================================

    private void crearResena() {
        System.out.println("\n--- CREAR RESEÑA ---");
        int idResena = leerEnteroPositivo("Ingrese ID de la reseña: ");
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
        int idResena = leerEnteroPositivo("Ingrese ID de la reseña a actualizar: ");
        System.out.println("Ingrese los nuevos datos:");
        crearResena();
    }

    private void eliminarResena() {
        System.out.println("\n--- ELIMINAR RESEÑA ---");
        int idResena = leerEnteroPositivo("Ingrese ID de la reseña a eliminar: ");
        System.out.println("Reseña eliminada correctamente. ID: " + idResena);
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN / CRUD — UBICACIÓN
    // =====================================================

    private void crearUbicacion(int idLocal) {
        System.out.println("\n--- REGISTRAR UBICACIÓN (Local " + idLocal + ") ---");
        String direccion = leerTextoValidado("Ingrese dirección: ", "Dirección inválida.", Validador::esDireccionValida);
        double latitud;
        do {
            latitud = leerDouble("Ingrese latitud (-90 a 90): ");
            if (!Validador.esLatitudValida(latitud)) System.out.println("Latitud inválida.");
        } while (!Validador.esLatitudValida(latitud));
        double longitud;
        do {
            longitud = leerDouble("Ingrese longitud (-180 a 180): ");
            if (!Validador.esLongitudValida(longitud)) System.out.println("Longitud inválida.");
        } while (!Validador.esLongitudValida(longitud));
        String referenciaTextual = leerTextoValidado("Ingrese referencia textual: ", "Referencia inválida.", Validador::esReferenciaTextualValida);

        Ubicacion ubicacion = new Ubicacion(direccion, latitud, longitud, referenciaTextual);
        System.out.println("Ubicación registrada correctamente:\n" + ubicacion);
    }

    private void consultarUbicacion(int idLocal) {
        System.out.println("\n--- CONSULTAR UBICACIÓN (Local " + idLocal + ") ---");
        System.out.println("(Requiere implementación con base de datos para recuperar la ubicación del local " + idLocal + ")");
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN / CRUD — CATEGORÍAS
    // =====================================================

    private void crearCategoria() {
        System.out.println("\n--- CREAR CATEGORÍA GASTRONÓMICA ---");
        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría: ");
        String nombreCategoria = leerTextoValidado("Ingrese nombre de categoría: ", "Nombre inválido.", Validador::esNombreCategoriaValido);
        String descripcion = leerTextoValidado("Ingrese descripción: ", "Descripción inválida.", Validador::esDescripcionCategoriaValida);

        // Se crea sin platos ni locales asociados aún (arreglos vacíos por ahora)
        CategoriaGastronomica categoria = new CategoriaGastronomica(idCategoria, nombreCategoria, descripcion, new Plato[0], new LocalComida[0]);
        System.out.println("Categoría creada correctamente:\n" + categoria);
    }

    private void actualizarCategoria() {
        System.out.println("\n--- ACTUALIZAR CATEGORÍA ---");
        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría a actualizar: ");
        String nuevoNombre = leerTextoValidado("Ingrese nuevo nombre: ", "Nombre inválido.", Validador::esNombreCategoriaValido);
        String nuevaDescripcion = leerTextoValidado("Ingrese nueva descripción: ", "Descripción inválida.", Validador::esDescripcionCategoriaValida);

        CategoriaGastronomica categoria = new CategoriaGastronomica(idCategoria, nuevoNombre, nuevaDescripcion, new Plato[0], new LocalComida[0]);
        System.out.println("Categoría actualizada correctamente:\n" + categoria);
    }

    private void eliminarCategoria() {
        System.out.println("\n--- ELIMINAR CATEGORÍA ---");
        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría a eliminar: ");
        System.out.println("Categoría eliminada correctamente. ID: " + idCategoria);
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN / CRUD — FACULTADES
    // =====================================================

    private void crearFacultad() {
        System.out.println("\n--- CREAR FACULTAD / PUNTO DE REFERENCIA ---");
        String nombre = leerTextoValidado("Ingrese nombre de la facultad: ", "Nombre inválido.", Validador::esNombreFacultadValido);
        String descripcion = leerTextoValidado("Ingrese descripción: ", "Descripción inválida.", Validador::esDescripcionFacultadValida);

        GestionarFacultad facultad = new GestionarFacultad(nombre, descripcion);
        System.out.println("Facultad creada correctamente:\n" + facultad);
    }

    private void actualizarFacultad() {
        System.out.println("\n--- ACTUALIZAR FACULTAD ---");
        String nombre = leerTextoValidado("Ingrese nuevo nombre: ", "Nombre inválido.", Validador::esNombreFacultadValido);
        String descripcion = leerTextoValidado("Ingrese nueva descripción: ", "Descripción inválida.", Validador::esDescripcionFacultadValida);

        GestionarFacultad facultad = new GestionarFacultad(nombre, descripcion);
        System.out.println("Facultad actualizada correctamente:\n" + facultad);
    }

    private void eliminarFacultad() {
        System.out.println("\n--- ELIMINAR FACULTAD ---");
        String nombre = leerTextoValidado("Ingrese nombre de la facultad a eliminar: ", "Nombre inválido.", Validador::esNombreFacultadValido);
        System.out.println("Facultad eliminada correctamente: " + nombre);
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN / CRUD — USUARIOS Y CUENTAS
    // =====================================================

    private void crearCuenta() {
        System.out.println("\n--- CREAR CUENTA BASE ---");
        // NOTA: idPersona fue eliminado del diagrama; Cuenta solo tiene nombre, correo y fechaNacimiento
        String nombre = leerTextoValidado("Ingrese nombre: ", "Nombre inválido (solo letras, mín 2 caracteres).", Validador::esNombreValido);
        String correo = leerTextoValidado("Ingrese correo UCE: ", "Correo inválido. Debe terminar en @uce.edu.ec.", Validador::esCorreoUCEValido);
        Date fechaNacimiento = leerFecha("Ingrese fecha de nacimiento (DD/MM/AAAA): ");

        Cuenta cuenta = new Cuenta(nombre, correo, fechaNacimiento);
        System.out.println("Cuenta creada correctamente:\n" + cuenta);
    }

    private void crearUsuarioFinal() {
        System.out.println("\n--- REGISTRAR USUARIO FINAL ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario: ");
        String nombre = leerTextoValidado("Ingrese nombre de usuario: ", "Nombre inválido.", Validador::esNombreUsuarioValido);

        UsuarioFinal usuarioFinal = new UsuarioFinal(idUsuario, nombre);
        System.out.println("Usuario final registrado correctamente:\n" + usuarioFinal);
    }

    private void crearCuentaAdministrador() {
        System.out.println("\n--- REGISTRAR ADMINISTRADOR (Centro de Comida) ---");
        String codigoAdministrador = leerTextoValidado("Ingrese código de administrador (ADM-001): ", "Código inválido. Formato: ADM-000.", Validador::esCodigoAdministradorValido);

        CentroComida administrador = new CentroComida(codigoAdministrador);
        System.out.println("Administrador registrado correctamente:\n" + administrador);
    }

    private void actualizarUsuario() {
        System.out.println("\n--- ACTUALIZAR USUARIO ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID del usuario a actualizar: ");
        String nuevoNombre = leerTextoValidado("Ingrese nuevo nombre: ", "Nombre inválido.", Validador::esNombreUsuarioValido);
        System.out.println("Usuario actualizado correctamente. ID: " + idUsuario + " | Nuevo nombre: " + nuevoNombre);
    }

    private void eliminarUsuario() {
        System.out.println("\n--- ELIMINAR USUARIO ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID del usuario a eliminar: ");
        System.out.println("Usuario eliminado correctamente. ID: " + idUsuario);
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN / CRUD — FAVORITOS
    // =====================================================

    private void crearFavorito() {
        System.out.println("\n--- AGREGAR LOCAL A FAVORITOS ---");
        int idFavorito = leerEnteroPositivo("Ingrese ID de favorito: ");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario: ");
        int idLocal = leerEnteroPositivo("Ingrese ID del local a guardar: ");
        int fechaAgregado = leerFechaNumerica("Ingrese fecha de guardado (AAAAMMDD): ");

        Favorito favorito = new Favorito(idFavorito, idUsuario, idLocal, fechaAgregado);
        System.out.println("Local guardado en favoritos:\n" + favorito);
    }

    /**
     * Acceso directo desde el detalle de un local:
     * ya sabe el idLocal, solo pide idUsuario.
     */
    private void agregarLocalAFavoritos(int idLocal) {
        System.out.println("\n--- AGREGAR LOCAL [" + idLocal + "] A MIS FAVORITOS ---");
        int idFavorito = leerEnteroPositivo("Ingrese ID de favorito: ");
        int idUsuario = leerEnteroPositivo("Ingrese su ID de usuario: ");
        int fechaAgregado = leerFechaNumerica("Ingrese fecha (AAAAMMDD): ");

        Favorito favorito = new Favorito(idFavorito, idUsuario, idLocal, fechaAgregado);
        System.out.println("Local guardado en favoritos:\n" + favorito);
    }

    private void eliminarFavorito() {
        System.out.println("\n--- ELIMINAR LOCAL DE FAVORITOS ---");
        int idFavorito = leerEnteroPositivo("Ingrese ID del favorito a eliminar: ");
        System.out.println("Favorito eliminado correctamente. ID: " + idFavorito);
    }

    // =====================================================
    // MENÚS DE FILTROS / CONSULTA
    // =====================================================

    private void menuConsultarLocalesFiltros() {
        System.out.println("\n--- FILTROS DE BÚSQUEDA DE LOCALES ---");
        System.out.println("1. Buscar por nombre");
        System.out.println("2. Buscar por facultad");
        System.out.println("3. Buscar por categoría gastronómica");
        System.out.println("4. Buscar por horario de atención");
        System.out.println("5. Buscar por estado (ABIERTO/CERRADO)");
        leerEntero("Seleccione filtro: ");
        System.out.println("(Requiere implementación con base de datos)");
    }

    private void menuConsultarPlatosFiltros() {
        System.out.println("\n--- FILTROS DE PLATOS ---");
        System.out.println("1. Buscar por categoría");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Buscar por rango de precio");
        leerEntero("Seleccione filtro: ");
        System.out.println("(Requiere implementación con base de datos)");
    }

    private void menuConsultarResenasFiltros() {
        System.out.println("\n--- FILTROS DE RESEÑAS ---");
        System.out.println("1. Consultar por calificación (estrellas)");
        System.out.println("2. Consultar más recientes");
        System.out.println("3. Consultar más antiguas");
        leerEntero("Seleccione filtro: ");
        System.out.println("(Requiere implementación con base de datos)");
    }

    private void menuConsultarCategoriaFiltros() {
        System.out.println("\n--- FILTROS DE CATEGORÍAS ---");
        System.out.println("1. Consultar almuerzos");
        System.out.println("2. Consultar desayunos");
        System.out.println("3. Consultar comida rápida");
        leerEntero("Seleccione filtro: ");
        System.out.println("(Requiere implementación con base de datos)");
    }

    private void menuConsultarFacultadFiltros() {
        System.out.println("\n--- FILTROS DE FACULTADES ---");
        System.out.println("1. Consultar por nombre de facultad");
        System.out.println("2. Consultar por espacio universitario");
        System.out.println("3. Consultar por punto de referencia");
        leerEntero("Seleccione filtro: ");
        System.out.println("(Requiere implementación con base de datos)");
    }

    private void menuConsultarUsuarioFiltros() {
        System.out.println("\n--- FILTROS DE USUARIOS ---");
        System.out.println("1. Consultar por ID");
        System.out.println("2. Consultar por nombre");
        leerEntero("Seleccione filtro: ");
        System.out.println("(Requiere implementación con base de datos)");
    }

    private void menuConsultarFavoritosFiltros() {
        System.out.println("\n--- MIS FAVORITOS GUARDADOS ---");
        System.out.println("1. Ver todos mis locales favoritos");
        System.out.println("2. Buscar favorito por ID de local");
        leerEntero("Seleccione filtro: ");
        System.out.println("(Requiere implementación con base de datos)");
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
            if (numero <= 0) System.out.println("El número debe ser mayor que cero.");
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
            if (numero <= 0) System.out.println("El número debe ser mayor que cero.");
        } while (numero <= 0);
        return numero;
    }

    private Date leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String fechaTexto = scanner.nextLine();
            try {
                return formatoFecha.parse(fechaTexto);
            } catch (ParseException e) {
                System.out.println("Fecha inválida. Use el formato DD/MM/AAAA.");
            }
        }
    }

    private int leerFechaNumerica(String mensaje) {
        int fecha;
        do {
            fecha = leerEntero(mensaje);
            if (String.valueOf(fecha).length() != 8) {
                System.out.println("Fecha inválida. Use formato AAAAMMDD (8 dígitos).");
            }
        } while (String.valueOf(fecha).length() != 8);
        return fecha;
    }

    private String leerTextoValidado(String mensaje, String mensajeError, ValidadorTexto validador) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            if (!validador.validar(texto)) System.out.println(mensajeError);
        } while (!validador.validar(texto));
        return texto;
    }

    @FunctionalInterface
    public interface ValidadorTexto {
        boolean validar(String texto);
    }
}