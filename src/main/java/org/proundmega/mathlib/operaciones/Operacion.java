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
        List<String> valores = splitter.getSplits();
        
        double suma = 0;
        for (String valor : valores) {
            suma += operarElemento(valor);
        }
        return suma;
    }
    
    private double operarElemento(String valor) {
        return Double.parseDouble(valor);
    }
}
