import math

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        fractions = []
        
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator should be positive integers.")
        
        while numerator > 0:
            # Find the largest unit fraction (1/x) that is smaller than or equal to numerator/denominator
            unit_denominator = math.ceil(denominator / numerator)
            fractions.append(unit_denominator)
            
            # Subtract 1/unit_denominator from the current numerator/denominator
            numerator = numerator * unit_denominator - denominator
            denominator = denominator * unit_denominator
            
            # Simplify the numerator/denominator by finding the greatest common divisor (GCD)
            gcd = math.gcd(numerator, denominator)
            numerator //= gcd
            denominator //= gcd
        
        return fractions
