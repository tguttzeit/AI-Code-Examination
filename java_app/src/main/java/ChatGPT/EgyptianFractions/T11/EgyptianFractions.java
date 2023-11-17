package ChatGPT.EgyptianFractions.T11;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();

        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Numerator and denominator must be positive.");
        }

        while (numerator != 0) {
            Long fraction = (denominator + numerator - 1) / denominator;
            fractions.add(fraction);
            numerator = numerator * fraction - denominator;
            denominator = denominator * fraction;
        }

        return fractions;
    }
}
