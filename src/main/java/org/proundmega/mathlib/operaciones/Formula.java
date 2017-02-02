package org.proundmega.mathlib.operaciones;

import java.util.Objects;

public class Formula {
    private String formula;

    public Formula(String formula) {
        this.formula = formula;
    }
    
    public boolean contieneParentesis() {
        return formula.contains("(");
    }

    public String getFormula() {
        return formula;
    }

    public Fragmento getBloqueParentesisMasInterno() {
        int parentesisIzquierdo = getIndiceParentesisIzquierdoMasProfundo();
        int parentesisDerecho = getIndiceParentesisDerechoMasProfundo(parentesisIzquierdo);
        String subFormula = formula.substring(parentesisIzquierdo + 1, parentesisDerecho - 1);
        
        return new Fragmento(subFormula, parentesisIzquierdo, parentesisDerecho);
    }
    
    private int getIndiceParentesisIzquierdoMasProfundo() {
        return formula.lastIndexOf("(");
    }
    
    private int getIndiceParentesisDerechoMasProfundo(int parentesisIzquierdo) {
        return formula.indexOf(")", parentesisIzquierdo) + 1;
    }

    public Formula reemplazarFragmento(Fragmento nuevoFragmento) {
        String bloqueInicio = formula.substring(0, nuevoFragmento.getInicio());
        String bloqueEnMedio = nuevoFragmento.getFormulaEnBloque().getFormula();
        String bloqueFin = formula.substring(nuevoFragmento.getFin());
        
        return new Formula(bloqueInicio + bloqueEnMedio + bloqueFin);
    }
    
    public Formula compactarSignos() {
        return new Formula(formula
            .replace("++", "+")
            .replace("+-", "-")
            .replace("-+", "-")
            .replace("--", "+")
        );
    }

    @Override
    public String toString() {
        return "Formula{" + "formula=" + formula + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.formula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formula other = (Formula) obj;
        if (!Objects.equals(this.formula, other.formula)) {
            return false;
        }
        return true;
    }
    
    
}
