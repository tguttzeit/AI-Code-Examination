package Copilot.EgyptianFractions.T2;

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        List<Long> list = new ArrayList<Long>();
        while(numerator != 1){
            Long x = (denominator + numerator - 1) / numerator;
            list.add(x);
            numerator = numerator * x - denominator;
            denominator = denominator * x;
        }
        list.add(denominator);
        return list;
    }
}
