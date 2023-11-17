package ChatGPT.EgyptianFractions.T42;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator should be positive");
        }

        List<Long> fractions = new ArrayList<>();
        while (numerator > 0) {
            long ceil = (denominator + numerator - 1) / numerator; // Calculate the ceiling value
            fractions.add(ceil);
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;

            // Simplify the fraction
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return fractions;
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
