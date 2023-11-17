package ChatGPT.EgyptianFractions.T17;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();

        if (numerator == 0 || denominator == 0) {
            throw new IllegalArgumentException("Numerator and denominator must be non-zero.");
        }

        while (numerator != 0) {
            // Calculate the next fraction
            Long fraction = (denominator + numerator - 1) / numerator;

            // Add it to the list of fractions
            fractions.add(fraction);

            // Update numerator and denominator for the next iteration
            numerator = numerator * fraction - denominator;
            denominator = denominator * fraction;

            // Simplify the fraction
            Long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return fractions;
    }

    private Long gcd(Long a, Long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
