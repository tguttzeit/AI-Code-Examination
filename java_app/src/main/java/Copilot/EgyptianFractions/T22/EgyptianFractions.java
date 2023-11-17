package Copilot.EgyptianFractions.T22;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();
        if (numerator == 0 || denominator == 0) {
            return result;
        }
        Long quotient = denominator / numerator;
        Long remainder = denominator % numerator;
        result.add(quotient);
        if (remainder == 0) {
            return result;
        }
        List<Long> next = build(remainder, denominator * quotient);
        for (Long item : next) {
            result.add(item);
        }
        return result;
    }
}
