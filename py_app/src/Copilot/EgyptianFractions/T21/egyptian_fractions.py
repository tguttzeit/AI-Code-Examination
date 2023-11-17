class EgyptianFractions:
    def __init__(self):
        self.res = []

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return
        if numerator % denominator == 0:
            self.res.append(numerator // denominator)
            return

        if denominator % numerator == 0:
            self.res.append("1/" + str(denominator // numerator))
            return

        if numerator > denominator:
            self.res.append(numerator // denominator)
            self.build(numerator % denominator, denominator)
            return

        ceil = denominator // numerator + 1
        self.res.append("1/" + str(ceil))
        self.build(numerator * ceil - denominator, denominator * ceil)
        return

    def get_result(self):
        return self.res
