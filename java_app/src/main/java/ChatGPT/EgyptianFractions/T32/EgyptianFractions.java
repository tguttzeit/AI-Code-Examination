package ChatGPT.EgyptianFractions.T32;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be positive.");
        }

        List<Long> result = new ArrayList<>();
        while (numerator > 0) {
            long ceil = (denominator + numerator - 1) / numerator;
            result.add(ceil);
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;
        }
        return result;
    }
}
