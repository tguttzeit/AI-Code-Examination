package Copilot.EgyptianFractions.T48;

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
        if (remainder == 0) {
            result.add(quotient);
            return result;
        }
        result.add(quotient + 1);
        List<Long> subResult = build(remainder, numerator * (quotient + 1));
        result.addAll(subResult);
        return result;
    }
}
