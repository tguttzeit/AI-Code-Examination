class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Numerator and denominator must be positive integers.")
        if numerator > denominator:
            raise ValueError("Numerator must be less than or equal to the denominator.")
        
        while numerator != 0:
            fraction = (denominator + numerator - 1) // numerator
            self.fractions.append(fraction)
            numerator = numerator * fraction - denominator
            denominator *= fraction
        
        return self.fractions
