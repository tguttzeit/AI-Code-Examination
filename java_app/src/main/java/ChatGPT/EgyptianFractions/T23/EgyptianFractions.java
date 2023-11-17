package ChatGPT.EgyptianFractions.T23;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();

        while (numerator > 0) {
            long ceilValue = (long) Math.ceil((double) denominator / numerator);
            fractions.add(ceilValue);
            numerator = numerator * ceilValue - denominator;
            denominator = denominator * ceilValue;
        }

        return fractions;
    }
}
