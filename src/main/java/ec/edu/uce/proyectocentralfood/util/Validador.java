package ec.edu.uce.proyectocentralfood.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    // =====================================================
    // REGEX GENERALES
    // =====================================================

    private static final String REGEX_SOLO_LETRAS =
            "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{2,50}$";

    private static final String REGEX_TEXTO_CON_NUMEROS =
            "^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9\\s.,'\\-]{2,80}$";

    private static final String REGEX_DESCRIPCION =
            "^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9\\s.,;:¡!¿?()#°'\\-]{5,200}$";

    private static final String REGEX_CORREO_UCE =
            "^[a-zA-Z0-9._%+-]+@uce\\.edu\\.ec$";

    private static final String REGEX_TELEFONO_ECUADOR =
            "^09\\d{8}$";

    private static final String REGEX_HORARIO_ATENCION =
            "^\\d{2}:\\d{2}-\\d{2}:\\d{2}$";

    private static final String REGEX_ESTADO_LOCAL =
            "^(ABIERTO|CERRADO|ACTIVO|INACTIVO)$";

    private static final String REGEX_RANGO_PRECIO =
            "^(BAJO|MEDIO|ALTO)$";

    private static final String REGEX_FECHA_NUMERICA =
            "^\\d{8}$";

    private static final String REGEX_DIRECCION =
            "^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9\\s.,#°'\\-]{5,120}$";

    private static final String REGEX_CODIGO_ADMINISTRADOR =
            "^ADM-\\d{3}$";

    // =====================================================
    // MOTOR DE VALIDACIÓN CON PATTERN Y MATCHER
    // =====================================================

    private static boolean validar(String texto, String regla) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile(regla);
        Matcher matcher = pattern.matcher(texto.trim());
        return matcher.matches();
    }

    // =====================================================
    // CUENTA
    // Atributos:
    // idPersona, nombre, correo, fechaNacimiento
    // =====================================================

    public static boolean esIdPersonaValido(int idPersona) {
        return idPersona > 0;
    }

    public static boolean esNombreValido(String nombre) {
        return validar(nombre, REGEX_SOLO_LETRAS);
    }

    public static boolean esCorreoUCEValido(String correo) {
        return validar(correo, REGEX_CORREO_UCE);
    }

    public static boolean esFechaNacimientoValida(Date fechaNacimiento) {
        if (fechaNacimiento == null) return false;

        // La fecha de nacimiento no puede ser hoy ni en el futuro
        return fechaNacimiento.before(new Date());
    }

    // =====================================================
    // CUENTA ADMINISTRADOR
    // Atributo:
    // codigoAdministrador
    // =====================================================

    public static boolean esCodigoAdministradorValido(String codigoAdministrador) {
        return validar(codigoAdministrador, REGEX_CODIGO_ADMINISTRADOR);
    }

    // =====================================================
    // USUARIO FINAL
    // Atributos:
    // idUsuario, nombre
    // =====================================================

    public static boolean esIdUsuarioValido(int idUsuario) {
        return idUsuario > 0;
    }

    public static boolean esNombreUsuarioValido(String nombre) {
        return validar(nombre, REGEX_SOLO_LETRAS);
    }

    // =====================================================
    // CATEGORÍA GASTRONÓMICA
    // Atributos:
    // idCategoria, nombreCategoria, descripcion
    // =====================================================

    public static boolean esIdCategoriaValido(int idCategoria) {
        return idCategoria > 0;
    }

    public static boolean esNombreCategoriaValido(String nombreCategoria) {
        return validar(nombreCategoria, REGEX_SOLO_LETRAS);
    }

    public static boolean esDescripcionCategoriaValida(String descripcion) {
        return validar(descripcion, REGEX_DESCRIPCION);
    }

    // =====================================================
    // FACULTAD
    // Atributos:
    // nombre, descripcion
    // =====================================================

    public static boolean esNombreFacultadValido(String nombre) {
        return validar(nombre, REGEX_TEXTO_CON_NUMEROS);
    }

    public static boolean esDescripcionFacultadValida(String descripcion) {
        return validar(descripcion, REGEX_DESCRIPCION);
    }

    // =====================================================
    // LOCAL COMIDA
    // Atributos:
    // idLocal, nombre, descripcion, telefono,
    // horarioAtencion, estadoLocal, rangoPrecio
    // =====================================================

    public static boolean esIdLocalValido(int idLocal) {
        return idLocal > 0;
    }

    public static boolean esNombreLocalValido(String nombre) {
        return validar(nombre, REGEX_TEXTO_CON_NUMEROS);
    }

    public static boolean esDescripcionLocalValida(String descripcion) {
        return validar(descripcion, REGEX_DESCRIPCION);
    }

    public static boolean esTelefonoValido(String telefono) {
        return validar(telefono, REGEX_TELEFONO_ECUADOR);
    }

    public static boolean esHorarioAtencionValido(String horarioAtencion) {
        return validar(horarioAtencion, REGEX_HORARIO_ATENCION);
    }

    public static boolean esEstadoLocalValido(String estadoLocal) {
        if (estadoLocal == null) {
            return false;
        }

        return validar(estadoLocal.toUpperCase(), REGEX_ESTADO_LOCAL);
    }

    public static boolean esRangoPrecioValido(String rangoPrecio) {
        if (rangoPrecio == null) {
            return false;
        }

        return validar(rangoPrecio.toUpperCase(), REGEX_RANGO_PRECIO);
    }

    // =====================================================
    // PLATO
    // Atributos:
    // idPlato, nombre, categoria, descripcion,
    // precio, fechaActualizacion
    // =====================================================

    public static boolean esIdPlatoValido(int idPlato) {
        return idPlato > 0;
    }

    public static boolean esNombrePlatoValido(String nombre) {
        return validar(nombre, REGEX_TEXTO_CON_NUMEROS);
    }

    public static boolean esCategoriaPlatoValida(String categoria) {
        return validar(categoria, REGEX_SOLO_LETRAS);
    }

    public static boolean esDescripcionPlatoValida(String descripcion) {
        return validar(descripcion, REGEX_DESCRIPCION);
    }

    public static boolean esPrecioPlatoValido(double precio) {
        return precio > 0;
    }

    public static boolean esFechaActualizacionValida(int fechaActualizacion) {
        return validar(String.valueOf(fechaActualizacion), REGEX_FECHA_NUMERICA);
    }
    // =====================================================
    // RESEÑA
    // Atributos:
    // idResena, calificacion, comentario, fechaCreacion
    // =====================================================

    public static boolean esIdResenaValido(int idResena) {
        return idResena > 0;
    }

    public static boolean esCalificacionValida(int calificacion) {
        return calificacion >= 1 && calificacion <= 5;
    }

    public static boolean esComentarioResenaValido(String comentario) {
        return validar(comentario, REGEX_DESCRIPCION);
    }

    public static boolean esFechaCreacionValida(Date fechaCreacion) {
        return fechaCreacion != null;
    }

    // =====================================================
    // FAVORITO
    // Atributos:
    // idFavorito, idUsuario, idLocal, fechaAgregado
    // =====================================================

    public static boolean esIdFavoritoValido(int idFavorito) {
        return idFavorito > 0;
    }

    public static boolean esFechaAgregadoValida(int fechaAgregado) {
        return validar(String.valueOf(fechaAgregado), REGEX_FECHA_NUMERICA);
    }

    // =====================================================
    // UBICACIÓN
    // Atributos:
    // direccion, latitud, longitud, referenciaTextual
    // =====================================================

    public static boolean esDireccionValida(String direccion) {
        return validar(direccion, REGEX_DIRECCION);
    }

    public static boolean esLatitudValida(double latitud) {
        return latitud >= -90 && latitud <= 90;
    }

    public static boolean esLongitudValida(double longitud) {
        return longitud >= -180 && longitud <= 180;
    }

    public static boolean esReferenciaTextualValida(String referenciaTextual) {
        return validar(referenciaTextual, REGEX_DESCRIPCION);
    }
}