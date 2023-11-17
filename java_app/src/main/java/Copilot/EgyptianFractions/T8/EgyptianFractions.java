package Copilot.EgyptianFractions.T8;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> list = new ArrayList<>();
        if (numerator == 0 || denominator == 0) {
            return list;
        }
        if (denominator % numerator == 0) {
            list.add(denominator / numerator);
            return list;
        }
        if (numerator % denominator == 0) {
            list.add(numerator / denominator);
            return list;
        }
        if (numerator > denominator) {
            list.add(numerator / denominator);
            numerator %= denominator;
        }
        while (true) {
            Long temp = denominator / numerator + 1;
            list.add(temp);
            numerator = numerator * temp - denominator;
            denominator = denominator * temp;
            if (denominator % numerator == 0) {
                list.add(denominator / numerator);
                break;
            }
        }
        return list;
    }
}
