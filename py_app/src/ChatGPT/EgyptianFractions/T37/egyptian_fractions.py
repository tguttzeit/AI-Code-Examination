import math

class EgyptianFractions:
    def __init__(self):
        pass

    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")

        result = []
        while numerator != 0:
            div = math.ceil(denominator / numerator)
            result.append(1, div)
            numerator = numerator * div - denominator
            denominator = denominator * div

        return result
