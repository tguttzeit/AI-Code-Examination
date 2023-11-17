import math

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")

        result = []

        while numerator != 0:
            # Find the smallest unit fraction (1/x) where x is the smallest integer greater than or equal to denominator/numerator
            unit_denominator = math.ceil(denominator / numerator)
            result.append(f"1/{unit_denominator}")

            # Subtract 1/x from the original fraction (numerator/denominator)
            numerator = numerator * unit_denominator - denominator
            denominator = denominator * unit_denominator

            # Simplify the fraction if possible
            gcd = math.gcd(numerator, denominator)
            numerator //= gcd
            denominator //= gcd

        return result