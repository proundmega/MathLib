package org.proundmega.mathlib.operaciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class RestaTest {
    
    @Test
    public void restar2Numeros() {
        String operacion = "3-2";
        Resta resta = new Resta(operacion);
        
        double esperado = 1;
        double obtenido = resta.operar();
        
        assertEquals(esperado, obtenido, 0.01);
    }
    
    @Test
    public void restar3Numeros() {
        String operacion = "5-3-2";
        Resta resta = new Resta(operacion);
        
        double esperado = 0;
        double obtenido = resta.operar();
        
        assertEquals(esperado, obtenido, 0.01);
    }
    
    @Test
    public void restar2NumerosConPrimeroNegativo() {
        String operacion = "-5-3";
        Resta resta = new Resta(operacion);
        
        double esperado = -8;
        double obtenido = resta.operar();
        
        assertEquals(esperado, obtenido, 0.01);
    }
}
