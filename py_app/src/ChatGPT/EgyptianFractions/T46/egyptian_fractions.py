import math

class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")
        
        while numerator != 0:
            unit_fraction = math.ceil(denominator / numerator)
            self.fractions.append(unit_fraction)
            numerator = numerator * unit_fraction - denominator
            denominator = denominator * unit_fraction
        
        return self.fractions