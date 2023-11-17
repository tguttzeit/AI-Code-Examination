import math

class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")
        
        while numerator != 0:
            ceil_fraction = math.ceil(denominator / numerator)
            self.fractions.append(1 / ceil_fraction)
            numerator = numerator * ceil_fraction - denominator
            denominator = denominator * ceil_fraction

        return self.fractions
