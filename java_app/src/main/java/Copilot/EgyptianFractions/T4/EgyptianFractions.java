package Copilot.EgyptianFractions.T4;

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
        if (numerator < denominator) {
            result.add(1L);
            result.addAll(build(denominator, denominator - numerator));
            return result;
        }
        Long quotient = numerator / denominator;
        Long remainder = numerator % denominator;
        result.add(quotient);
        result.addAll(build(remainder, denominator));
        return result;
    }
}
