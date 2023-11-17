class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator
        self.egyptian_fractions = []

    def build(self):
        while self.numerator != 0:
            x = self.denominator // self.numerator
            self.egyptian_fractions.append(x)
            self.numerator = self.numerator * x - self.denominator
            self.denominator = self.denominator * x
        return self.egyptian_fractions