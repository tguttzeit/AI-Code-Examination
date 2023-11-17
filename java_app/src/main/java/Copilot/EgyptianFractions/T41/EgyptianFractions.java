package Copilot.EgyptianFractions.T41;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        if (numerator == 0 || denominator == 0) {
            return result;
        }
        while (numerator != 0) {
            Long temp = denominator / numerator + 1;
            result.add(temp);
            numerator = numerator * temp - denominator;
            denominator = denominator * temp;
        }
        return result;
    }
}
