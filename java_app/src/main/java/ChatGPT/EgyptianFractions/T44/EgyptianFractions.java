package ChatGPT.EgyptianFractions.T44;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator >= denominator || numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Invalid input. Numerator must be less than denominator, and both must be positive.");
        }

        List<Long> fractions = new ArrayList<>();

        while (numerator > 0) {
            long nextDenominator = (denominator + numerator - 1) / numerator; // Ceiling division
            fractions.add(nextDenominator);
            numerator = numerator * nextDenominator - denominator;
            denominator = denominator * nextDenominator;
        }

        return fractions;
    }
}
