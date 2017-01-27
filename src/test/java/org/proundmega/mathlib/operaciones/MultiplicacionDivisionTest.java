package org.proundmega.mathlib.operaciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplicacionDivisionTest {
    
    @Test
    public void multiplicar2Valores() {
        String prueba = "2*3";
        double esperado = 6.0;
        
        multiplicarYAssert(prueba, esperado);
    }
    
    private void multiplicarYAssert(String prueba, double esperado) {
        MultiplicacionDivision md = new MultiplicacionDivision(prueba);
        double obtenido = md.operar();
        assertEquals(esperado, obtenido, 0.01);
    }
    
    @Test
    public void multiplicar3Valores() {
        String prueba = "2*3*4";
        double esperado = 24.0;
        
        multiplicarYAssert(prueba, esperado);
    }
    
    @Test
    public void multiplicarVariosValoresConSigno() {
        String prueba = "-2*-3*+4*5*-6";
        double esperado = -720.0;
        
        multiplicarYAssert(prueba, esperado);
    }
    
    @Test
    public void dividir2Valores() {
        String prueba = "2/4";
        double esperado = 0.5;
        
        multiplicarYAssert(prueba, esperado);
    }
    
    @Test
    public void dividir3Valores() {
        String prueba = "20/4/5";
        double esperado = 1.0;
        
        multiplicarYAssert(prueba, esperado);
    }
    
    @Test
    public void dividirVariosValoresConSigno() {
        String prueba = "-250/+3/-2.44/+3.16";
        double esperado = 10.80791312;
        
        multiplicarYAssert(prueba, esperado);
    }
    
    @Test
    public void juntarTodo1() {
        String prueba = "2.4*-6.2/41.3*7.14/3.15";
        double esperado = -0.816658595;
        
        multiplicarYAssert(prueba, esperado);
    }
}
