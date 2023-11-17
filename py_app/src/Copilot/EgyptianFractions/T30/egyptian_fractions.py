class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator // denominator]
        if numerator > denominator:
            result = [numerator // denominator]
            result.extend(self.build(numerator % denominator, denominator))
            return result
        else:
            result = [denominator // numerator + 1]
            result.extend(self.build(numerator * (denominator // numerator + 1) - denominator, denominator * (denominator // numerator + 1)))
            return result