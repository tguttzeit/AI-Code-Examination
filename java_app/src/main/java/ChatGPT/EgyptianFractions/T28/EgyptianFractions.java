package ChatGPT.EgyptianFractions.T28;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        List<Long> result = new ArrayList<>();
        while (numerator > 0) {
            long unitFractionDenominator = (denominator + numerator - 1) / numerator; // Ceiling division
            result.add(unitFractionDenominator);
            numerator = numerator * unitFractionDenominator - denominator;
            denominator = denominator * unitFractionDenominator;
        }

        return result;
    }
}
