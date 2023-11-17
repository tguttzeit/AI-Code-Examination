package ChatGPT.EgyptianFractions.T43;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();

        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        while (numerator != 0) {
            long ceil = (denominator + numerator - 1) / numerator; // Calculate the ceiling value
            fractions.add(ceil);
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;
        }

        return fractions;
    }
}

