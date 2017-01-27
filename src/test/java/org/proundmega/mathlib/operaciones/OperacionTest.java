package org.proundmega.mathlib.operaciones;

import org.proundmega.mathlib.operaciones.Operacion;
import org.junit.Test;
import static org.junit.Assert.*;

public class OperacionTest {
    
    @Test
    public void sumar2Numeros() {
        String prueba = "2+5";
        double respuesta = 7.0;
        
        Operacion operacion = new Operacion(prueba);
        assertEquals(respuesta, operacion.getResultado(), 0.001);
    }
    
    @Test
    public void sumarVariosNumeros() {
        String prueba = "10-9+7-5.2";
        double respuesta = 2.8;
        
        Operacion operacion = new Operacion(prueba);
        assertEquals(respuesta, operacion.getResultado(), 0.001);
    }
}
