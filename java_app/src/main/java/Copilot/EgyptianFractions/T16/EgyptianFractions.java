package Copilot.EgyptianFractions.T16;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<Long>();
        while (numerator != 0) {
            Long fractionDenominator = (long) Math.ceil((double) denominator / numerator);
            fractions.add(fractionDenominator);
            numerator = numerator * fractionDenominator - denominator;
            denominator = denominator * fractionDenominator;
        }
        return fractions;
    }
}
