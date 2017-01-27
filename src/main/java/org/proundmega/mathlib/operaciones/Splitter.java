package org.proundmega.mathlib.operaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Esta clase hace el split de la cadena enviada y la separa en pequeñas cadenas
 *  operables. La idea es trabajar cada elemento por separado y no junto.
 * 
 *  Por el momento se asume que se han compactado los signos y que el input es valido
 * 
 * @author proundmega
 */
public class Splitter {
    private String formula;
    
    private static final Pattern pattern = Pattern.compile("\\+|-");
    
    public Splitter(String formula) {
        this.formula = formula;
    }
    
    public List<String> getSplits() {
        List<String> lista = splitPorCadaSigno();
        removerCadenasVacias(lista);
        juntarOperandosSeparados(lista);
        
        return lista;
    }

    private List<String> splitPorCadaSigno() {
        List<String> lista = new ArrayList<>();
        Matcher matcher = pattern.matcher(formula);
        
        int actual = 0;
        while(matcher.find()) {
            int start = matcher.start();
            lista.add(formula.substring(actual, start));
            actual = start;
        }
        
        lista.add(formula.substring(actual));
        return lista;
    }
    
    private void juntarOperandosSeparados(List<String> lista) {
        for(int i = 0; i < lista.size(); i++) {
            String actual = lista.get(i);
            if(contieneOperandosAlFinal(actual)) {
                String valorPrevio = lista.get(i + 1);
                
                lista.remove(i + 1);
                lista.remove(i);
                
                lista.add(i, actual + valorPrevio);
                
                // Es para revisar el mismo valor y ver que no haya mas cadenas
                i--;
            }
        }
    }

    private static boolean contieneOperandosAlFinal(String actual) {
        String ultimoCaracter = actual.length() < 1 ? actual : actual.substring(actual.length() - 1);
        return ultimoCaracter.equals("*") || ultimoCaracter.equals("/");
    }
    
    private void removerCadenasVacias(List<String> lista) {
        lista.removeIf(cadena -> cadena.isEmpty());
    }
}
