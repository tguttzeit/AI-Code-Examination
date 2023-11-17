from fractions import Fraction

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        fractions = []
        
        while numerator != 0:
            unit_fraction = Fraction(1, (denominator + numerator - 1) // numerator)
            fractions.append(unit_fraction)
            numerator = numerator * unit_fraction.denominator - unit_fraction.numerator
            denominator = denominator * unit_fraction.denominator
        
        return fractions
