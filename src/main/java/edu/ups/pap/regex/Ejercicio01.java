package edu.ups.pap.regex;

import java.util.regex.Pattern;

/** E01: Palabras del catálogo. Contrato completo en README.md. */
public class Ejercicio01 {
    private final static Pattern REGEX = Pattern.compile("[a-z]{4,12}");
//**
// */
 //   if(texto == null){
          //  return false;
       // }
       // Matcher matcher = REGEX.matcher(texto);
      //  if(REGEX.matches(texto)){
       //     return true
       // }
       // return false;
    public static boolean validar(String texto) {
    

        return texto != null && REGEX.matcher(texto).matches();
    }
}
