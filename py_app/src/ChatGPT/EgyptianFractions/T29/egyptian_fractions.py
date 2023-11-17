import math

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")

        fractions = []
        while numerator != 0:
            fraction = math.ceil(denominator / numerator)
            fractions.append(fraction)
            numerator = numerator * fraction - denominator
            denominator *= fraction

        return fractions
