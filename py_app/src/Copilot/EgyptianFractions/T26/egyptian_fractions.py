class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []

        result = []
        while numerator != 0:
            div = denominator // numerator
            result.append(div)
            numerator = numerator * div - denominator
            denominator = denominator * div
            if denominator % numerator == 0:
                denominator = denominator // numerator
                numerator = 1

        return result