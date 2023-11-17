package Copilot.EgyptianFractions.T14;

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
        Long next = numerator / denominator + 1;
        result.add(next);
        result.addAll(build(numerator - denominator * next, denominator * next));
        return result;
    }
}
