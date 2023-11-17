package Copilot.EgyptianFractions.T9;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        if (numerator == 0) {
            return result;
        }
        if (numerator >= denominator) {
            Long quotient = numerator / denominator;
            result.add(quotient);
            numerator = numerator % denominator;
        }
        Long gcd = getGCD(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        result.add(denominator);
        result.add(numerator);
        return result;
    }

    private Long getGCD(Long a, Long b) {
        if (a == 0) {
            return b;
        }
        return getGCD(b % a, a);
    }
}
