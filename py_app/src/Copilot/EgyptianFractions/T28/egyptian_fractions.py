class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        result = []
        while numerator != 0:
            x = denominator // numerator
            result.append(x)
            numerator = numerator * x - denominator
            denominator = denominator * x
        return result
