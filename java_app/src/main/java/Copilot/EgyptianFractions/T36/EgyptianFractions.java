package Copilot.EgyptianFractions.T36;

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
            numerator %= denominator;
        }
        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        result.add(denominator / numerator + 1);
        numerator = numerator * (denominator / numerator + 1) - denominator;
        denominator *= denominator / numerator + 1;
        while (numerator != 1) {
            gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            result.add(denominator / numerator + 1);
            numerator = numerator * (denominator / numerator + 1) - denominator;
            denominator *= denominator / numerator + 1;
        }
        return result;
    }
    private long gcd(long a, long b) {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
