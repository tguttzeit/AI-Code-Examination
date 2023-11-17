package ChatGPT.EgyptianFractions.T24;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Numerator and denominator must be positive integers.");
        }

        List<Long> fractions = new ArrayList<>();
        while (numerator > 0) {
            Long ceilValue = (long) Math.ceil((double) denominator / numerator);
            fractions.add(ceilValue);
            numerator = numerator * ceilValue - denominator;
            denominator = denominator * ceilValue;

            // Simplify the fraction
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return fractions;
    }

    // Helper method to calculate the greatest common divisor (GCD) of two numbers.
    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
