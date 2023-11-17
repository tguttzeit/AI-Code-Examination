class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator

    def build(self):
        fractions = []
        while self.numerator != 0:
            x = self.denominator // self.numerator
            fractions.append(x)
            self.numerator = self.numerator * x - self.denominator
            self.denominator = self.denominator * x
        return fractions