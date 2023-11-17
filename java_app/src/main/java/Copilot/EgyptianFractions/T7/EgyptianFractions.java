package Copilot.EgyptianFractions.T7;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        if (denominator == 0 || numerator == 0) {
            return result;
        }
        if (denominator % numerator == 0) {
            result.add(denominator / numerator);
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
        Long num = numerator;
        Long den = denominator;
        while (num != 1) {
            Long x = den / num + 1;
            result.add(x);
            num = num * x - den;
            den = den * x;
        }
        result.add(den);
        return result;
    }
}
