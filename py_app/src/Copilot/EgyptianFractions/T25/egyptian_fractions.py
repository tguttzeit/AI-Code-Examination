class EgyptianFractions:
    def __init__(self, numerator, denominator):
        self.numerator = numerator
        self.denominator = denominator

    def build(self):
        fraction_list = []
        while self.numerator != 0:
            fraction = self.denominator // self.numerator
            fraction_list.append(fraction)
            self.numerator = self.numerator * fraction - self.denominator
            self.denominator = self.denominator * fraction
        return fraction_list
