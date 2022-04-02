package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TelefonoTest {

    @Test
    public void Telefono_con_formato_adecuado(){

        Telefono tlf = new Telefono("696913646");

        boolean result = tlf.validar();
        assertEquals(true,result);
    }

    @Test
        public void Telefono_sin_formato_adecuado(){

            Telefono tlf_invalido1 = new Telefono("6969136");
            Telefono tlf_invalido2 = new Telefono("67649072345");
            Telefono tlf_invalido3 = new Telefono("6969136e6");
            Telefono tlf_invalido4 = new Telefono("6969136##");

            assertEquals(false,tlf_invalido1.validar());
            assertEquals(false,tlf_invalido2.validar());
            assertEquals(false,tlf_invalido3.validar());
            assertEquals(false,tlf_invalido4.validar());


        }
}
