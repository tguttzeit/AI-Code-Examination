class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        if numerator == 0 or denominator == 0:
            return []
        if numerator%denominator == 0:
            return [numerator//denominator]
        if numerator%denominator != 0:
            fraction = []
            fraction.append(numerator//denominator)
            numerator = numerator%denominator
            while numerator != 0:
                denominator = denominator//numerator + 1
                fraction.append(denominator)
                numerator = numerator*denominator - denominator
            return fraction