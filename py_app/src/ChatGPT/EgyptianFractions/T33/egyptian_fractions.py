from fractions import Fraction

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        result = []
        while numerator != 0:
            unit_fraction = Fraction(1, (denominator + numerator - 1) // numerator)
            result.append(unit_fraction)
            numerator = numerator * unit_fraction.denominator - denominator * unit_fraction.numerator
            denominator = denominator * unit_fraction.denominator
        
        return result
