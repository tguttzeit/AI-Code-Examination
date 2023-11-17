package ChatGPT.EgyptianFractions.T6;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();

        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator should be positive.");
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
