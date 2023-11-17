class EgyptianFractions:
    @staticmethod
    def gcd(a, b):
        while b:
            a, b = b, a % b
        return a

    @classmethod
    def build(cls, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive")

        result = []

        while numerator > 0:
            # Find the smallest unit fraction such that 1/x <= numerator/denominator
            unit_denominator = denominator // numerator + 1
            result.append(unit_denominator)

            # Calculate the new numerator and denominator
            numerator = numerator * unit_denominator - denominator
            denominator *= unit_denominator

            # Simplify the fraction
            gcd_value = cls.gcd(numerator, denominator)
            numerator //= gcd_value
            denominator //= gcd_value

        return result
