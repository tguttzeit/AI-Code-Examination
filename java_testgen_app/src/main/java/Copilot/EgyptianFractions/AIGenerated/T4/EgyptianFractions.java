package Copilot.EgyptianFractions.AIGenerated.T4;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("numerator or denominator is not positive");
        }
        if (numerator >= denominator) {
            result.add(numerator / denominator);
            numerator %= denominator;
        }
        while (numerator > 0) {
            long ceil = (denominator + numerator - 1) / numerator;
            result.add(ceil);
            numerator = numerator * ceil - denominator;
            denominator *= ceil;
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        return result;
    }
    private long gcd(long a, long b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
