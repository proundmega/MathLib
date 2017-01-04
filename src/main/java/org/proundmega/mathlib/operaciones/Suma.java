package org.proundmega.mathlib.operaciones;

public class Suma extends AbstractOperacion{

    public Suma(String operacion) {
        super(operacion);
    }

    @Override
    protected String getRegexOperacion() {
        return "\\+";
    }

    @Override
    protected double acumular(String operacion, double suma) {
        return suma += new Resta(operacion).operar();
    }

    @Override
    protected double manejarPrimerValor(String primerValor) {
        if(!primerValor.isEmpty()) {
            return new Resta(primerValor).operar();
        }
        else {
            return 0;
        }
    }
    
}
