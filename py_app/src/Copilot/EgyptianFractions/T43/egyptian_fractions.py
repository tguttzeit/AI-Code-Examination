class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []

        if numerator % denominator == 0:
            return [numerator // denominator]

        if numerator > denominator:
            fraction = numerator // denominator
            return [fraction] + self.build(numerator - fraction * denominator, denominator)

        fraction = denominator // numerator
        return [1 // fraction] + self.build(numerator * fraction - denominator, denominator * fraction)