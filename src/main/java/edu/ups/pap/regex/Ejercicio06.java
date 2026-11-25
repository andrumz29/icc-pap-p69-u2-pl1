package edu.ups.pap.regex;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ejercicio06 {

    public static List<String> buscar(String texto, String palabra) {

        List<String> resultados = new ArrayList<>();

        if (texto == null || texto.isEmpty() || palabra == null || palabra.isEmpty()) {
            return resultados;
        }

        if (!palabra.matches("[A-Za-z]+")) {
            return resultados;
        }

        String regex = "(?i)(?<![A-Za-z0-9_])" + palabra + "(?![A-Za-z0-9_])";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            resultados.add(matcher.group());
        }

        return resultados;
    }
}