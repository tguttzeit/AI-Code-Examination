from math import ceil

class EgyptianFractions:
    def __init__(self):
        pass

    @staticmethod
    def gcd(a, b):
        while b:
            a, b = b, a % b
        return a

    @classmethod
    def build(cls, numerator, denominator):
        fractions = []
        
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")
        
        while numerator > 0:
            # Calculate the next fraction
            fraction_denominator = ceil(denominator / numerator)
            fractions.append(fraction_denominator)
            
            # Update the numerator and denominator
            numerator = numerator * fraction_denominator - denominator
            denominator = denominator * fraction_denominator
            
            # Simplify the fraction
            common_divisor = cls.gcd(numerator, denominator)
            numerator //= common_divisor
            denominator //= common_divisor
        
        return fractions

