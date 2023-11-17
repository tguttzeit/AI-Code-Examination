class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator/denominator]
        if denominator % numerator == 0:
            return [1, denominator/numerator]
        if numerator > denominator:
            return [numerator//denominator] + self.build(numerator % denominator, denominator)
        else:
            x = denominator//numerator + 1
            return [1/x] + self.build(numerator*x - denominator, denominator*x)