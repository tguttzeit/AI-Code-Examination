package Copilot.EgyptianFractions.T19;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> list = new ArrayList<Long>();
        if (numerator == 0 || denominator == 0) {
            return list;
        }
        if (numerator % denominator == 0) {
            list.add(numerator / denominator);
            return list;
        }
        if (numerator > denominator) {
            list.add(numerator / denominator);
            list.addAll(build(numerator % denominator, denominator));
            return list;
        }
        Long nextDenominator = denominator / numerator + 1;
        list.add(nextDenominator);
        list.addAll(build(numerator * nextDenominator - denominator, denominator * nextDenominator));
        return list;
    }
}
