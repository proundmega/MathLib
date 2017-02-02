package org.proundmega.mathlib.operaciones;

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
    
    @Test
    public void sumar2Multiplicaciones() {
        String prueba = "3.2*4.9+1.1*6.9";
        double respuesta = 23.27;
        
        Operacion operacion = new Operacion(prueba);
        assertEquals(respuesta, operacion.getResultado(), 0.001);
    }
    
    @Test
    public void juntandoSumasRestasMultiplicacionesYDivisiones1() {
        String prueba = "1+2*3.19-7/-3.09+14.298*877-2+381";
        double respuesta = 12927.99137;
        
        Operacion operacion = new Operacion(prueba);
        assertEquals(respuesta, operacion.getResultado(), 0.001);
    }
    
    @Test
    public void juntandoSumasRestasMultiplicacionesYDivisiones2() {
        String prueba = "-2*4*-1/729+431.9876621/+09/-1.012*139.24";
        double respuesta = -6604.069183;
        
        Operacion operacion = new Operacion(prueba);
        assertEquals(respuesta, operacion.getResultado(), 0.001);
    }
    
    @Test
    public void operarParentesisSencillo() {
        String formula = "(2+3)";
        double respuesta = 5.0;
        
        Operacion operacion = new Operacion(formula);
        assertEquals(respuesta, operacion.getResultado(), 0.01);
    }
    
    @Test
    public void operarParentesisSencilloConOperandos() {
        String formula = "(5*6-5)+7";
        double respuesta = 32.0;
        
        Operacion operacion = new Operacion(formula);
        assertEquals(respuesta, operacion.getResultado(), 0.01);
    }
    
    @Test
    public void operarParentesisSencilloConOperandos2() {
        String formula = "42*(2/7+6*12-3)*6/2";
        double respuesta = 8730.0;
        
        Operacion operacion = new Operacion(formula);
        assertEquals(respuesta, operacion.getResultado(), 0.01);
    }
    
    @Test
    public void operarParentesisVariosInternos() {
        String formula = "(2*3)+(4-5)";
        double respuesta = 5.0;
        
        Operacion operacion = new Operacion(formula);
        assertEquals(respuesta, operacion.getResultado(), 0.01);
    }
    
    @Test
    public void operarParentesisVariosInternos2() {
        String formula = "4*(32-5)+4-1*(2-1)+2/(4*2)";
        double respuesta = 111.25;
        
        Operacion operacion = new Operacion(formula);
        assertEquals(respuesta, operacion.getResultado(), 0.01);
    }
    
    @Test
    public void operarParentesisAnidados() {
        String formula = "3*((5*3))";
        double respuesta = 45.0;
        
        Operacion operacion = new Operacion(formula);
        assertEquals(respuesta, operacion.getResultado(), 0.01);
    }
    
    @Test
    public void operarParentesisAnidados2() {
        String formula = "2-3*(1-(7+3)*4)/5";
        double respuesta = 25.4;
        
        Operacion operacion = new Operacion(formula);
        assertEquals(respuesta, operacion.getResultado(), 0.01);
    }
    
    @Test
    public void operarParentesisAnidados3() {
        String formula = "(24*(3.5/6-(7/29)+(2-(1)))-9)-9";
        double respuesta = 14.2068;
        
        Operacion operacion = new Operacion(formula);
        assertEquals(respuesta, operacion.getResultado(), 0.01);
    }
    
    @Test
    public void operarParentesisAnidados4() {
        String formula = "3-(3*4-(1-2)-(3-2))+(4-2)";
        double respuesta = -7;
        
        Operacion operacion = new Operacion(formula);
        assertEquals(respuesta, operacion.getResultado(), 0.01);
    }
}
