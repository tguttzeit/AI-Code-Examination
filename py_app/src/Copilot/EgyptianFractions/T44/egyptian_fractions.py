class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        result = []
        if numerator == 0:
            return result
        if denominator % numerator == 0:
            result.append(denominator // numerator)
            return result
        if numerator % denominator == 0:
            result.append(numerator // denominator)
            return result

        if numerator > denominator:
            result.append(numerator // denominator)
            numerator = numerator % denominator
        while numerator != 1:
            x = denominator // numerator + 1
            result.append(x)
            numerator = numerator * x - denominator
            denominator = denominator * x
        result.append(denominator)
        return result