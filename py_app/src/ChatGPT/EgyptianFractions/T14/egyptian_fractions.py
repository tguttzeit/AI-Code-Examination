from fractions import Fraction

class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")
        
        while numerator != 0:
            unit_fraction = Fraction(1, (denominator // numerator) + 1)
            self.fractions.append(unit_fraction)
            numerator, denominator = (
                numerator * unit_fraction.denominator - unit_fraction.numerator,
                denominator * unit_fraction.denominator,
            )
        
        return [str(f) for f in self.fractions]
