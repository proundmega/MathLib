package org.proundmega.mathlib.operaciones;

public class Fragmento {
    private final Formula formulaEnBloque;
    private final int inicio;
    private final int fin;

    public Fragmento(String formula, int inicio, int fin) {
        this.formulaEnBloque = new Formula(formula);
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public Fragmento reemplazarFormulaPorValor(double respuesta) {
        return new Fragmento(String.valueOf(respuesta), inicio, fin);
    }

    public Formula getFormulaEnBloque() {
        return formulaEnBloque;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }

}
