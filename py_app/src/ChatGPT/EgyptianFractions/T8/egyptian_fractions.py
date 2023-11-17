class EgyptianFractions:
    def __init__(self):
        self.result = []

    @staticmethod
    def gcd(a, b):
        while b:
            a, b = b, a % b
        return a

    def build(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise ValueError("Both numerator and denominator must be positive.")

        if numerator > denominator:
            whole_part = numerator // denominator
            self.result.append(whole_part)
            numerator -= whole_part * denominator

        while numerator > 0:
            x = -(-denominator // numerator)  # Ceiling division
            self.result.append(x)
            numerator = numerator * x - denominator
            gcd_val = self.gcd(numerator, denominator)
            numerator //= gcd_val
            denominator //= gcd_val

        return self.result

