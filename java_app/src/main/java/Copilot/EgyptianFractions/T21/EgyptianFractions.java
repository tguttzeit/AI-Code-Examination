package Copilot.EgyptianFractions.T21;

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
        if (denominator % numerator == 0) {
            result.add(1L);
            result.add(denominator / numerator);
            return result;
        }
        if (numerator > denominator) {
            result.add(numerator / denominator);
            result.addAll(build(numerator % denominator, denominator));
            return result;
        }
        long nextDenominator = denominator / numerator + 1;
        result.add(1L);
        result.addAll(build(numerator * nextDenominator - denominator, denominator * nextDenominator));
        return result;
    }
}
