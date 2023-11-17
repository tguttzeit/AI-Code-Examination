package Copilot.EgyptianFractions.T23;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        if (numerator == 0 || denominator == 0) {
            return result;
        }
        if (numerator % denominator == 0) {
            result.add(numerator / denominator);
            return result;
        }
        if (numerator > denominator) {
            result.add(numerator / denominator);
            numerator = numerator % denominator;
        }
        while (numerator != 1) {
            long temp = denominator / numerator + 1;
            result.add(temp);
            numerator = numerator * temp - denominator;
            denominator = denominator * temp;
        }
        result.add(denominator);
        return result;
    }

}
