import math

class EgyptianFractions:
    def __init__(self):
        self.egyptian_fractions = []

    @staticmethod
    def gcd(a, b):
        while b:
            a, b = b, a % b
        return a

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")
        
        if numerator > denominator:
            raise ValueError("The numerator must be less than the denominator.")
        
        if numerator == denominator:
            return [1]
        
        egyptian_fractions = []
        while numerator != 0:
            x = math.ceil(denominator / numerator)
            egyptian_fractions.append(x)
            numerator = numerator * x - denominator
            denominator = denominator * x

            # Reduce the fraction to its simplest form
            gcd = self.gcd(numerator, denominator)
            numerator //= gcd
            denominator //= gcd

        self.egyptian_fractions = egyptian_fractions
        return self.egyptian_fractions
