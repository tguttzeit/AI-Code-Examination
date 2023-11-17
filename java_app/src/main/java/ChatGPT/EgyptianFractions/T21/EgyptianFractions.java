package ChatGPT.EgyptianFractions.T21;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();

        if (numerator == 0 || denominator == 0) {
            throw new IllegalArgumentException("Both numerator and denominator must be non-zero.");
        }

        while (numerator > 0) {
            Long ceil = (long) Math.ceil((double) denominator / numerator);
            result.add(ceil);
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;
        }

        return result;
    }
}
