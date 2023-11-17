package Copilot.EgyptianFractions.T6;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();
        if (numerator == 0 || denominator == 0) {
            return result;
        }
        if (numerator % denominator == 0) {
            result.add(numerator / denominator);
            return result;
        }
        if (numerator > denominator) {
            result.add(numerator / denominator);
            numerator = numerator % denominator;
        }
        Long newNumerator = numerator;
        Long newDenominator = denominator;
        while (newNumerator != 1) {
            if (newDenominator % newNumerator == 0) {
                result.add(newDenominator / newNumerator);
                break;
            } else {
                Long temp = newDenominator / newNumerator + 1;
                result.add(temp);
                newNumerator = newNumerator * temp - newDenominator;
                newDenominator = newDenominator * temp;
            }
        }
        return result;
    }
}
