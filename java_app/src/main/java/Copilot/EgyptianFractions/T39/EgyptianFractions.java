package Copilot.EgyptianFractions.T39;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        ArrayList<Long> result = new ArrayList<Long>();
        if (denominator%numerator == 0) {
            result.add(denominator/numerator);
            return result;
        }
        long n = denominator/numerator + 1;
        result.add(n);
        List<Long> subResult = build(numerator*n - denominator, denominator*n);
        result.addAll(subResult);
        return result;
    }
}
