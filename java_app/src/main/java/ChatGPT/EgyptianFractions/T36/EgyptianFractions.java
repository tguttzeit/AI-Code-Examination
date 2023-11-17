package ChatGPT.EgyptianFractions.T36;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<>();

        while (numerator > 0) {
            long ceiledFraction = (long) Math.ceil((double) denominator / numerator);
            result.add(ceiledFraction);

            numerator = numerator * ceiledFraction - denominator;
            denominator = denominator * ceiledFraction;
        }

        return result;
    }
}
