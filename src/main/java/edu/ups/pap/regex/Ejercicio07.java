package edu.ups.pap.regex;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Ejercicio07 {

    private static final Pattern REGEX = Pattern.compile(
        "(?:^|[ \\t\\n\\r\\u000B\\f\\[\\](){}])"
        + "([THP](?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;(?:C|PCT|HPA))"
        + "(?=$|[ \\t\\n\\r\\u000B\\f\\[\\](){}])"
    );

    public static List<String> extraer(String texto) {

        List<String> resultados = new ArrayList<>();

        if (texto == null || texto.isEmpty()) {
            return resultados;
        }

        Matcher matcher = REGEX.matcher(texto);

        while (matcher.find()) {

            String trama = matcher.group(1);

            String[] partes = trama.split(";");

            String codigo = partes[0];
            String unidad = partes[2];

            char tipo = codigo.charAt(0);

            if ((tipo == 'T' && unidad.equals("C"))
                    || (tipo == 'H' && unidad.equals("PCT"))
                    || (tipo == 'P' && unidad.equals("HPA"))) {

                resultados.add(trama);
            }
        }

        return resultados;
    }
}