package edu.ups.pap.regex;

import java.util.regex.Pattern;

/** E02: Códigos de dispositivos. Contrato completo en README.md. */
public class Ejercicio02 {

    private final static Pattern REGEX =  Pattern.compile("[THP](?!000)[0-9]{3}");

    public static boolean validar(String texto) {

        if (texto == null || texto.isEmpty()) {
            return false;
        }

        return REGEX.matcher(texto).matches();
    }
}