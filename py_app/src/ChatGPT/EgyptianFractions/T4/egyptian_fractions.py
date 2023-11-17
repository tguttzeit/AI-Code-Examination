from fractions import Fraction

class EgyptianFractions:
    def __init__(self):
        self.egyptian_fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")

        while numerator != 0:
            unit_fraction = Fraction(1, denominator // numerator + 1)
            self.egyptian_fractions.append(unit_fraction)
            numerator = numerator * unit_fraction.denominator - unit_fraction.numerator
            denominator = denominator * unit_fraction.denominator

        return [str(fraction) for fraction in self.egyptian_fractions]

