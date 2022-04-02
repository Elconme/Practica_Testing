package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TelefonoTest {

    @Test
    public void Telefono_con_formato_adecuado(){

        Telefono tlf = new Telefono("696913646");

        boolean result = tlf.validar();
        assertEquals(true,result);

        /*
        // DNI que si cumplen todas las validaciones
            assertTrue(Validaciones.validarDNI("12345678Z"));
            assertTrue(Validaciones.validarDNI("45673254S"));
            assertTrue(Validaciones.validarDNI("72849506L"));
        */
    }

    @Test
        public void Telefono_sin_formato_adecuado(){

            Telefono tlf_invalido = new Telefono("6969136");

            boolean result = tlf_invalido.validar();
            assertEquals(false,result);

            /*
            // DNI que si cumplen todas las validaciones
                assertTrue(Validaciones.validarDNI("12345678Z"));
                assertTrue(Validaciones.validarDNI("45673254S"));
                assertTrue(Validaciones.validarDNI("72849506L"));
            */
        }
}
