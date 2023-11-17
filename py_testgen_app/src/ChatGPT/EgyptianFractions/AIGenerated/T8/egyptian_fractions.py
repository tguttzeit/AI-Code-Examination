from math import ceil

class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")

        while numerator > 0:
            # Find the smallest unit fraction that is less than or equal to numerator/denominator
            unit_denominator = ceil(denominator / numerator)
            
            # Add 1/(unit_denominator) to the list of fractions
            self.fractions.append(unit_denominator)
            
            # Update numerator and denominator for the next iteration
            numerator = numerator * unit_denominator - denominator
            denominator *= unit_denominator
        
        return self.fractions
