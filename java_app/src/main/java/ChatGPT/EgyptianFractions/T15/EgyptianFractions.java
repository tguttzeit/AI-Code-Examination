package ChatGPT.EgyptianFractions.T15;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();

        if (numerator == 0 || denominator == 0) {
            throw new IllegalArgumentException("Numerator and denominator must be non-zero.");
        }

        while (numerator != 0) {
            long ceil = (long) Math.ceil((double) denominator / numerator);
            fractions.add(ceil);
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;
        }

        return fractions;
    }
}
