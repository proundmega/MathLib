package org.proundmega.mathlib.operaciones;

import java.util.Objects;

public abstract class AbstractOperacion implements Operacion{
    protected String operacion;

    public AbstractOperacion(String operacion) {
        Objects.requireNonNull(operacion, "La operacion a realizar no debe ser nula");
        this.operacion = operacion;
    }
    
    @Override
    public double operar() {
        double suma = 0;
        String regex = getRegexOperacion();
        String[] valores = operacion.split(regex);
        
        suma = manejarPrimerValor(valores[0]);
        
        for(int i = 1; i < valores.length; i++) {
            String valor = valores[i];
            suma = acumular(valor, suma);
        }
        
        return suma;
    }
    
    protected abstract String getRegexOperacion();
    
    protected abstract double manejarPrimerValor(String primerValor);
    
    protected abstract double acumular(String operacion, double suma);
}
