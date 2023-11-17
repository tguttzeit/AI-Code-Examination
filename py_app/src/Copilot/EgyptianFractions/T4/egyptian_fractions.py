class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator / denominator]
        if denominator % numerator == 0:
            return [1 / denominator]
        if numerator > denominator:
            return [numerator // denominator] + self.build(numerator % denominator, denominator)
        a = denominator // numerator + 1
        return [1 / a] + self.build(numerator * a - denominator, denominator * a)
