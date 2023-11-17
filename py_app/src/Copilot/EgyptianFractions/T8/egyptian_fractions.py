class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator
        self.result = []

    def build(self):
        while self.numerator % self.denominator != 0:
            self.result.append(self.numerator // self.denominator + 1)
            self.numerator = self.numerator * (self.numerator // self.denominator + 1) - self.denominator
            self.denominator = self.denominator * (self.numerator // self.denominator + 1)
        self.result.append(self.numerator // self.denominator)
        return self.result