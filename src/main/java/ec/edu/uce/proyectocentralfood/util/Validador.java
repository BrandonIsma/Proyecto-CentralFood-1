package ec.edu.uce.proyectocentralfood.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    // 1. DEFINICIÓN DE REGLAS (MOLDES - PATTERN)

    private static final String REGEX_PLATO = "^PLT-\\d+$";
    private static final String REGEX_USUARIO = "^USR-\\d+$";
    private static final String REGEX_SOLO_LETRAS = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
    private static final String REGEX_FECHA = "^\\d{2}/\\d{2}/\\d{4}$"; // Formato DD/MM/AAAA
    private static final String REGEX_CORREO_UCE = "^[a-zA-Z0-9._%+-]+@uce\\.edu\\.ec$";

    /**
     * El "Motor" de validación que usa Matcher y Pattern
     */
    private static boolean validar(String texto, String regla) {
        if (texto == null || texto.trim().isEmpty()) return false;
        Pattern pattern = Pattern.compile(regla);
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    // 2. MÉTODOS PÚBLICOS

    public static boolean esIdPlatoValido(String id) {
        return validar(id, REGEX_PLATO);
    }

    public static boolean esIdUsuarioValido(String id) {
        return validar(id, REGEX_USUARIO);
    }

    public static boolean esTextoValido(String texto) {
        return validar(texto, REGEX_SOLO_LETRAS);
    }

    public static boolean esFechaValida(String fecha) {
        return validar(fecha, REGEX_FECHA);
    }

    public static boolean esCorreoUCEValido(String correo) {
        return validar(correo, REGEX_CORREO_UCE);
    }
}