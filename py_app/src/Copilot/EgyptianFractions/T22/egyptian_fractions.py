class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator // denominator]
        if numerator > denominator:
            return [numerator // denominator] + self.build(numerator % denominator, denominator)
        else:
            next_denominator = denominator // numerator + 1
            next_numerator = numerator * next_denominator - denominator
            return [next_denominator] + self.build(next_numerator, denominator * next_denominator)