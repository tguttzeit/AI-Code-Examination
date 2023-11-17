class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator

    def __str__(self):
        return str(self.numerator) + "/" + str(self.denominator)

    def build(self):
        if self.numerator == 0 or self.denominator == 0:
            return []
        result = []
        while self.numerator != 0:
            x = int(self.denominator / self.numerator)
            result.append(x)
            self.numerator = self.numerator * x - self.denominator
            self.denominator = self.denominator * x
        return result