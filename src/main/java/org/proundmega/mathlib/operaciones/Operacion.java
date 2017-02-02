package org.proundmega.mathlib.operaciones;

import java.util.List;

/** Esta clase se encarga de tomar un String y operarlo.
 *  Actualmente tiene soporte completo para multiplicaciones y divisiones, asi como
 *  operaciones con parentesis sin problemas.
 * 
 *  Ademas las operaciones deben tener la semantica apropiada, es decir que por el momento
 *  no se validan los inputs erroneos como por ejemplo operandos incompletos y cosas asi.
 * 
 *  Las formulas son como las que se encuentran en matematicas, tipo:
 * 
 *  2*3-9+(4/7)
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
            valor = valor.compactarSignos();
        }
        
        valor = valor.compactarSignos();
        return new MultiplicacionDivision(valor.getFormula()).operar();
    }
    
}
