class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        result = []
        while numerator != 0:
            if numerator == 1:
                result.append(denominator)
                break
            div = denominator // numerator
            result.append(div)
            numerator = numerator * div - denominator
            denominator = denominator * div
        return result