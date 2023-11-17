package Copilot.EgyptianFractions.T11;

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
        if (numerator < denominator) {
            result.add(1L);
            List<Long> next = build(denominator, denominator - numerator);
            for (Long num : next) {
                result.add(num);
            }
            return result;
        }
        Long next = numerator / denominator + 1;
        result.add(next);
        List<Long> nextResult = build(numerator - next * denominator, denominator * next);
        for (Long num : nextResult) {
            result.add(num);
        }
        return result;
    }
}
