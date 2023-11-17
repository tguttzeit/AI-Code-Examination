package ChatGPT.EgyptianFractions.AIGenerated.T8;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        List<Long> fractions = new ArrayList<>();

        while (numerator != 0) {
            long ceilValue = (denominator + numerator - 1) / numerator;
            fractions.add(ceilValue);

            numerator = numerator * ceilValue - denominator;
            denominator = denominator * ceilValue;
        }

        return fractions;
    }
}
