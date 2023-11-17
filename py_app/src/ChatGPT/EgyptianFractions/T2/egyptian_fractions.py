from math import ceil

class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")

        while numerator != 0:
            # Find the smallest unit fraction that is less than or equal to numerator/denominator
            unit_denominator = ceil(denominator / numerator)
            
            # Add the unit fraction to the list
            self.fractions.append(unit_denominator)
            
            # Update the numerator and denominator
            numerator = numerator * unit_denominator - denominator
            denominator *= unit_denominator
        
        return self.fractions

