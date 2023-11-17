package ChatGPT.EgyptianFractions.T10;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        List<Long> fractions = new ArrayList<>();

        while (numerator != 0) {
            long ceil = (denominator + numerator - 1) / numerator; // Find the smallest integer greater than or equal to numerator/denominator.
            fractions.add(ceil);

            // Update the numerator and denominator for the next iteration.
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;

            // Simplify the fraction by finding the greatest common divisor (GCD).
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
