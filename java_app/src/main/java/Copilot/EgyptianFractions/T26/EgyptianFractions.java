package Copilot.EgyptianFractions.T26;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> output = new ArrayList<Long>();
        long num = numerator;
        long den = denominator;
        while (num > 0) {
            long nextDen = (den + num - 1) / num;
            output.add(nextDen);
            num = num * nextDen - den;
            den = den * nextDen;
        }
        return output;
    }
}
