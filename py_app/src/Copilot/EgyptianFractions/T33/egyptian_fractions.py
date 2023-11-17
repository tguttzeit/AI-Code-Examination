class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []

        if numerator % denominator == 0:
            return [numerator // denominator]

        if denominator % numerator == 0:
            return ['1/' + str(denominator // numerator)]

        if numerator > denominator:
            result = [numerator // denominator]
            numerator = numerator % denominator
        else:
            result = []

        while True:
            if numerator == 0:
                break

            x = denominator // numerator + 1
            result.append('1/' + str(x))
            numerator = numerator * x - denominator
            denominator = denominator * x

        return result