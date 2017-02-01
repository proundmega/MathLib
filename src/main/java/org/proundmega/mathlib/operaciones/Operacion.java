package org.proundmega.mathlib.operaciones;

import java.util.List;

/** Esta clase se encarga de tomar un String y operarlo
 *
 * @author proundmega
 */
public class Operacion {
    private String operacion;

    public Operacion(String operacion) {
        this.operacion = operacion;
    }
    
    public double getResultado() {
        Splitter splitter = new Splitter(operacion);
        List<Formula> valores = splitter.getSplits();
        
        double suma = 0;
        for (Formula valor : valores) {
            suma += operarElemento(valor);
        }
        return suma;
    }
    
    private double operarElemento(Formula valor) {
        while (valor.contieneParentesis()) {
            Fragmento fragmentoParentesis = valor.getBloqueParentesisMasInterno();
            double resultadoInterno = new Operacion(fragmentoParentesis.getFormulaEnBloque().getFormula()).getResultado();
            Fragmento fragmentoRespuesta = fragmentoParentesis.reemplazarFormulaPorValor(resultadoInterno);
            
            valor = valor.reemplazarFragmento(fragmentoRespuesta);
        }
        
        valor = valor.compactarSignos();
        return new MultiplicacionDivision(valor.getFormula()).operar();
    }
    
}
