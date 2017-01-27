package org.proundmega.mathlib.operaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiplicacionDivision {
    private String formula;
    
    private static final Pattern pattern = Pattern.compile("\\*|/");

    public MultiplicacionDivision(String formula) {
        this.formula = formula;
    }
    
    public double operar() {
        Matcher matcher = pattern.matcher(formula);
        String[] valores = pattern.split(formula);
        
        double suma = Double.parseDouble(valores[0]);
        int actual = 1;
        
        while (matcher.find()) {
            String operando = matcher.group();
            double valorActual = Double.parseDouble(valores[actual]);
            
            suma = operando.equals("*") ? suma * valorActual : suma / valorActual;
            actual++;
        }
        
        return suma;
    }
    
}
