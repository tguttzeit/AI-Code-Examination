package Copilot.EgyptianFractions.T47;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> result = new ArrayList<Long>();
        Long numeratorCopy = numerator;
        Long denominatorCopy = denominator;
        while (numeratorCopy != 0) {
            Long quotient = denominatorCopy / numeratorCopy;
            result.add(quotient);
            numeratorCopy = numeratorCopy - denominatorCopy * quotient;
            denominatorCopy = denominatorCopy * quotient;
            Long gcd = gcd(numeratorCopy, denominatorCopy);
            numeratorCopy = numeratorCopy / gcd;
            denominatorCopy = denominatorCopy / gcd;
        }
        return result;
    }
    private Long gcd(Long a, Long b) {
        while (b != 0) {
            Long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
