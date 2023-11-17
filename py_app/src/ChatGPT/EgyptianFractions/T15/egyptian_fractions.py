from fractions import Fraction

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")
        
        result = []
        while numerator != 0:
            frac = Fraction(1, -(-denominator // numerator))  # Calculate the next unit fraction
            result.append(frac)  # Add the unit fraction to the result
            numerator, denominator = (-denominator) % numerator, denominator * frac.denominator  # Update numerator and denominator

        return result
