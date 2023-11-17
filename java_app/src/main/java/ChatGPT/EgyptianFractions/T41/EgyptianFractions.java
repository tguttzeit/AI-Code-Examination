package ChatGPT.EgyptianFractions.T41;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();

        if (numerator == 0 || denominator == 0) {
            throw new IllegalArgumentException("Numerator and denominator must be non-zero.");
        }

        while (numerator != 0) {
            long ceil = (denominator + numerator - 1) / numerator;
            fractions.add(ceil);
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;

            // Simplify the fraction by finding the greatest common divisor
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return fractions;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
