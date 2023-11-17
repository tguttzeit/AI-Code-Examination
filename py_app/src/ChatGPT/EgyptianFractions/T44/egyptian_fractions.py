from fractions import Fraction

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        result = []
        while numerator != 0:
            # Find the largest unit fraction less than or equal to numerator/denominator
            unit_fraction = Fraction(1, (denominator + numerator - 1) // numerator)
            
            # Add the unit fraction to the result list
            result.append(unit_fraction)
            
            # Update the numerator and denominator for the next iteration
            numerator = unit_fraction.numerator * denominator - unit_fraction.denominator * numerator
            denominator = unit_fraction.denominator * denominator
        
        return result
