class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        result = []
        while numerator != 0:
            x = denominator // numerator
            result.append(x)
            numerator = x * numerator - denominator
            denominator = denominator * x
            if numerator == 1:
                result.append(denominator)
                break
        return result