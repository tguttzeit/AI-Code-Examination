from fractions import Fraction

class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Numerator and denominator must be positive integers.")
        
        self.fractions.clear()  # Clear any previously stored fractions

        while numerator != 0:
            # Calculate the next unit fraction and add it to the list
            unit_fraction = Fraction(1, (denominator // numerator) + 1)
            self.fractions.append(unit_fraction)

            # Update the numerator and denominator for the next iteration
            numerator = numerator * unit_fraction.denominator - denominator * unit_fraction.numerator
            denominator = denominator * unit_fraction.denominator

        return [str(f) for f in self.fractions]
