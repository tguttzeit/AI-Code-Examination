class EgyptianFractions:
    def __init__(self):
        pass

    def build(self, numerator, denominator):
        result = []
        if numerator == 0 or denominator == 0:
            return result
        if numerator % denominator == 0:
            result.append(numerator // denominator)
        else:
            result.append(numerator // denominator + 1)
            temp = numerator % denominator
            temp1 = denominator
            while temp != 0:
                temp2 = temp1 // temp + 1
                result.append(temp2)
                temp = temp2 * temp - temp1
                temp1 = temp1 * temp2
        return result