package Copilot.EgyptianFractions.T43;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {     public List<Long> build(Long numerator, Long denominator) {
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
        numerator %= denominator;
    }
    Long a = denominator / numerator + 1;
    result.add(a);
    numerator = numerator * a - denominator;
    denominator = denominator * a;
    List<Long> subResult = build(numerator, denominator);
    for (Long num : subResult) {
        result.add(num);
    }
    return result;
}

}
