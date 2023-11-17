class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator
        self.egyptian_fractions = []

    def build(self):
        while self.numerator != 0:
            unit_fraction = (self.denominator + self.numerator - 1) // self.numerator
            self.egyptian_fractions.append(unit_fraction)
            self.numerator = self.numerator * unit_fraction - self.denominator
            self.denominator = self.denominator * unit_fraction
        return self.egyptian_fractions