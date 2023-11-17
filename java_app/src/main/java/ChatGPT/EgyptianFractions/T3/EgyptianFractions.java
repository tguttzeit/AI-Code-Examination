package ChatGPT.EgyptianFractions.T3;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();

        if (numerator == 0 || denominator == 0) {
            throw new IllegalArgumentException("Numerator and denominator must be non-zero.");
        }

        while (numerator != 0) {
            long ceilValue = (denominator + numerator - 1) / numerator;
            fractions.add(ceilValue);
            numerator = numerator * ceilValue - denominator;
            denominator = denominator * ceilValue;
        }

        return fractions;
    }
}
