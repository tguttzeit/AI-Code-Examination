package ChatGPT.EgyptianFractions.T12;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        List<Long> fractions = new ArrayList<>();
        while (numerator != 0) {
            Long ceil = (long) Math.ceil((double) denominator / numerator);
            fractions.add(ceil);
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;

            // Reduce the fraction
            Long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return fractions;
    }

    // Calculate the greatest common divisor using Euclidean algorithm
    private Long gcd(Long a, Long b) {
        while (b != 0) {
            Long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
