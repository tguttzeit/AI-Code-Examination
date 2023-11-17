from math import ceil

class EgyptianFractions:
    def __init__(self):
        pass

    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator should be positive integers.")

        result = []
        while numerator > 0:
            fraction = ceil(denominator / numerator)
            result.append(fraction)
            numerator = numerator * fraction - denominator
            denominator = denominator * fraction

        return result