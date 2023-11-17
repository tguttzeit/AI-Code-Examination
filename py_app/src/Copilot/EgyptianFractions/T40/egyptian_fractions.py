class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        result = []
        if numerator == 0 or denominator == 0:
            return result
        if numerator % denominator == 0:
            result.append(numerator // denominator)
            return result
        if denominator % numerator == 0:
            result.append(1)
            result.append(denominator // numerator)
            return result
        if numerator > denominator:
            result.append(numerator // denominator)
            result.extend(self.build(numerator % denominator, denominator))
            return result
        next_denominator = denominator // numerator + 1
        result.append(1)
        result.extend(self.build(numerator * next_denominator - denominator, denominator * next_denominator))
        return result