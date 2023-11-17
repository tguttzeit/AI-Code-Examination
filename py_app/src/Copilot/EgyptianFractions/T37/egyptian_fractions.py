class EgyptianFractions:
    def __init__(self, num, den):
        self.num = num
        self.den = den

    def build(self):
        result = []
        while self.num != 0:
            x = self.den // self.num
            result.append(x)
            self.num = self.num * x - self.den
            self.den = self.den * x
        return result