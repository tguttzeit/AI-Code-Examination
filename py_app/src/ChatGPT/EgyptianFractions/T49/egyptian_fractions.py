from math import ceil

class EgyptianFractions:
    def __init__(self, numerator, denominator):
        if denominator <= 0:
            raise ValueError("Denominator must be a positive integer")
        if numerator < 0:
            raise ValueError("Numerator must be a non-negative integer")
        self.numerator = numerator
        self.denominator = denominator

    def build(self):
        result = []
        while self.numerator != 0:
            # Find the smallest unit fraction that is less than or equal to self.numerator/self.denominator
            unit_denominator = ceil(self.denominator / self.numerator)
            # Add the unit fraction to the result list
            result.append(unit_denominator)
            # Update the numerator and denominator for the next iteration
            self.numerator = self.numerator * unit_denominator - self.denominator
            self.denominator = self.denominator * unit_denominator
            # Simplify the fraction
            gcd = self.gcd(self.numerator, self.denominator)
            self.numerator //= gcd
            self.denominator //= gcd
        return result

    def gcd(self, a, b):
        while b:
            a, b = b, a % b
        return a
