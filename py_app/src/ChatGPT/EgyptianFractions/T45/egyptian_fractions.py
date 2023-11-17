from fractions import Fraction

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        egyptian_fractions = []
        while numerator != 0:
            unit_fraction = Fraction(1, (denominator + numerator - 1) // numerator)  # Compute the unit fraction
            egyptian_fractions.append(unit_fraction)  # Add it to the list
            numerator, denominator = (numerator * unit_fraction.denominator) - (unit_fraction.numerator * denominator), (denominator * unit_fraction.denominator)  # Update numerator and denominator
        
        return egyptian_fractions

