from math import ceil

class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")
        
        while numerator > 0:
            unit_fraction_denominator = ceil(denominator / numerator)
            self.fractions.append(f"1/{unit_fraction_denominator}")
            numerator = numerator * unit_fraction_denominator - denominator
            denominator = denominator * unit_fraction_denominator
        
        return self.fractions
