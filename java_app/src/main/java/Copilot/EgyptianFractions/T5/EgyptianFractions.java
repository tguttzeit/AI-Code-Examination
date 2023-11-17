package Copilot.EgyptianFractions.T5;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator){
        List<Long> list = new ArrayList<Long>();
        if (numerator == 0 || denominator == 0){
            return list;
        }
        else{
            if (numerator % denominator == 0){
                list.add(numerator/denominator);
                return list;
            }
            else{
                if (numerator > denominator){
                    list.add(numerator/denominator);
                    numerator = numerator % denominator;
                    list.addAll(build(numerator, denominator));
                    return list;
                }
                else{
                    Long newNumerator = denominator % numerator;
                    Long newDenominator = denominator;
                    list.add(newDenominator / newNumerator + 1);
                    list.addAll(build(numerator, newDenominator / newNumerator + 1));
                    return list;
                }
            }
        }
    }
}
