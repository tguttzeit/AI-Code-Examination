class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator
        self.egyptian_fractions = []

    def build(self):
        while self.numerator != 0:
            self.egyptian_fractions.append(self.denominator // self.numerator)
            self.numerator = self.denominator % self.numerator
            self.numerator, self.denominator = self.denominator, self.numerator
        return self.egyptian_fractions
