class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator
        self.result = []

    def build(self):
        if self.numerator == 0 or self.denominator == 0:
            return self.result
        else:
            self.result.append(self.denominator // self.numerator)
            self.numerator = self.numerator - (self.denominator % self.numerator)
            self.denominator = self.denominator * self.result[0]
            return self.build()