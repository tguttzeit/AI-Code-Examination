from fractions import Fraction

class EgyptianFractions:
    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")

        result = []
        while numerator != 0:
            # Find the smallest unit fraction that is less than or equal to the given fraction
            unit_fraction = Fraction(1, denominator // numerator + 1)
            
            # Append the unit fraction to the result list
            result.append(unit_fraction)
            
            # Subtract the unit fraction from the given fraction
            numerator, denominator = (numerator * unit_fraction.denominator - unit_fraction.numerator), (denominator * unit_fraction.denominator)

        return result
