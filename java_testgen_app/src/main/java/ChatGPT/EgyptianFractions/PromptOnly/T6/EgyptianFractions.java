package ChatGPT.EgyptianFractions.PromptOnly.T6;

// Source: https://github.com/TrainingByPackt/Data-Structures-and-Algorithms-in-Java/blob/master/src/main/java/com/packt/datastructuresandalg/lesson4/activity/egyptian/solution/EgyptianFractions.java

import java.util.ArrayList;
import java.util.List;

public class EgyptianFractions {
    public List<Long> build(Long numerator, Long denominator) {
        if (numerator == 0 || denominator == 0)
            return new ArrayList<>();

        if (denominator % numerator == 0) {
            List<Long> l = new ArrayList<>();
            l.add(denominator / numerator);
            return l;
        }

        Long n = denominator / numerator + 1;
        List<Long> r = build(numerator * n - denominator, denominator * n);
        r.add(0, n);
        return r;
    }
}
