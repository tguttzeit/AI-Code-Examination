import math

class EgyptianFractions:
    def __init__(self):
        pass

    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")

        fractions = []
        while numerator != 0:
            # Calculate the next unit fraction
            unit_denominator = math.ceil(denominator / numerator)
            fractions.append(unit_denominator)

            # Subtract 1 / unit_denominator from the original fraction
            numerator = numerator * unit_denominator - denominator
            denominator *= unit_denominator

            # Simplify the fraction
            gcd = math.gcd(numerator, denominator)
            numerator //= gcd
            denominator //= gcd

        return fractions
