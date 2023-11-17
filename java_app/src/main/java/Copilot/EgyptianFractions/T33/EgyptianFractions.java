package Copilot.EgyptianFractions.T33;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        if (numerator == 0 || denominator == 0) {
            return result;
        }
        //Find the largest integer that is smaller than numerator/denominator
        long largestInt = (long) Math.floor((double) numerator / (double) denominator);
        result.add(largestInt);
        //Find the egyptian fractions of the remainder
        List<Long> subResult = build(numerator * denominator - denominator * largestInt, denominator * numerator);
        //Add the results of the sub problem
        for (Long subFraction : subResult) {
            result.add(subFraction);
        }
        return result;
    }
}
