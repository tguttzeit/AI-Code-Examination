from fractions import Fraction

class EgyptianFractions:
    def build(self, numerator, denominator):
        result = []
        while numerator != 0:
            x = -(-denominator // numerator)  # Ceiling division
            result.append(Fraction(1, x))
            numerator = numerator * x - denominator
            denominator = denominator * x
        return result
