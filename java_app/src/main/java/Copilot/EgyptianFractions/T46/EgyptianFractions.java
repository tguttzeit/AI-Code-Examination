package Copilot.EgyptianFractions.T46;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        while (numerator != 0) {
            Long x = (denominator + numerator - 1) / numerator;
            result.add(x);
            numerator = numerator * x - denominator;
            denominator = denominator * x;
        }
        return result;
    }
}
