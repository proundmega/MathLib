package org.proundmega.mathlib.operaciones;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class FormulaTest {
    
    @Test
    public void obtenerParentesisMasInterno() {
        Formula formula = new Formula("(7-2)/2");
        Fragmento fragmento = formula.getBloqueParentesisMasInterno();
        
        assertEquals(0, fragmento.getInicio());
        assertEquals(5, fragmento.getFin());
        assertEquals(new Formula("7-2"), fragmento.getFormulaEnBloque());
    }
    
    @Test
    public void obtenerParentesisMasInternoEnMedio() {
        Formula formula = new Formula("2+(7*4)-5");
        Fragmento fragmento = formula.getBloqueParentesisMasInterno();
        
        assertEquals(2, fragmento.getInicio());
        assertEquals(7, fragmento.getFin());
        assertEquals(new Formula("7*4"), fragmento.getFormulaEnBloque());
    }
    
    @Test
    public void obtenerParentesisMasInternoAlFinal() {
        Formula formula = new Formula("3*4-(2-3-4)");
        Fragmento fragmento = formula.getBloqueParentesisMasInterno();
        
        assertEquals(4, fragmento.getInicio());
        assertEquals(11, fragmento.getFin());
        assertEquals(new Formula("2-3-4"), fragmento.getFormulaEnBloque());
    }
    
    @Test
    public void reemplazarUnFragmento() {
        Formula formula = new Formula("2+3-5");
        Formula esperada = new Formula("2+2-3");
        
        Fragmento reemplazo = new Fragmento("2-3", 2, 5);
        
        Formula obtenida = formula.reemplazarFragmento(reemplazo);
        assertEquals(esperada, obtenida);
    }
    
    @Test
    public void reemplazarUnFragmento2() {
        Formula formula = new Formula("2*4-7/452");
        Formula esperada = new Formula("8.0-7/452");
        
        Fragmento reemplazo = new Fragmento("8.0", 0, 3);
        
        Formula obtenida = formula.reemplazarFragmento(reemplazo);
        assertEquals(esperada, obtenida);
    }
    
    @Test
    public void reemplazarFragmentoConParentesis() {
        Formula original = new Formula("(2+3)*5");
        Formula esperada = new Formula("5.0*5");
        
        Fragmento fragmentoOriginal = original.getBloqueParentesisMasInterno();
        // se opera y se crea otro fragmento
        Fragmento nuevoFragmento = fragmentoOriginal.reemplazarFormulaPorValor(5.0);
        
        Formula obtenido = original.reemplazarFragmento(nuevoFragmento);
        assertEquals(esperada, obtenido);
    }
}
