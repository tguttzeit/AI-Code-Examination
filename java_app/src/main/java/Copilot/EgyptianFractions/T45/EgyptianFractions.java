package Copilot.EgyptianFractions.T45;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();
        if (denominator % numerator == 0) {
            result.add(1L);
            return result;
        }
        Long ceil = denominator / numerator + 1;
        result.add(ceil);
        List<Long> subResult = build(numerator * ceil - denominator, denominator * ceil);
        result.addAll(subResult);
        return result;
    }
}
