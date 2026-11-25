package edu.ups.pap.regex;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** E08: Analizar líneas de registro. Contrato completo en README.md. */
public class Ejercicio08 {

    private static final Pattern REGEX = Pattern.compile(
        "^(INFO|WARN|ERROR) "
        + "([0-9]{1,3}(?:\\.[0-9]{1,3}){3}) "
        + "([THP](?!000)[0-9]{3};-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?;(?:C|PCT|HPA))$"
    );

    public static List<String> analizar(String texto) {

        List<String> resultados = new ArrayList<>();

        if (texto == null || texto.isEmpty()) {
            return resultados;
        }

        String[] lineas = texto.split("\\r?\\n");

        for (String linea : lineas) {

            Matcher matcher = REGEX.matcher(linea);

            if (matcher.matches()) {

                String nivel = matcher.group(1);
                String ip = matcher.group(2);
                String trama = matcher.group(3);

                if (validarIP(ip) && validarTrama(trama)) {

                    String[] partes = trama.split(";");

                    resultados.add(
                        nivel + "|" + ip + "|" + partes[0] + "|" + partes[1] + "|" + partes[2]
                    );
                }
            }
        }

        return resultados;
    }

    private static boolean validarIP(String ip) {

        String[] partes = ip.split("\\.");

        if (partes.length != 4) {
            return false;
        }

        for (String parte : partes) {

            if (parte.isEmpty()) {
                return false;
            }

            if (parte.length() > 1 && parte.charAt(0) == '0') {
                return false;
            }

            int numero = Integer.parseInt(parte);

            if (numero < 0 || numero > 255) {
                return false;
            }
        }

        return true;
    }

    private static boolean validarTrama(String trama) {

        String[] partes = trama.split(";");

        if (partes.length != 3) {
            return false;
        }

        String codigo = partes[0];
        String valor = partes[1];
        String unidad = partes[2];

        char tipo = codigo.charAt(0);

        if (codigo.substring(1).equals("000")) {
            return false;
        }

        if (tipo == 'T' && !unidad.equals("C")) {
            return false;
        }

        if (tipo == 'H' && !unidad.equals("PCT")) {
            return false;
        }

        if (tipo == 'P' && !unidad.equals("HPA")) {
            return false;
        }

        return valor.matches("-?(?:0|[1-9][0-9]{0,3})(?:,[0-9]{1,2})?");
    }
}