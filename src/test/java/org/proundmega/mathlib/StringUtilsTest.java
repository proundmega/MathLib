package org.proundmega.mathlib;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {
    private volatile int contador;
    private volatile String[] testArray;
    
    
    @Test
    public void testPerformance() {
        String formula = "3x+2y+9+5";
        TestClass test = (() -> {
            testArray = formula.split("\\+");
        });
        testPerformance(test, "Split de la formula: " + formula);
    }
    
    private void testPerformance(TestClass testClass, String mensaje) {
        System.out.println("Test de: " + mensaje);
        // Warm-up
        exec1000Veces(testClass);
        
        // medida de performance
        long inicio = System.nanoTime();
        
        exec1000Veces(testClass);
        
        long fin = System.nanoTime();
        long tiempo = fin - inicio;
        
        System.out.println("Tiempo: " + tiempo);
    }
    
    private void exec1000Veces(TestClass testClass) {
        for(contador = 0; contador < 1000; contador++) {
            testClass.exec();
        }
        contador = 0;
    }
    
    private interface TestClass {
        void exec();
    }
}
