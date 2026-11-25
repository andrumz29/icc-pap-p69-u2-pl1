package edu.ups.pap.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

//sensores 
public class Ejercicio04 {

    private static final Pattern REGEX = Pattern.compile(
            "^([THP])(?!000)[0-9]{3};(-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?);(C|PCT|HPA)$"
    );

    public static boolean validar(String texto) {

        if (texto == null || texto.isEmpty()) {
            return false;
        }

        Matcher matcher = REGEX.matcher(texto);

        if (!matcher.matches()) {
            return false;
        }

        String codigo = matcher.group(1);
        String unidad = matcher.group(3);
//validar lo que va en cada unidad es un sensor que tiene estas unidades 
        if (codigo.equals("T")) {
            return unidad.equals("C");
        }

        if (codigo.equals("H")) {
            return unidad.equals("PCT");
        }

        if (codigo.equals("P")) {
            return unidad.equals("HPA");
        }

        return false;
    }
}