package ChatGPT.EgyptianFractions.T26;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();

        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        while (numerator != 0) {
            Long ceilValue = (long) Math.ceil((double) denominator / numerator);
            result.add(ceilValue);
            numerator = numerator * ceilValue - denominator;
            denominator = denominator * ceilValue;

            // Simplify the fraction if necessary
            Long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return result;
    }

    // Helper method to calculate the greatest common divisor (GCD)
    private Long gcd(Long a, Long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
