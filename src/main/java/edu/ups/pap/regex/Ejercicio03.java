package edu.ups.pap.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ejercicio03 {

    private static final Pattern REGEX = Pattern.compile(
            "^(?!.*\\.\\.)[A-Za-z0-9](?:[A-Za-z0-9._-]*[A-Za-z0-9])?@(ups\\.edu\\.ec|est\\.ups\\.edu\\.ec)$",
            Pattern.CASE_INSENSITIVE
    );

    public static boolean validar(String texto) {

        if (texto == null || texto.isEmpty()) {
            return false;
        }

        Matcher matcher = REGEX.matcher(texto);

        return matcher.matches();
    }
}
