package ChatGPT.EgyptianFractions.T9;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive");
        }

        List<Long> fractions = new ArrayList<>();

        while (numerator > 0) {
            // Find the smallest unit fraction that is less than or equal to numerator/denominator
            Long unitDenominator = (denominator + numerator - 1) / numerator;

            // Add this unit fraction to the list
            fractions.add(unitDenominator);

            // Update numerator and denominator for the next iteration
            numerator = numerator * unitDenominator - denominator;
            denominator = denominator * unitDenominator;
        }

        return fractions;
    }
}
