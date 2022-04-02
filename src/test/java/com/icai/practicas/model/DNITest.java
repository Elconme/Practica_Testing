package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DNITest {

    @Test
    public void DNI_con_formato_adecuado(){

        DNI dni = new DNI("45132222N");

        boolean result = dni.validar();
        assertEquals(true,result);

        /*
        // DNI que si cumplen todas las validaciones
            assertTrue(Validaciones.validarDNI("12345678Z"));
            assertTrue(Validaciones.validarDNI("45673254S"));
            assertTrue(Validaciones.validarDNI("72849506L"));
        */
    }

    @Test
    public void DNI_con_formato_inadecuado(){

          //Formatos Inválidos
          DNI dni_invalido1 = new DNI("00000000T");
          DNI dni_invalido2 = new DNI("00000001R");
          DNI dni_invalido3 = new DNI("99999999R");
          assertEquals(false, dni_invalido1.validar());
          assertEquals(false, dni_invalido2.validar());
          assertEquals(false, dni_invalido3.validar());

          //Formatos no adecuados
          DNI dni_formato_err1 = new DNI("1234");
          DNI dni_formato_err2 = new DNI("23LK67998");
          DNI dni_formato_err3 = new DNI("51507247S");
          DNI dni_formato_err4 = new DNI("515072-7*");
          DNI dni_formato_err5 = new DNI("123456789");
          DNI dni_formato_err6 = new DNI("2345678LL");

          assertEquals(false,dni_formato_err1.validar());

        }
}
