class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator

    def build(self):
        result = []
        while self.numerator != 0:
            div = (self.denominator + self.numerator - 1) // self.numerator
            result.append(div)
            self.numerator = self.numerator * div - self.denominator
            self.denominator = self.denominator * div
        return result
