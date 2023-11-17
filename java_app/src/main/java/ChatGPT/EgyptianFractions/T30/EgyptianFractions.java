package ChatGPT.EgyptianFractions.T30;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();

        if (numerator == 0 || denominator == 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be non-zero.");
        }

        while (numerator != 0) {
            // Calculate the next unit fraction
            long unitDenominator = (denominator + numerator - 1) / numerator;

            // Add the unit fraction to the result
            result.add(unitDenominator);

            // Update numerator and denominator for the next iteration
            numerator = numerator * unitDenominator - denominator;
            denominator = denominator * unitDenominator;
        }

        return result;
    }
}
