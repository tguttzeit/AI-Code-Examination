package Copilot.EgyptianFractions.T40;

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
        Long divisor = denominator / numerator + 1;
        result.add(divisor);
        List<Long> next = build(numerator * divisor - denominator, denominator * divisor);
        result.addAll(next);
        return result;
    }
}
