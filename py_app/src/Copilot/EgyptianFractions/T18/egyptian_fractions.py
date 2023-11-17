class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        # write your code here
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator // denominator]
        if numerator < denominator:
            return [1] + self.build(numerator - 1, denominator)
        else:
            a = numerator // denominator
            b = numerator % denominator
            return [a] + self.build(b, denominator * a)
