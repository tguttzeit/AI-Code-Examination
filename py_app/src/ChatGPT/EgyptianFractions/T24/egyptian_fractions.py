class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")

        fractions = []

        while numerator != 0:
            # Find the smallest unit fraction less than or equal to numerator/denominator
            unit_denominator = (denominator + numerator - 1) // numerator
            fractions.append(unit_denominator)
            
            # Update numerator and denominator for the next iteration
            numerator = numerator * unit_denominator - denominator
            denominator = denominator * unit_denominator

        self.fractions = fractions
        return self.fractions
