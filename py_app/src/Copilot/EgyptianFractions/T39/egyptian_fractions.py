class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator

    def build(self):
        result = []
        while self.numerator != 0:
            if self.denominator % self.numerator == 0:
                result.append("1/" + str(self.denominator // self.numerator))
                break
            else:
                result.append("1/" + str(self.denominator // self.numerator + 1))
                self.numerator = self.numerator * (self.denominator // self.numerator + 1) - self.denominator
                self.denominator = self.denominator * (self.denominator // self.numerator + 1)
        return result