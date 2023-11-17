package Copilot.EgyptianFractions.T38;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        Long numerator1 = numerator;
        Long denominator1 = denominator;
        while (numerator1 != 0) {
            Long temp = denominator1 / numerator1 + 1;
            result.add(temp);
            numerator1 = numerator1 * temp - denominator1;
            denominator1 = denominator1 * temp;
        }
        return result;
    }

}
