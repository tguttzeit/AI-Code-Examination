class EgyptianFractions:
    def __init__(self):
        self.fractions = []

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")

        while numerator != 0:
            # Find the smallest unit fraction that is less than or equal to numerator/denominator
            unit_denominator = -(-denominator // numerator)  # Ceiling division
            self.fractions.append(unit_denominator)

            # Subtract 1/(unit_denominator) from the current fraction
            numerator = numerator * unit_denominator - denominator
            denominator *= unit_denominator

            # Simplify the fraction by finding the greatest common divisor (GCD)
            gcd = self.gcd(numerator, denominator)
            numerator //= gcd
            denominator //= gcd

        return self.fractions

    def gcd(self, a, b):
        while b:
            a, b = b, a % b
        return a
