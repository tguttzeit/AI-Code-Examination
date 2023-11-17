class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        egyptian_fractions = []
        while numerator != 0:
            x = int(denominator / numerator)
            egyptian_fractions.append(x)
            numerator = x * numerator - denominator
            denominator = denominator * x
            gcd = self.gcd(numerator, denominator)
            numerator = int(numerator / gcd)
            denominator = int(denominator / gcd)
        return egyptian_fractions

    def gcd(self, a, b):
        if a == 0:
            return b
        return self.gcd(b % a, a)