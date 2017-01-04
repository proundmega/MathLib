package org.proundmega.mathlib.operaciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplicacionTest {
    
    @Test
    public void multiplicar2valores() {
        String formula = "2*3";
        Multiplicacion multiplicacion = new Multiplicacion(formula);
        
        double esperado = 6.0;
        double obtenido = multiplicacion.operar();
        
        assertEquals(esperado, obtenido, 0.01);
    }
    
    @Test
    public void multiplicar4valores() {
        String formula = "2*3*4*5";
        Multiplicacion multiplicacion = new Multiplicacion(formula);
        
        double esperado = 120.0;
        double obtenido = multiplicacion.operar();
        
        assertEquals(esperado, obtenido, 0.01);
    }
    
    @Test
    public void multiplicar4valoresConVariosSignos() {
        String formula = "+2*-3*+4*-5";
        Multiplicacion multiplicacion = new Multiplicacion(formula);
        
        double esperado = 120.0;
        double obtenido = multiplicacion.operar();
        
        assertEquals(esperado, obtenido, 0.01);
    }
}
