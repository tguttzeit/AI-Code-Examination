class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        result = []
        if numerator == 0 or denominator == 0:
            return result
        if numerator % denominator == 0:
            result.append(numerator / denominator)
            return result
        if denominator % numerator == 0:
            result.append(1)
            result.append(denominator / numerator)
            return result
        if numerator > denominator:
            result.append(numerator / denominator)
            numerator = numerator % denominator
        while numerator != 1:
            result.append(denominator / numerator)
            numerator = denominator % numerator
            denominator = denominator - numerator
        result.append(1)
        return result