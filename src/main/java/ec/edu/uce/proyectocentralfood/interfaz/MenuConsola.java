package ec.edu.uce.proyectocentralfood.interfaz;

import ec.edu.uce.proyectocentralfood.dominio.*;
import ec.edu.uce.proyectocentralfood.util.Validador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuConsola {

    private final Scanner scanner;
    private final SimpleDateFormat formatoFecha;

    // Almacenamiento en memoria para persistencia real de datos
    private final List<LocalComida> listaLocales;
    private final List<UsuarioFinal> listaUsuarios;

    public MenuConsola() {
        this.scanner = new Scanner(System.in);
        this.formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        this.formatoFecha.setLenient(false);

        this.listaLocales = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();

        // Carga de datos iniciales para pruebas del sistema
        cargarDatosSimulados();
    }

    private void cargarDatosSimulados() {
        LocalComida localPrueba = new LocalComida(1, "Central Burgers", "Hamburguesas universitarias", "0987654321", "08:00-16:00", "ABIERTO", "MEDIO");
        listaLocales.add(localPrueba);
        UsuarioFinal usuarioPrueba = new UsuarioFinal(101, "Brandon Tacuri");
        listaUsuarios.add(usuarioPrueba);
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n=================================================");
            System.out.println("             SISTEMA CENTRAL FOOD                ");
            System.out.println("=================================================");
            System.out.println("1. Gestión de Locales");
            System.out.println("2. Gestión de Categorías Gastronómicas");
            System.out.println("3. Gestión de Facultades");
            System.out.println("4. Gestión de Usuarios");
            System.out.println("5. Gestión de Favoritos");
            System.out.println("6. Gestión de Reseñas");
            System.out.println("0. Salir");
            System.out.println("=================================================");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: menuGestionarLocales(); break;
                case 2: menuGestionarCategoria(); break;
                case 3: menuGestionarFacultad(); break;
                case 4: menuGestionarUsuario(); break;
                case 5:
                    // VALIDACIÓN ELIMINADA: Solo pide el entero y te deja pasar
                    int idUsuario = leerEnteroPositivo("\nIngrese su ID de Usuario para gestionar sus favoritos: ");
                    menuGestionarFavoritos(idUsuario);
                    break;
                case 6:
                    // VALIDACIÓN ELIMINADA: Solo pide el entero y te deja pasar
                    int idLocalResena = leerEnteroPositivo("\nIngrese el ID del Local para gestionar sus reseñas: ");
                    menuGestionarResenas(idLocalResena);
                    break;
                case 0:
                    System.out.println("\n[✔] Guardando datos... Saliendo del sistema Central Food. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("[✖] ERROR: Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    // =====================================================
    // 1. GESTIÓN DE LOCALES
    // =====================================================

    private void menuGestionarLocales() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE LOCALES =====");
            System.out.println("1. Crear local");
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
                case 4: consultarLocales(); break;
                case 5:
                    int idLocal = leerEnteroPositivo("Ingrese el ID del local al que desea ingresar: ");
                    LocalComida localSeleccionado = buscarLocalPorId(idLocal);
                    if (localSeleccionado != null) {
                        menuDetalleLocal(localSeleccionado);
                    } else {
                        System.out.println("[✖] ERROR: No se encontró ningún local con el ID " + idLocal);
                    }
                    break;
                case 0: break;
                default: System.out.println("[✖] ERROR: Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    private void menuDetalleLocal(LocalComida local) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN INTERNA DEL LOCAL [" + local.getNombre() + " - ID: " + local.getIdLocal() + "] ---");
            System.out.println("1. Gestionar platos");
            System.out.println("2. Crear reseña");
            System.out.println("3. Agregar a favoritos");
            System.out.println("4. Registrar / Ver ubicación");
            System.out.println("0. Volver a Gestión de Locales");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: menuGestionarPlatos(local); break;
                case 2: crearResenaContextual(local); break;
                case 3: crearFavoritoContextual(local); break;
                case 4: gestionarUbicacionLocal(local); break;
                case 0: break;
                default: System.out.println("[✖] ERROR: Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // GESTIÓN DE PLATOS
    // =====================================================

    private void menuGestionarPlatos(LocalComida local) {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE PLATOS =====");
            System.out.println("1. Crear plato");
            System.out.println("2. Actualizar plato");
            System.out.println("3. Eliminar plato");
            System.out.println("4. Consultar platos");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearPlatoContextual(local); break;
                case 2: actualizarPlatoContextual(local); break;
                case 3: eliminarPlatoContextual(local); break;
                case 4: consultarPlatosContextual(local); break;
                case 0: break;
                default: System.out.println("[✖] ERROR: Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 2. GESTIÓN DE CATEGORÍAS GASTRONÓMICAS
    // =====================================================

    private void menuGestionarCategoria() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE CATEGORÍAS GASTRONÓMICAS =====");
            System.out.println("1. Crear categoría");
            System.out.println("2. Actualizar categoría");
            System.out.println("3. Eliminar categoría");
            System.out.println("4. Consultar categorías");
            System.out.println("0. Volver al Menú Principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearCategoria(); break;
                case 2: System.out.println("[i] Función de actualización en desarrollo..."); break;
                case 3: System.out.println("[i] Función de eliminación en desarrollo..."); break;
                case 4: System.out.println("[i] Consulta de categorías en desarrollo..."); break;
                case 0: break;
                default: System.out.println("[✖] ERROR: Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 3. GESTIÓN DE FACULTADES
    // =====================================================

    private void menuGestionarFacultad() {
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
                case 2: System.out.println("[i] Función de actualización en desarrollo..."); break;
                case 3: System.out.println("[i] Función de eliminación en desarrollo..."); break;
                case 4: System.out.println("[i] Consulta de facultades en desarrollo..."); break;
                case 0: break;
                default: System.out.println("[✖] ERROR: Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 4. GESTIÓN DE USUARIOS
    // =====================================================

    private void menuGestionarUsuario() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE USUARIOS =====");
            System.out.println("1. Crear cuenta base");
            System.out.println("2. Crear usuario final");
            System.out.println("3. Crear Centro de Comida");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Consultar usuarios");
            System.out.println("0. Volver al Menú Principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: crearCuenta(); break;
                case 2: crearUsuarioFinal(); break;
                case 3: crearCuentaAdministrador(); break;
                case 4: System.out.println("[i] Función de actualización en desarrollo..."); break;
                case 5: System.out.println("[i] Función de eliminación en desarrollo..."); break;
                case 6: consultarUsuarios(); break;
                case 0: break;
                default: System.out.println("[✖] ERROR: Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 5. GESTIÓN DE FAVORITOS (ACCESO LIBRE)
    // =====================================================

    private void menuGestionarFavoritos(int idUsuario) {
        // Se busca al usuario. Si no se encuentra, se crea uno "fantasma" para que el menú no explote.
        UsuarioFinal usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            usuario = new UsuarioFinal();
            usuario.setIdPersona(idUsuario);
        }

        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE FAVORITOS =====");
            System.out.println("1. Actualizar favorito");
            System.out.println("2. Eliminar favorito");
            System.out.println("3. Consultar favoritos");
            System.out.println("0. Volver al Menú Principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: System.out.println("[i] Función de actualización en desarrollo..."); break;
                case 2:
                    if (usuario.getFavoritos() == null || usuario.getFavoritos().isEmpty()) {
                        System.out.println("[i] No tienes favoritos agregados.");
                    } else {
                        int idFav = leerEnteroPositivo("Ingrese el ID del favorito a eliminar: ");
                        boolean eliminado = usuario.getFavoritos().removeIf(f -> f.getIdFavorito() == idFav);
                        if (eliminado) System.out.println("[✔] ÉXITO: Favorito eliminado correctamente.");
                        else System.out.println("[✖] ERROR: No se encontró ese ID de favorito.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- MIS FAVORITOS ---");
                    if (usuario.getFavoritos() == null || usuario.getFavoritos().isEmpty()) {
                        System.out.println("No tienes locales guardados en tus favoritos.");
                    } else {
                        for (Favorito f : usuario.getFavoritos()) {
                            System.out.println(f + " | Fecha formateada: " + convertirIntAFechaString(f.getFechaAgregado()));
                        }
                    }
                    break;
                case 0: break;
                default: System.out.println("[✖] ERROR: Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // 6. GESTIÓN DE RESEÑAS (ACCESO LIBRE)
    // =====================================================

    private void menuGestionarResenas(int idLocal) {
        // Se busca el local. Si no se encuentra, se crea uno temporal para evitar bloqueos.
        LocalComida local = buscarLocalPorId(idLocal);
        if (local == null) {
            local = new LocalComida();
            local.setIdLocal(idLocal);
            local.setNombre("Local Desconocido");
        }

        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE RESEÑAS =====");
            System.out.println("1. Actualizar reseña");
            System.out.println("2. Eliminar reseña");
            System.out.println("3. Consultar reseñas");
            System.out.println("0. Volver al Menú Principal");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    if (local.getResenas() == null || local.getResenas().isEmpty()) {
                        System.out.println("[i] El local no tiene reseñas para actualizar.");
                    } else {
                        int idRes = leerEnteroPositivo("Ingrese el ID de la reseña a actualizar: ");
                        Resena resenaAEditar = null;
                        for (Resena r : local.getResenas()) {
                            if (r.getIdResena() == idRes) { resenaAEditar = r; break; }
                        }
                        if (resenaAEditar != null) {
                            String nuevoComentario = leerTextoValidado("Ingrese nuevo comentario: ", "Comentario inválido.", "Debe tener entre 5 y 200 caracteres.", Validador::esComentarioResenaValido);
                            resenaAEditar.setComentario(nuevoComentario);
                            System.out.println("[✔] ÉXITO: Reseña actualizada correctamente.");
                        } else {
                            System.out.println("[✖] ERROR: ID de reseña no encontrado.");
                        }
                    }
                    break;
                case 2:
                    if (local.getResenas() == null || local.getResenas().isEmpty()) {
                        System.out.println("[i] El local no tiene reseñas registradas.");
                    } else {
                        int idRes = leerEnteroPositivo("Ingrese el ID de la reseña a eliminar: ");
                        boolean removido = local.getResenas().removeIf(r -> r.getIdResena() == idRes);
                        if (removido) System.out.println("[✔] ÉXITO: Reseña eliminada correctamente.");
                        else System.out.println("[✖] ERROR: ID de reseña no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- RESEÑAS DEL LOCAL [" + local.getNombre() + "] ---");
                    if (local.getResenas() == null || local.getResenas().isEmpty()) {
                        System.out.println("Este local aún no cuenta con reseñas de usuarios.");
                    } else {
                        for (Resena r : local.getResenas()) {
                            System.out.println(r);
                        }
                    }
                    break;
                case 0: break;
                default: System.out.println("[✖] ERROR: Opción inválida."); break;
            }
        } while (opcion != 0);
    }

    // =====================================================
    // MÉTODOS DE CREACIÓN Y MODIFICACIÓN REAL DE PLATOS
    // =====================================================

    private void crearPlatoContextual(LocalComida local) {
        System.out.println("\n--- CREAR PLATO ---");
        int idPlato = leerEnteroPositivo("Ingrese ID del plato: ");

        for (Plato p : local.getPlatos()) {
            if (p.getIdPlato() == idPlato) {
                System.out.println("[✖] ERROR: Ya existe un plato con ese ID en este local.");
                return;
            }
        }

        String nombre = leerTextoValidado("Ingrese nombre del plato: ", "Nombre inválido.", "Solo letras, números y espacios (mín. 2 caracteres).", Validador::esNombrePlatoValido);
        String cat = leerTextoValidado("Ingrese categoría del plato: ", "Categoría inválida.", "Solo letras (ej. Almuerzos, Bebidas).", Validador::esCategoriaPlatoValida);
        String descripcion = leerTextoValidado("Ingrese descripción del plato: ", "Descripción inválida.", "Entre 5 y 200 caracteres.", Validador::esDescripcionPlatoValida);
        double precio = leerDoublePositivo("Ingrese precio del plato ($): ");
        int fechaActualizacion = leerFechaComoInt8Digitos("Ingrese fecha de actualización (DD/MM/AAAA): ");

        Plato nuevoPlato = new Plato(idPlato, nombre, cat, descripcion, precio, fechaActualizacion);
        nuevoPlato.setLocalComida(local);

        local.agregarPlato(nuevoPlato);
        System.out.println("\n[✔] ÉXITO: Plato creado correctamente y añadido a " + local.getNombre());
    }

    private void actualizarPlatoContextual(LocalComida local) {
        System.out.println("\n--- ACTUALIZAR PLATO ---");
        if (local.getPlatos().isEmpty()) {
            System.out.println("[i] No hay platos registrados en este local para actualizar.");
            return;
        }

        int idPlato = leerEnteroPositivo("Ingrese el ID del plato que desea modificar: ");
        Plato platoAEditar = null;
        for (Plato p : local.getPlatos()) {
            if (p.getIdPlato() == idPlato) { platoAEditar = p; break; }
        }

        if (platoAEditar != null) {
            System.out.println("Plato actual encontrado: " + platoAEditar.getNombre());
            String nuevoNombre = leerTextoValidado("Ingrese nuevo nombre del plato: ", "Nombre inválido.", "Mínimo 2 caracteres.", Validador::esNombrePlatoValido);
            double nuevoPrecio = leerDoublePositivo("Ingrese nuevo precio ($): ");
            int nuevaFecha = leerFechaComoInt8Digitos("Ingrese nueva fecha de modificación (DD/MM/AAAA): ");

            platoAEditar.setNombre(nuevoNombre);
            platoAEditar.setPrecio(nuevoPrecio);
            platoAEditar.setFechaActualizacion(nuevaFecha);

            System.out.println("\n[✔] ÉXITO: El plato se ha actualizado correctamente en el sistema.");
        } else {
            System.out.println("[✖] ERROR: El ID ingresado no corresponde a ningún plato de este restaurante.");
        }
    }

    private void eliminarPlatoContextual(LocalComida local) {
        System.out.println("\n--- ELIMINAR PLATO ---");
        if (local.getPlatos().isEmpty()) {
            System.out.println("[i] No hay platos para eliminar.");
            return;
        }
        int idPlato = leerEnteroPositivo("Ingrese el ID del plato a eliminar: ");
        boolean eliminado = local.getPlatos().removeIf(p -> p.getIdPlato() == idPlato);

        if (eliminado) System.out.println("[✔] ÉXITO: Plato eliminado correctamente de la lista.");
        else System.out.println("[✖] ERROR: No se encontró ningún plato con ese ID.");
    }

    private void consultarPlatosContextual(LocalComida local) {
        System.out.println("\n--- CARTELERA DE PLATOS: " + local.getNombre().toUpperCase() + " ---");
        if (local.getPlatos().isEmpty()) {
            System.out.println("Este local de comida aún no tiene platos registrados en su menú.");
        } else {
            for (Plato p : local.getPlatos()) {
                System.out.println(p + " | Última Modificación: " + convertirIntAFechaString(p.getFechaActualizacion()));
            }
        }
    }

    // =====================================================
    // MÉTODOS DE OPERACIÓN REAL DE LOCALES
    // =====================================================

    private void crearLocal() {
        System.out.println("\n--- CREAR LOCAL DE COMIDA ---");
        int idLocal = leerEnteroPositivo("Ingrese ID del local: ");

        for (LocalComida l : listaLocales) {
            if (l.getIdLocal() == idLocal) {
                System.out.println("[✖] ERROR: Ya existe un local con ese ID."); return;
            }
        }

        String nombre = leerTextoValidado("Ingrese nombre del local: ", "Nombre inválido.", "Solo letras y números, mín. 2 caracteres.", Validador::esNombreLocalValido);
        String descripcion = leerTextoValidado("Ingrese descripción del local: ", "Descripción inválida.", "Entre 5 y 200 caracteres.", Validador::esDescripcionLocalValida);
        String telefono = leerTextoValidado("Ingrese teléfono del local: ", "Teléfono inválido.", "Debe iniciar con 09 y tener exactamente 10 dígitos.", Validador::esTelefonoValido);
        String horarioAtencion = leerTextoValidado("Ingrese horario de atención: ", "Formato de horario incorrecto.", "Estructura requerida: HH:MM-HH:MM (ej. 08:00-17:00).", Validador::esHorarioAtencionValido);
        String estadoLocal = leerTextoValidado("Ingrese estado del local: ", "Estado no reconocido.", "Use una de estas opciones: ABIERTO, CERRADO, ACTIVO, INACTIVO.", Validador::esEstadoLocalValido);
        String rangoPrecio = leerTextoValidado("Ingrese rango de precio: ", "Rango no reconocido.", "Use una de estas opciones: BAJO, MEDIO, ALTO.", Validador::esRangoPrecioValido);

        LocalComida nuevoLocal = new LocalComida(idLocal, nombre, descripcion, telefono, horarioAtencion, estadoLocal, rangoPrecio);
        listaLocales.add(nuevoLocal);
        System.out.println("\n[✔] ÉXITO: Local creado correctamente en el sistema.");
    }

    private void actualizarLocal() {
        System.out.println("\n--- ACTUALIZAR LOCAL ---");
        if (listaLocales.isEmpty()) {
            System.out.println("[i] No hay locales registrados para actualizar.");
            return;
        }

        int idLocal = leerEnteroPositivo("Ingrese el ID del local a actualizar: ");
        LocalComida localAEditar = buscarLocalPorId(idLocal);

        if (localAEditar != null) {
            System.out.println("Local encontrado: " + localAEditar.getNombre());
            String nuevoNombre = leerTextoValidado("Ingrese nuevo nombre del local: ", "Nombre inválido.", "Solo letras y números.", Validador::esNombreLocalValido);
            String nuevaDesc = leerTextoValidado("Ingrese nueva descripción: ", "Descripción inválida.", "Entre 5 y 200 caracteres.", Validador::esDescripcionLocalValida);

            localAEditar.setNombre(nuevoNombre);
            localAEditar.setDescripcion(nuevaDesc);
            System.out.println("\n[✔] ÉXITO: Local actualizado correctamente en el sistema.");
        } else {
            System.out.println("[✖] ERROR: No se encontró ningún local con ese ID.");
        }
    }

    private void eliminarLocal() {
        System.out.println("\n--- ELIMINAR LOCAL ---");
        if (listaLocales.isEmpty()) {
            System.out.println("[i] No hay locales para eliminar.");
            return;
        }

        int idLocal = leerEnteroPositivo("Ingrese el ID del local a eliminar: ");
        boolean eliminado = listaLocales.removeIf(l -> l.getIdLocal() == idLocal);

        if (eliminado) {
            System.out.println("[✔] ÉXITO: Local eliminado del sistema permanentemente.");
        } else {
            System.out.println("[✖] ERROR: No se encontró ningún local con ese ID.");
        }
    }

    private void consultarLocales() {
        System.out.println("\n--- REGISTRO GENERAL DE LOCALES ---");
        if (listaLocales.isEmpty()) {
            System.out.println("No hay locales de comida registrados.");
        } else {
            for (LocalComida l : listaLocales) {
                System.out.println(l);
            }
        }
    }

    // =====================================================
    // OTROS COMPONENTES GLOBALES DEL SISTEMA
    // =====================================================

    private void crearResenaContextual(LocalComida local) {
        System.out.println("\n--- CREAR RESEÑA ---");
        int idResena = leerEnteroPositivo("Ingrese un ID único para su reseña: ");
        int calificacion;
        do {
            calificacion = leerEntero("Ingrese calificación (1 a 5 estrellas): ");
            if (!Validador.esCalificacionValida(calificacion)) {
                System.out.println("[✖] ERROR: La calificación debe estar estrictamente entre 1 y 5.");
            }
        } while (!Validador.esCalificacionValida(calificacion));

        String comentario = leerTextoValidado("Ingrese su comentario: ", "Comentario muy corto o con caracteres no permitidos.", "Debe tener entre 5 y 200 caracteres.", Validador::esComentarioResenaValido);
        Date fechaCreacion = new Date();

        Resena resena = new Resena(idResena, calificacion, comentario, fechaCreacion);
        resena.setLocalComida(local);

        local.recibirResena(resena);
        System.out.println("\n[✔] ÉXITO: Reseña guardada y vinculada a " + local.getNombre());
    }

    private void crearFavoritoContextual(LocalComida local) {
        System.out.println("\n--- CREAR FAVORITO ---");
        int idUsuario = leerEnteroPositivo("Ingrese su ID de Usuario para asociar el favorito: ");
        UsuarioFinal usuario = buscarUsuarioPorId(idUsuario);

        if (usuario == null) {
            System.out.println("[✖] ERROR: El usuario no existe. Debe crearlo primero en el menú de Usuarios.");
            return;
        }

        int idFavorito = leerEnteroPositivo("Ingrese un ID para este registro de favorito: ");
        int fechaAgregado = leerFechaComoInt8Digitos("Ingrese fecha de agregado (DD/MM/AAAA): ");

        Favorito favorito = new Favorito(idFavorito, idUsuario, local.getIdLocal(), fechaAgregado);
        usuario.agregarAFavoritos(favorito);
        System.out.println("\n[✔] ÉXITO: " + local.getNombre() + " fue añadido a los favoritos de " + usuario.getNombre());
    }

    private void gestionarUbicacionLocal(LocalComida local) {
        System.out.println("\n--- REGISTRAR / VER UBICACIÓN ---");
        if (local.getUbicacion() != null) {
            System.out.println("Ubicación actual de este local:\n" + local.getUbicacion());
            System.out.print("¿Desea reescribir la ubicación? (1: Sí / 0: No): ");
            if (leerEntero("") == 0) return;
        }

        String direccion = leerTextoValidado("Ingrese dirección: ", "Dirección inválida.", "Mínimo 5 caracteres.", Validador::esDireccionValida);
        double latitud;
        do {
            latitud = leerDouble("Ingrese latitud: ");
            if (!Validador.esLatitudValida(latitud)) System.out.println("[✖] ERROR: Rango de latitud inválido (-90 a 90).");
        } while (!Validador.esLatitudValida(latitud));

        double longitud;
        do {
            longitud = leerDouble("Ingrese longitud: ");
            if (!Validador.esLongitudValida(longitud)) System.out.println("[✖] ERROR: Rango de longitud inválido (-180 a 180).");
        } while (!Validador.esLongitudValida(longitud));

        String ref = leerTextoValidado("Ingrese referencia textual: ", "Referencia inválida.", "Entre 5 y 200 caracteres.", Validador::esReferenciaTextualValida);

        Ubicacion ub = new Ubicacion(direccion, latitud, longitud, ref);
        ub.setLocalComida(local);
        local.setUbicacion(ub);
        System.out.println("\n[✔] ÉXITO: Ubicación vinculada correctamente al restaurante.");
    }

    private void crearCategoria() {
        System.out.println("\n--- CREAR CATEGORÍA GASTRONÓMICA ---");
        int idCategoria = leerEnteroPositivo("Ingrese ID de categoría: ");
        String nombreCategoria = leerTextoValidado("Ingrese nombre de categoría: ", "Nombre inválido.", "Solo letras.", Validador::esNombreCategoriaValido);
        String descripcion = leerTextoValidado("Ingrese descripción: ", "Descripción inválida.", "Entre 5 y 200 caracteres.", Validador::esDescripcionCategoriaValida);

        CategoriaGastronomica categoria = new CategoriaGastronomica(idCategoria, nombreCategoria, descripcion);
        System.out.println("\n[✔] ÉXITO: Categoría creada (Objeto instanciado):\n" + categoria);
    }

    private void crearFacultad() {
        System.out.println("\n--- CREAR FACULTAD ---");
        String nombre = leerTextoValidado("Ingrese nombre de la facultad: ", "Nombre inválido.", "Mín. 2 caracteres.", Validador::esNombreFacultadValido);
        String descripcion = leerTextoValidado("Ingrese descripción: ", "Descripción inválida.", "Entre 5 y 200 caracteres.", Validador::esDescripcionFacultadValida);

        Facultad facultad = new Facultad(nombre, descripcion);
        System.out.println("\n[✔] ÉXITO: Facultad creada (Objeto instanciado):\n" + facultad);
    }

    private void crearCuenta() {
        System.out.println("\n--- CREAR CUENTA BASE ---");
        int idPersona = leerEnteroPositivo("Ingrese ID de persona: ");
        String nombre = leerTextoValidado("Ingrese su nombre completo: ", "Nombre inválido.", "Solo letras.", Validador::esNombreValido);
        String correo = leerTextoValidado("Ingrese correo institucional UCE: ", "Dominio incorrecto.", "Debe terminar en @uce.edu.ec", Validador::esCorreoUCEValido);
        Date fechaNacimiento = leerFecha("Ingrese fecha de nacimiento (DD/MM/AAAA): ");

        Cuenta cuenta = new Cuenta(idPersona, nombre, correo, fechaNacimiento);
        System.out.println("\n[✔] ÉXITO: Cuenta instanciada correctamente:\n" + cuenta);
    }

    private void crearUsuarioFinal() {
        System.out.println("\n--- CREAR USUARIO FINAL ---");
        int idUsuario = leerEnteroPositivo("Ingrese ID de usuario: ");
        String nombre = leerTextoValidado("Ingrese nombre del usuario: ", "Nombre inválido.", "Solo letras.", Validador::esNombreUsuarioValido);

        UsuarioFinal nuevoUsuario = new UsuarioFinal(idUsuario, nombre);
        listaUsuarios.add(nuevoUsuario);
        System.out.println("\n[✔] ÉXITO: Usuario guardado en el sistema.");
    }

    private void crearCuentaAdministrador() {
        System.out.println("\n--- CREAR CUENTA DE ADMINISTRADOR ---");
        String codigoAdministrador = leerTextoValidado("Ingrese código de administrador: ", "Formato inválido.", "Debe ser ADM-XXX (ej. ADM-001).", Validador::esCodigoAdministradorValido);

        CentroComida administrador = new CentroComida(codigoAdministrador);
        System.out.println("\n[✔] ÉXITO: Administrador instanciado:\n" + administrador);
    }

    private void consultarUsuarios() {
        System.out.println("\n--- LISTA DE USUARIOS FINALES ---");
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios finales registrados.");
        } else {
            for (UsuarioFinal u : listaUsuarios) {
                System.out.println(u);
            }
        }
    }

    // =====================================================
    // MÉTODOS AUXILIARES DE BÚSQUEDA
    // =====================================================

    private LocalComida buscarLocalPorId(int id) {
        for (LocalComida l : listaLocales) {
            if (l.getIdLocal() == id) return l;
        }
        return null;
    }

    private UsuarioFinal buscarUsuarioPorId(int id) {
        for (UsuarioFinal u : listaUsuarios) {
            if (u.getIdPersona() == id) return u;
        }
        return null;
    }

    // =====================================================
    // PROCESAMIENTO INTELECTUAL DE FORMATOS DE FECHA
    // =====================================================

    private int leerFechaComoInt8Digitos(String mensaje) {
        while (true) {
            Date fechaObj = leerFecha(mensaje);
            SimpleDateFormat convertidor = new SimpleDateFormat("yyyyMMdd");
            int fechaEntera = Integer.parseInt(convertidor.format(fechaObj));

            if (Validador.esFechaActualizacionValida(fechaEntera)) {
                return fechaEntera;
            } else {
                System.out.println("[✖] ERROR: La fecha ingresada no cumple el formato o rango del sistema.");
            }
        }
    }

    private String convertirIntAFechaString(int fechaInt) {
        String s = String.valueOf(fechaInt);
        if (s.length() != 8) return s;
        String anio = s.substring(0, 4);
        String mes = s.substring(4, 6);
        String dia = s.substring(6, 8);
        return anio + "/" + mes + "/" + dia;
    }

    // =====================================================
    // MOTOR ROBUSTO DE ENTRADA (ANTI-CRASH)
    // =====================================================

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[✖] ERROR: Entrada no válida. Debe ingresar un número entero sin letras ni símbolos.");
            }
        }
    }

    private int leerEnteroPositivo(String mensaje) {
        int numero;
        while (true) {
            numero = leerEntero(mensaje);
            if (numero > 0) return numero;
            else System.out.println("[✖] ERROR: El número debe ser mayor a cero.");
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[✖] ERROR: Entrada no válida. Ingrese un decimal usando punto.");
            }
        }
    }

    private double leerDoublePositivo(String mensaje) {
        double numero;
        while (true) {
            numero = leerDouble(mensaje);
            if (numero > 0) return numero;
            else System.out.println("[✖] ERROR: El número debe ser mayor a cero.");
        }
    }

    private Date leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String fechaTexto = scanner.nextLine().trim();
            try {
                return formatoFecha.parse(fechaTexto);
            } catch (ParseException e) {
                System.out.println("[✖] ERROR: Fecha inválida. Use el formato DD/MM/AAAA (ej. 14/05/2026).");
            }
        }
    }

    private String leerTextoValidado(String mensaje, String mensajeError, String sugerencia, ValidadorTexto validador) {
        String texto;
        while (true) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (validador.validar(texto)) {
                return texto;
            } else {
                System.out.println("[✖] ERROR: " + mensajeError);
                if (sugerencia != null && !sugerencia.isEmpty()) {
                    System.out.println("    [!] Sugerencia: " + sugerencia);
                }
            }
        }
    }

    @FunctionalInterface
    public interface ValidadorTexto {
        boolean validar(String texto);
    }
}