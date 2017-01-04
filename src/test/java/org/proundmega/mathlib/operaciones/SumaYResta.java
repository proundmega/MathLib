package org.proundmega.mathlib.operaciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class SumaYResta {
    
    @Test
    public void sumarYRestarJunto() {
        String formula = "3+4+5-5";
        
        Suma suma = new Suma(formula);
        double esperado = 7;
        double obtenido = suma.operar();
        
        assertEquals(esperado, obtenido, 0.01);
    }
    
    @Test
    public void sumarYRestarJuntoExtenso() {
        String formula = "+9+10-40-15+2.0-1.5";
        
        Suma suma = new Suma(formula);
        double esperado = -35.5;
        double obtenido = suma.operar();
        
        assertEquals(esperado, obtenido, 0.01);
    }
}
