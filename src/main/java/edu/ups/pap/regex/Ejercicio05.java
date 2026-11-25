package edu.ups.pap.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

//regex tiene validaciones de la ipv4
public class Ejercicio05 {

    private static final Pattern REGEX = Pattern.compile(
            "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\."
            + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\."
            + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\."
            + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$"
    );

    public static boolean validar(String texto) {

        if (texto == null || texto.isEmpty()) {
            return false;
        }

        Matcher matcher = REGEX.matcher(texto);

        return matcher.matches();
    }
}