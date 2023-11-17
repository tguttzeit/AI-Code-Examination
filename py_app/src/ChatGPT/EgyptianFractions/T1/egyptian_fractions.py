from math import ceil

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive.")

        fractions = []
        while numerator > 0:
            fraction = ceil(denominator / numerator)
            fractions.append(fraction)
            numerator = numerator * fraction - denominator
            denominator = denominator * fraction
        
        return fractions
