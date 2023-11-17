package Copilot.EgyptianFractions.T31;

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
            Long temp = numerator / denominator;
            result.add(temp);
            numerator -= temp * denominator;
        }
        Long temp = gcd(numerator, denominator);
        numerator /= temp;
        denominator /= temp;
        Long temp1 = denominator / numerator + 1;
        result.add(temp1);
        numerator = numerator * temp1 - denominator;
        denominator = denominator * temp1;
        temp = gcd(numerator, denominator);
        numerator /= temp;
        denominator /= temp;
        while (numerator != 1) {
            temp1 = denominator / numerator + 1;
            result.add(temp1);
            numerator = numerator * temp1 - denominator;
            denominator = denominator * temp1;
            temp = gcd(numerator, denominator);
            numerator /= temp;
            denominator /= temp;
        }
        return result;
    }
    private Long gcd(Long a, Long b) {
        if (a == 0 || b == 0) {
            return 1L;
        }
        while (b != 0) {
            Long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
