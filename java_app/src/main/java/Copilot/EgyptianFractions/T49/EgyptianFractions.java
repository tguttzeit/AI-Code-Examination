package Copilot.EgyptianFractions.T49;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        if (numerator % denominator == 0) {
            result.add(numerator / denominator);
            return result;
        }
        if (denominator % numerator == 0) {
            result.add(1L);
            result.add(denominator / numerator);
            return result;
        }
        Long n = denominator / numerator + 1;
        result.add(n);
        List<Long> r = build(numerator * n - denominator, denominator * n);
        result.addAll(r);
        return result;
    }
}
