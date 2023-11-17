class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator

    def build(self):
        result = []
        while self.numerator != 0:
            x = self.denominator // self.numerator
            result.append(x)
            self.numerator = self.numerator * x - self.denominator
            self.denominator = self.denominator * x
            gcd = self.gcd(self.numerator, self.denominator)
            self.numerator = self.numerator // gcd
            self.denominator = self.denominator // gcd
        return result

    def gcd(self, a, b):
        if a == 0:
            return b
        return self.gcd(b % a, a)