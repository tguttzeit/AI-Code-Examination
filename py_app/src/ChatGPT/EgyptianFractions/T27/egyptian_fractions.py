from math import ceil

class EgyptianFractions:
    def __init__(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive.")
        
        self.numerator = numerator
        self.denominator = denominator

    def build(self):
        result = []
        while self.numerator > 0:
            unit_fraction = ceil(self.denominator / self.numerator)
            result.append(1, unit_fraction)
            self.numerator = self.numerator * unit_fraction - self.denominator
            self.denominator = self.denominator * unit_fraction
        
        return result
