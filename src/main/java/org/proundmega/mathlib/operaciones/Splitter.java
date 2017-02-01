package org.proundmega.mathlib.operaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
    
    public List<Formula> getSplits() {
        List<SplitHelper> lista = splitPorCadaSigno();
        removerCadenasVacias(lista);
        juntarOperandosSeparados(lista);
        juntarParentesisSeparados(lista);
        
        return lista.stream()
                .map(helper -> new Formula(helper.getFragmentoFormula()))
                .collect(Collectors.toList());
    }

    private List<SplitHelper> splitPorCadaSigno() {
        List<SplitHelper> lista = new ArrayList<>();
        Matcher matcher = pattern.matcher(formula);
        
        int actual = 0;
        while(matcher.find()) {
            int start = matcher.start();
            lista.add(new SplitHelper(formula.substring(actual, start)));
            actual = start;
        }
        
        lista.add(new SplitHelper(formula.substring(actual)));
        return lista;
    }
    
    private void removerCadenasVacias(List<SplitHelper> lista) {
        lista.removeIf(cadena -> cadena.getFragmentoFormula().isEmpty());
    }
    
    private void juntarOperandosSeparados(List<SplitHelper> lista) {
        juntarSi(actual -> actual.contieneOperandosAlFinal(), lista);
    }
    
    private void juntarSi(Predicate<SplitHelper> predicado, List<SplitHelper> lista) {
        for(int i = 0; i < lista.size() - 1; i++) {
            SplitHelper actual = lista.get(i);
            
            if(predicado.test(actual)) {
                SplitHelper valorPrevio = lista.get(i + 1);
                
                lista.remove(i + 1);
                lista.remove(i);
                
                lista.add(i, new SplitHelper(actual, valorPrevio));
                
                // Es para revisar el mismo valor y ver que no haya mas cadenas
                i--;
            }
        }
    }

    private void juntarParentesisSeparados(List<SplitHelper> lista) {
        juntarSi(actual -> !actual.hayParentesisCompletados(), lista);
    }
    
}
