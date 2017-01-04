package org.proundmega.mathlib.operaciones;

public class Multiplicacion extends AbstractOperacion{

    public Multiplicacion(String operacion) {
        super(operacion);
    }
    
    @Override
    protected String getRegexOperacion() {
        return "\\*";
    }

    @Override
    protected double acumular(String operacion, double suma) {
        return suma *= new Suma(operacion).operar();
    }

    @Override
    protected double manejarPrimerValor(String primerValor) {
        return new Suma(primerValor).operar();
    }
}
