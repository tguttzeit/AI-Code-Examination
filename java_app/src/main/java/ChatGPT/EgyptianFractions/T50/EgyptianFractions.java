package ChatGPT.EgyptianFractions.T50;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();

        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        while (numerator != 0) {
            // Calculate the ceiling of the fraction 1 / (denominator / numerator)
            long ceilValue = (denominator + numerator - 1) / numerator;

            // Add 1 / ceilValue to the result
            result.add(ceilValue);

            // Update the numerator and denominator
            numerator = numerator * ceilValue - denominator;
            denominator = denominator * ceilValue;
        }

        return result;
    }
}
