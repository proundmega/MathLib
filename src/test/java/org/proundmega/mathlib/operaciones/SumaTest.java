package org.proundmega.mathlib.operaciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class SumaTest {
    
    @Test
    public void sumar2Numeros() {
        String operacion = "1+1";
        Suma suma = new Suma(operacion);
        
        double resultado = 2;
        double obtenido = suma.operar();
        assertEquals(resultado, obtenido, 0.01);
    }
    
    @Test
    public void sumar5Numeros() {
        String operacion = "1+2+3+4+5";
        Suma suma = new Suma(operacion);
        
        double resultado = 15;
        double obtenido = suma.operar();
        assertEquals(resultado, obtenido, 0.01);
    }
    
    @Test
    public void sumar2NumerosConSignoPositivoAlInicio() {
        String operacion = "+3+5";
        Suma suma = new Suma(operacion);
        
        double resultado = 8;
        double obtenido = suma.operar();
        assertEquals(resultado, obtenido, 0.01);
    }
    
    @Test
    public void unSoloValor() {
        String formula = "2";

        Suma suma = new Suma(formula);
        double esperado = 2;
        double obtenido = suma.operar();
        
        assertEquals(esperado, obtenido, 0.01);
    }
}
