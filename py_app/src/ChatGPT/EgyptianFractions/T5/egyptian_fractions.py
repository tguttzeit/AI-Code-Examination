from fractions import Fraction

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        result = []
        while numerator != 0:
            # Find the largest unit fraction (1/x) that is less than or equal to numerator/denominator.
            unit_fraction = Fraction(1, (denominator + numerator - 1) // numerator)
            
            # Append the unit fraction to the result.
            result.append(unit_fraction)
            
            # Update numerator and denominator for the next iteration.
            numerator = numerator * unit_fraction.denominator - unit_fraction.numerator
            denominator = denominator * unit_fraction.denominator
        
        return result

