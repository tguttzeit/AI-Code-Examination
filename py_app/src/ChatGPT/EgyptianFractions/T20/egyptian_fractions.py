from fractions import Fraction

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        fractions = []
        
        while numerator != 0:
            fraction = Fraction(1, (denominator // numerator) + 1)
            fractions.append(fraction)
            numerator = fraction.numerator * numerator - fraction.denominator * denominator
            denominator = fraction.denominator * denominator
        
        return fractions
