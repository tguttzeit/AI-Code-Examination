from math import ceil

class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive.")

        while numerator != 0:
            fraction_denominator = ceil(denominator / numerator)
            self.fractions.append(fraction_denominator)
            numerator = numerator * fraction_denominator - denominator
            denominator = denominator * fraction_denominator

        return self.fractions