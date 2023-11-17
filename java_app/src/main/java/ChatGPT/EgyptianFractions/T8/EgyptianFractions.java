package ChatGPT.EgyptianFractions.T8;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();

        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive");
        }

        while (numerator != 0) {
            // Calculate the ceiling of the division
            long ceil = (long) Math.ceil((double) denominator / numerator);

            // Add the reciprocal of the ceiling to the list
            fractions.add(ceil);

            // Update the numerator and denominator
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;
        }

        return fractions;
    }
}
