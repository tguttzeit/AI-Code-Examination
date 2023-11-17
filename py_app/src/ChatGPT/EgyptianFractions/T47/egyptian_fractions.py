from math import ceil

class EgyptianFractions:
    @staticmethod
    def build(numerator, denominator):
        fractions = []

        while numerator != 0:
            # Find the smallest unit fraction that is less than or equal to numerator/denominator.
            unit_denominator = ceil(denominator / numerator)
            
            # Add this unit fraction to the list.
            fractions.append(unit_denominator)
            
            # Update the numerator and denominator.
            numerator = numerator * unit_denominator - denominator
            denominator = denominator * unit_denominator

        return fractions