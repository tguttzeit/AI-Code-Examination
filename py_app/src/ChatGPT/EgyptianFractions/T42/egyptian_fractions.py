from fractions import Fraction

class EgyptianFractions:
    def build(self, numerator, denominator):
        fractions = []
        while numerator != 0:
            unit_fraction = Fraction(1, (denominator + numerator - 1) // numerator)
            fractions.append(unit_fraction)
            numerator = unit_fraction.numerator * numerator - unit_fraction.denominator * denominator
            denominator = unit_fraction.denominator * denominator
        return fractions
