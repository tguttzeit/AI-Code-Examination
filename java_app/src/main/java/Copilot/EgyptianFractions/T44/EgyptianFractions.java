package Copilot.EgyptianFractions.T44;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
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
        Long nextDenominator = denominator / numerator + 1;
        result.add(nextDenominator);
        List<Long> nextResult = build(numerator * nextDenominator - denominator, denominator * nextDenominator);
        result.addAll(nextResult);
        return result;
    }
}
