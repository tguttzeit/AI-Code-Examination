package Copilot.EgyptianFractions.T37;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();
        if (numerator == 0 || denominator == 0) {
            return result;
        }
        Long ceil = denominator / numerator + 1;
        result.add(ceil);
        Long newNumerator = numerator * ceil - denominator;
        Long newDenominator = denominator * ceil;
        List<Long> next = build(newNumerator, newDenominator);
        result.addAll(next);
        return result;
    }
}
