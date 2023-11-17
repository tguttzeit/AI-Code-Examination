class EgyptianFractions:
    def __init__(self, numerator, denominator):
        if numerator <= 0 or denominator <= 0:
            raise Exception("Numerator and denominator must be greater than 0")

        self.numerator = numerator
        self.denominator = denominator

    def build(self):
        result = []
        while self.numerator != 0:
            x = self.denominator // self.numerator
            result.append(x)

            self.numerator = self.numerator * x - self.denominator
            self.denominator = self.denominator * x

        return result