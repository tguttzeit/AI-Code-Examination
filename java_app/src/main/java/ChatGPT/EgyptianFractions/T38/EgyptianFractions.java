package ChatGPT.EgyptianFractions.T38;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Numerator and denominator must be positive.");
        }

        List<Long> fractions = new ArrayList<>();
        while (numerator != 0) {
            // Calculate the next unit fraction (1/x)
            long x = (denominator + numerator - 1) / numerator;

            // Add it to the list
            fractions.add(x);

            // Update numerator and denominator for the next iteration
            numerator = numerator * x - denominator;
            denominator = denominator * x;
        }

        return fractions;
    }
}
