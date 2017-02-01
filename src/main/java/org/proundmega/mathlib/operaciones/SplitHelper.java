package org.proundmega.mathlib.operaciones;

public class SplitHelper {
    private final String fragmentoFormula;
    
    public SplitHelper(String fragmentoFormula) {
        this.fragmentoFormula = fragmentoFormula;
    }
    
    public SplitHelper(SplitHelper inicio, SplitHelper fin) {
        this.fragmentoFormula = inicio.getFragmentoFormula() + fin.getFragmentoFormula();
    }

    public String getFragmentoFormula() {
        return fragmentoFormula;
    }

    public boolean contieneOperandosAlFinal() {
        String ultimoCaracter = fragmentoFormula.length() < 1 ? fragmentoFormula : fragmentoFormula.substring(fragmentoFormula.length() - 1);
        return ultimoCaracter.equals("*") || ultimoCaracter.equals("/");
    }

    public boolean hayParentesisCompletados() {
        return getConteoParentesisIzquierdo() == getConteoParentesisDerecho();
    }
    
    private int getConteoParentesisIzquierdo() {
        return (int) fragmentoFormula
                .chars()
                .filter(caracter -> caracter == '(')
                .count();
    }
    
    private int getConteoParentesisDerecho() {
        return (int) fragmentoFormula
                .chars()
                .filter(caracter -> caracter == ')')
                .count();
    }
}
