package Copilot.EgyptianFractions.T18;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();
        if (numerator == 0) return result;
        if (numerator % denominator == 0) {
            result.add(numerator / denominator);
            return result;
        }
        if (numerator > denominator) {
            Long integer = numerator / denominator;
            result.add(integer);
            numerator -= integer * denominator;
        }
        Long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        result.add(denominator);
        result.add(numerator);
        return result;
    }

    private Long gcd(Long a, Long b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }
}
