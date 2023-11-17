package ChatGPT.EgyptianFractions.T40;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        List<Long> fractions = new ArrayList<>();

        while (numerator != 0) {
            long ceil = (denominator + numerator - 1) / numerator; // Calculate the smallest integer greater than or equal to numerator/denominator
            fractions.add(ceil);

            // Update numerator and denominator
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;
        }

        return fractions;
    }
}

