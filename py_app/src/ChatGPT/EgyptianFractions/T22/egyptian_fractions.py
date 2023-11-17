class EgyptianFractions:
    @staticmethod
    def gcd(a, b):
        while b:
            a, b = b, a % b
        return a

    @classmethod
    def build(cls, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive integers.")
        
        fractions = []

        while numerator != 0:
            # Find the smallest unit fraction that is less than or equal to numerator/denominator
            unit_denominator = denominator // numerator + 1
            unit_numerator = 1

            # Calculate the gcd of the numerator and denominator of the unit fraction
            common_divisor = cls.gcd(unit_numerator, unit_denominator)

            # Add the unit fraction to the list
            fractions.append((unit_numerator // common_divisor, unit_denominator // common_divisor))

            # Update numerator and denominator for the next iteration
            numerator = numerator * unit_denominator - denominator
            denominator = denominator * unit_denominator

        return fractions
