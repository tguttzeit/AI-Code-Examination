class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return None
        if numerator % denominator == 0:
            return [numerator // denominator]

        if numerator > denominator:
            result = [numerator // denominator]
            numerator = numerator % denominator
        else:
            result = []

        while numerator != 1:
            tmp = denominator // numerator + 1
            result.append(tmp)
            numerator = numerator * tmp - denominator
            denominator = denominator * tmp

        result.append(denominator)
        return result