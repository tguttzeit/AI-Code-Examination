class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator // denominator]
        if numerator < denominator:
            return [1] + self.build(numerator - 1, denominator)
        else:
            return [numerator // denominator] + self.build(numerator % denominator, denominator * (numerator // denominator))

    def build2(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator // denominator]
        if numerator < denominator:
            return [1] + self.build2(denominator, denominator - numerator)
        else:
            return [numerator // denominator] + self.build2(numerator % denominator, denominator)

    def build3(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator // denominator]
        if numerator < denominator:
            return [1] + self.build3(denominator, denominator - numerator)
        else:
            return [numerator // denominator] + self.build3(numerator % denominator, denominator)

    def build4(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator // denominator]
        if numerator < denominator:
            return [1] + self.build4(denominator, denominator - numerator)
        else:
            return [numerator // denominator] + self.build4(numerator % denominator, denominator)

    def build5(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator % denominator == 0:
            return [numerator // denominator]
        if numerator < denominator:
            return [1] + self.build5(denominator, denominator - numerator)
        else:
            return [numerator // denominator] + self.build5(numerator % denominator, denominator)