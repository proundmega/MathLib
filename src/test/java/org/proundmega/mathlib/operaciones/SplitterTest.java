package org.proundmega.mathlib.operaciones;

import org.proundmega.mathlib.operaciones.Splitter;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class SplitterTest {
    
    @Test
    public void splitSencilloDeSuma() {
        List<String> splits = crearListaValores("1+2");
        
        assertEquals(2, splits.size());
        assertEquals("1", splits.get(0));
        assertEquals("+2", splits.get(1));
    }
    
    private List<String> crearListaValores(String prueba) {
        Splitter splitter = new Splitter(prueba);
        return splitter.getSplits();
    }
    
    @Test
    public void splitConVariosValoresSuma() {
        List<String> splits = crearListaValores("2+3+4+5");
        
        assertEquals(4, splits.size());
        assertEquals("2", splits.get(0));
        assertEquals("+3", splits.get(1));
        assertEquals("+4", splits.get(2));
        assertEquals("+5", splits.get(3));
    }
    
    @Test
    public void splitConSignosPositivosYNegativos() {
        List<String> splits = crearListaValores("2x-3y+5z-3m-1");
        
        assertEquals(5, splits.size());
        assertEquals("2x", splits.get(0));
        assertEquals("-3y", splits.get(1));
        assertEquals("+5z", splits.get(2));
        assertEquals("-3m", splits.get(3));
        assertEquals("-1", splits.get(4));
    }
    
    @Test
    public void splitConSignoPositivoAlInicio() {
        List<String> splits = crearListaValores("+10-2");
        
        assertEquals(2, splits.size());
        assertEquals("+10", splits.get(0));
        assertEquals("-2", splits.get(1));
    }
    
    @Test
    public void splitConOperandosMultiplicacionYDivision() {
        List<String> splits = crearListaValores("+2*-3");
        
        assertEquals(1, splits.size());
        assertEquals("+2*-3", splits.get(0));
    }
    
    @Test
    public void splitConOperandosMultiplicacionYDivisionyOtrosOperandos() {
        List<String> splits = crearListaValores("+4*+1-5+2");
        
        assertEquals(3, splits.size());
        assertEquals("+4*+1", splits.get(0));
        assertEquals("-5", splits.get(1));
        assertEquals("+2", splits.get(2));
    }
    
    @Test
    public void splitMultiplesMultiplicacionesYDivisionesEnCadena() {
        List<String> splits = crearListaValores("-2*+5*3/2/-4.2");
        
        assertEquals(1, splits.size());
        assertEquals("-2*+5*3/2/-4.2", splits.get(0));
    }
    
    @Test
    public void splitMultiplesMultiplicacionesYDivisiones() {
        List<String> splits = crearListaValores("2-3*+5-4*2-1/-2*+4");
        
        assertEquals(4, splits.size());
        assertEquals("2", splits.get(0));
        assertEquals("-3*+5", splits.get(1));
        assertEquals("-4*2", splits.get(2));
        assertEquals("-1/-2*+4", splits.get(3));
    }
}
