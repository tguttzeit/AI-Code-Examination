import math

class EgyptianFractions:
    def __init__(self):
        pass

    @staticmethod
    def build(numerator, denominator):
        fractions = []
        while numerator > 0:
            fraction_denominator = math.ceil(denominator / numerator)
            fractions.append(fraction_denominator)
            numerator = numerator * fraction_denominator - denominator
            denominator = denominator * fraction_denominator
        return fractions
