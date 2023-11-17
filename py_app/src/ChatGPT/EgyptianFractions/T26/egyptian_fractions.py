class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator should be positive integers.")
        
        while numerator != 0:
            unit_fraction_denominator = (denominator + numerator - 1) // numerator
            self.fractions.append(unit_fraction_denominator)
            numerator = numerator * unit_fraction_denominator - denominator
            denominator *= unit_fraction_denominator

        return self.fractions
