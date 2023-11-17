package ChatGPT.EgyptianFractions.T46;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        List<Long> fractions = new ArrayList<>();

        while (numerator != 0) {
            long ceilValue = (denominator + numerator - 1) / denominator; // Calculate the ceiling value of numerator/denominator
            fractions.add(ceilValue); // Add the fraction to the list
            numerator = numerator * ceilValue - denominator; // Update the numerator
            denominator = denominator * ceilValue; // Update the denominator
        }

        return fractions;
    }
}
