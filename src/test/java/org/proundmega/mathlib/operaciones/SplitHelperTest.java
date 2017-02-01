package org.proundmega.mathlib.operaciones;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class SplitHelperTest {
    
    @Test
    public void siTieneOperandoAlFinal() {
        String formula = "3*";
        SplitHelper helper = new SplitHelper(formula);
        
        assertTrue(helper.contieneOperandosAlFinal());
    }
    
    @Test
    public void noTieneOperandoAlFinal() {
        String formula = "9*4";
        SplitHelper helper = new SplitHelper(formula);
        
        assertFalse(helper.contieneOperandosAlFinal());
    }
    
    @Test
    public void siContieneParentesisCorrectamente() {
        String formula = "(2+3)";
        SplitHelper helper = new SplitHelper(formula);
        
        assertTrue(helper.hayParentesisCompletados());
    }
    
    @Test
    public void siContieneParentesisCorrectamente2() {
        String formula = "(5*((2-3)*5)/10)";
        SplitHelper helper = new SplitHelper(formula);
        
        assertTrue(helper.hayParentesisCompletados());
    }
    
    @Test
    public void noContieneParentesisCorrectamente() {
        String formula = "((2+3)";
        SplitHelper helper = new SplitHelper(formula);
        
        assertFalse(helper.hayParentesisCompletados());
    }
    
     @Test
    public void noContieneParentesisCorrectamente2() {
        String formula = "(((((3*(2-6))+2))";
        SplitHelper helper = new SplitHelper(formula);
        
        assertFalse(helper.hayParentesisCompletados());
    }
}
