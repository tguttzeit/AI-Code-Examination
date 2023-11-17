from math import ceil

class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Numerator and denominator must be positive integers.")

        while numerator > 0:
            # Find the smallest unit fraction that is less than or equal to numerator/denominator.
            unit_denominator = ceil(denominator / numerator)
            self.fractions.append(unit_denominator)

            # Subtract 1/unit_denominator from numerator/denominator.
            numerator = numerator * unit_denominator - denominator
            denominator = denominator * unit_denominator

        return self.fractions
