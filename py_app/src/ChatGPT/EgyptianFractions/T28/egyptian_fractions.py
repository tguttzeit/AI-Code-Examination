import math

class EgyptianFractions:
    def __init__(self, numerator, denominator):
        if denominator <= 0:
            raise ValueError("Denominator must be positive.")
        if numerator >= denominator:
            raise ValueError("Numerator must be less than the denominator.")
        
        self.numerator = numerator
        self.denominator = denominator
        self.fractions = []

    def build(self):
        while self.numerator > 0:
            unit_fraction = math.ceil(self.denominator / self.numerator)
            self.fractions.append(unit_fraction)
            self.numerator = self.numerator * unit_fraction - self.denominator
            self.denominator = self.denominator * unit_fraction
        
        return self.fractions
