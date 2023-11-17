from fractions import Fraction

class EgyptianFractions:
    def __init__(self):
        pass

    @staticmethod
    def build(numerator, denominator):
        fractions = []
        
        while numerator != 0:
            # Find the largest unit fraction (1/x) such that 1/x is less than or equal to the remaining fraction.
            unit_fraction = Fraction(1, denominator // numerator + 1)
            fractions.append(unit_fraction)
            
            # Update the remaining numerator and denominator
            numerator = numerator * unit_fraction.denominator - denominator * unit_fraction.numerator
            denominator = denominator * unit_fraction.denominator
        
        return fractions
