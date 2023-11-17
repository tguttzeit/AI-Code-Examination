from fractions import Fraction

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")

        result = []
        while numerator != 0:
            if numerator == 1:
                result.append(Fraction(1, denominator))
                break
            unit_fraction = Fraction(1, (denominator + numerator - 1) // numerator)
            result.append(unit_fraction)
            numerator = unit_fraction.numerator * numerator - unit_fraction.denominator * denominator
            denominator = denominator * unit_fraction.denominator
        
        return result

