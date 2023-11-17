package Copilot.EgyptianFractions.T34;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        if (numerator == 0) {
            return result;
        }
        if (numerator > denominator) {
            result.add(numerator/denominator);
            numerator = numerator % denominator;
        }
        Long gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        result.add(denominator);
        result.add(numerator);
        return result;
    }

    private Long gcd(Long a, Long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
