package ChatGPT.EgyptianFractions.T29;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        List<Long> fractions = new ArrayList<>();

        while (numerator != 0) {
            long ceil = (denominator + numerator - 1) / numerator; // Calculate the ceiling value of denominator/numerator
            fractions.add(ceil); // Add the ceil value to the list
            numerator = numerator * ceil - denominator; // Update numerator and denominator
            denominator = denominator * ceil;
        }

        return fractions;
    }
}
