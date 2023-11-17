class BinaryToDecimal:
    def __init__(self):
        pass

    def convert_to_decimal(self, binary):
        decimal = 0
        exponent = 0
        for digit in reversed(binary):
            decimal += int(digit) * (2 ** exponent)
            exponent += 1
        return decimal
