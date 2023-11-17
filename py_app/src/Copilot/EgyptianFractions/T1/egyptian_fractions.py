class EgyptianFractions:
    def __init__(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            raise ZeroDivisionError
        self.numerator = numerator
        self.denominator = denominator
        self.result = []

    def build(self):
        while self.numerator != 0:
            if self.denominator % self.numerator == 0:
                self.result.append(self.denominator // self.numerator)
                break
            self.result.append(self.denominator // self.numerator + 1)
            self.numerator = self.numerator * (self.denominator // self.numerator + 1) - self.denominator
            self.denominator = self.denominator * (self.denominator // self.numerator + 1)
            self.numerator, self.denominator = self.denominator, self.numerator
        return self.result