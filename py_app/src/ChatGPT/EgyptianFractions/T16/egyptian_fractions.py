import math

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive.")

        result = []
        
        while numerator != 0:
            unit_fraction_denominator = math.ceil(denominator / numerator)
            result.append(f"1/{unit_fraction_denominator}")
            numerator = numerator * unit_fraction_denominator - denominator
            denominator = denominator * unit_fraction_denominator

        return result
