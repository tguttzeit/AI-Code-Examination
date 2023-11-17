package Copilot.EgyptianFractions.T13;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();
        if (numerator > denominator) {
            result.add(numerator / denominator);
            numerator %= denominator;
        }
        if (numerator == 0) {
            return result;
        }
        Long nextDenominator = denominator / numerator + 1;
        result.add(nextDenominator);
        List<Long> nextResult = build(numerator * nextDenominator - denominator, denominator * nextDenominator);
        result.addAll(nextResult);
        return result;
    }
}
