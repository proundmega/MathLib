package org.proundmega.mathlib.operaciones;

public class Resta extends AbstractOperacion{

    public Resta(String operacion) {
        super(operacion);
    }

    @Override
    protected String getRegexOperacion() {
        return "-";
    }

    @Override
    protected double acumular(String operacion, double suma) {
        return suma -= Double.parseDouble(operacion);
    }

    @Override
    protected double manejarPrimerValor(String primerValor) {
        if(!primerValor.isEmpty()) {
            return Double.parseDouble(primerValor);
        }
        else {
            return 0;
        }
    }
}
