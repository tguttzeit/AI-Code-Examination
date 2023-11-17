package Copilot.EgyptianFractions.T50;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {

    public List<Long> build(Long numerator, Long denominator) {
        List<Long> fractions = new ArrayList<>();
        if (numerator == 0 || denominator == 0) {
            return fractions;
        }
        if (numerator % denominator == 0) {
            fractions.add(numerator / denominator);
            return fractions;
        }
        if (numerator > denominator) {
            fractions.add(numerator / denominator);
            numerator = numerator % denominator;
        }
        Long gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        fractions.add(denominator / numerator + 1);
        fractions.addAll(build(numerator - denominator % numerator, denominator * (denominator / numerator + 1)));
        return fractions;
    }

    private Long gcd(Long a, Long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
