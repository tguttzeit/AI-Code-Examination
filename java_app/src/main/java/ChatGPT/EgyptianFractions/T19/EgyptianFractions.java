package ChatGPT.EgyptianFractions.T19;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator <= 0 || denominator <= 0) {
            throw new IllegalArgumentException("Both numerator and denominator should be positive.");
        }

        List<Long> result = new ArrayList<>();

        while (numerator > 0) {
            long ceil = (denominator + numerator - 1) / numerator; // Calculate the smallest possible fraction greater than 1
            result.add(ceil);

            // Update numerator and denominator
            numerator = numerator * ceil - denominator;
            denominator = denominator * ceil;
        }

        return result;
    }
}
